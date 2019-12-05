
package statistics.matcher;

import java.lang.reflect.*;
import statistics.Player;

public class HasFewerThan implements Matcher {

    private final int value;
    private final String fieldName;

    public HasFewerThan(int value, String category) {
        this.value = value;
        fieldName = "get"+Character.toUpperCase(category.charAt(0))+category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player player) {
        try {                                    
            Method method = player.getClass().getMethod(fieldName);
            int playersValue = (Integer)method.invoke(player);
            return playersValue < value;
            
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field "+fieldName.substring(3, fieldName.length()).toLowerCase());
        }       
    }    
}
