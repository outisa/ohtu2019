
package statistics.matcher;

import java.lang.reflect.*;
import statistics.Player;

public class All implements Matcher{


    @Override
    public boolean matches(Player player) {
        try {                                    
            Method method = player.getClass().getMethod("getGoals");
            int playersValue = (Integer)method.invoke(player);
            return playersValue >=0;
            
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            System.out.println(ex);
            return false;
        }   
    }
}
