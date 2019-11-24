package ohtu;

public class TennisGame {
    //Constants
    public final String POINTS_FOR_ALL = "All";
    public final String TENNIS_POINTS_ZERO= "Love";
    public final String TENNIS_POINTS_FIFTEEN = "Fifteen";
    public final String TENNIS_POINTS_THIRTY = "Thirty";
    public final String TENNIS_POINTS_FORTY = "Forty"; 
    public final String TENNIS_POINTS_DEFAULT = "Deuce";
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }    
    }

    public String getScore() {
        String score = "";
        if (m_score1==m_score2) {
            score = giveEqualScores(score);
            
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = giveNonequalScores(score);
        } else {
            for (int i=1; i < 3; i++) {
                score = giveTemporaryScores(score, i);
            }
        }
        return score;
    }

    private String giveEqualScores(String score) {
        switch (m_score1) {
            case 0:
                score = TENNIS_POINTS_ZERO + "-" + POINTS_FOR_ALL;
                break;
            case 1:
                score = TENNIS_POINTS_FIFTEEN + "-" + POINTS_FOR_ALL;
                break;
            case 2:
                score = TENNIS_POINTS_THIRTY + "-" + POINTS_FOR_ALL;
                break;
            case 3:
                score = TENNIS_POINTS_FORTY + "-" + POINTS_FOR_ALL;
                break;
            default:
                score = TENNIS_POINTS_DEFAULT;
                break; 
        }
        return score;
    }

    private String giveNonequalScores(String score) {
        int minusResult = m_score1-m_score2;
        if (minusResult==1) {
            score ="Advantage player1";
        } else if (minusResult ==-1) {
            score ="Advantage player2";
        } else if (minusResult>=2){
            score = "Win for player1";
        } else {
            score ="Win for player2";
        }
        return score;
    }

    private String giveTemporaryScores(String score, int i) {
        int tempScore=0;
        if (i==1) {
            tempScore = m_score1;
        } else {
            score+="-"; 
            tempScore = m_score2;
        }
        switch(tempScore) {
            case 0:
                score+= TENNIS_POINTS_ZERO;
                break;
            case 1:
                score+= TENNIS_POINTS_FIFTEEN;
                break;
            case 2:
                score+= TENNIS_POINTS_THIRTY;
                break;
            case 3:
                score+= TENNIS_POINTS_FORTY;
                break;
        }
        return score;
    }
}