
package statistics.matcher;

import statistics.Player;

public class Not implements Matcher {
    private final HasAtLeast hasAtLeast;

    public Not(HasAtLeast hasAtLeast) {
        this.hasAtLeast = hasAtLeast;
    }
    
    @Override
    public boolean matches(Player player) {
        try {
            return !hasAtLeast.matches(player);
        } catch (SecurityException | IllegalArgumentException ex) {
            System.out.println(ex);
            throw new IllegalStateException("Well, obviosly this did not work!");
        }
    }
    
}
