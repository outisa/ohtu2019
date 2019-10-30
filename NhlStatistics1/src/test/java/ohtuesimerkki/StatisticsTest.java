package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class StatisticsTest {
  
  Reader readerStub = new Reader() {
    
    public List<Player> getPlayers() {
      ArrayList<Player> players = new ArrayList<>();
      
      players.add(new Player("Semenko", "EDM", 4, 12));
      players.add(new Player("Lemieux", "PIT", 45, 54));
      players.add(new Player("Kurri", "EDM", 37, 53));
      players.add(new Player("Yzerman", "DET", 42, 56));
      players.add(new Player("Gretzky", "EDM", 35, 89));
      
      return players;
    }

  };

  Statistics stats;

  @Before
  public void setUp() {
    stats = new Statistics(readerStub);
  }

  @Test
  public void searchReturnsPlayer() {
    Player player = stats.search("Semenko");
    assertEquals("Semenko", player.getName());
  }

  @Test
  public void searchReturnsNullNonexistingPlayer() {
    Player player = stats.search("Mehiläinen");
    assertEquals(null, player);
  }

  @Test
  public void teamListHasRightLength() {
    List<Player> players = stats.team("EDM");
  
    assertEquals(3, players.size());
  }

  @Test
  public void TeamHasRightPlayers() {
    List<Player> players = stats.team("PIT");
    assertEquals("Lemieux", players.get(0).getName());
  }

  @Test
  public void rightTopScorePlayersAreReturned() {
    List<Player> players = stats.topScorers(2);
    int control = 0;
    for(int i = 0; i<players.size(); i++) {
      if (players.get(i).getName().equals("Gretzky") || players.get(i).getName().equals("Lemieux")) {
        control++;
      }
    }
    assertEquals(2, control);
  }
}