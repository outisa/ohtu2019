
package statistics;

import statistics.matcher.*;
// Alussa kaikki tässä muodossa, ongelma -> tulosti vain ensimmäisen ehdon tai ei mitään riippuen oneOf-metodista
// muutoksella onnistui kaikki ehdot. Ongelma lähinnä se, että jos sama matcher tuli kaksi kertaa, niin ei onnistunut.'
//    public QueryBuilder hasFewerThan(int value, String category) {
//        this.matcher = new And(this.matcher, new HasFewerThan(value, category));
//        return this;
//    }
// kokeilemalla palauttaa querybuilderin luomalla uuden sellaisen, onnistuin palauttamaan halutut pelaajat, mutta aikaa
// tämä oivallus vei ihan tuhottomasti.
public class QueryBuilder {
    private Matcher matcher;
    
    public QueryBuilder() {
       matcher = new And(new All());
    }

    public QueryBuilder(Matcher matcher) {
        this.matcher = matcher;
    }
    
    public Matcher build() {
        return this.matcher;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        return new QueryBuilder(new And(this.matcher, new HasAtLeast(value, category)));
    }
    
    public QueryBuilder playsIn(String category) {
        return new QueryBuilder(new And(this.matcher, new PlaysIn(category)));
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        return new QueryBuilder(new And(this.matcher, new HasFewerThan(value, category)));
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        return new QueryBuilder(new Or(matchers));
    }
    
}
