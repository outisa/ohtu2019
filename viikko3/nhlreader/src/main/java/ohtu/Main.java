
package ohtu;

import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";  
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
        
        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);
        
        Gson mapper = new Gson();
        
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        LocalDateTime date = LocalDateTime.now();
        
        System.out.println("Players from Finland " + date);
        
        List<Player> finnishPlayers = new ArrayList<>();
        for (Player player: players) {
            if(player.getNationality().equals("FIN")) {
                finnishPlayers.add(player);
            }
        }
        
        Collections.sort(finnishPlayers);
        finnishPlayers.forEach(player -> System.out.println(player));
   }
}
