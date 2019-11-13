
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private int goals;
    private int assists;
    private String team;
    private String nationality;

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAssists() {
        return assists;
    }

    public int getGoals() {
        return goals;
    }

    public String getNationality() {
        return nationality;
    }

    public String getTeam() {
        return team;
    }
    
    public int getPoints() {
        return this.goals + this.assists;
    }
    
    @Override
    public String toString() {
        return name + "\t" + this.getTeam() + "\t"+ this.getGoals() +
                " + " + this.getAssists() + " = " + this.getPoints(); 
    }

    @Override
    public int compareTo(Player player) {
        return player.getPoints() - this.getPoints();        
    }
      
}
