/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tournament.Play.PlayerNotFoundException;
import tournament.UtilityMatrixImp.ElementNotExistInMatrixException;

/**
 *
 * @author carlos
 */
public class PlayDoubleTest {
    
    PlayerDouble a,b;
    UtilityMatrixDouble matrix;
    Play play;
    int rounds = 4;
    
    @Before
    public void initialize(){
        a = new PlayerDouble();
        a.setAlias("Heisenberg");        
        b = new PlayerDouble();
        b.setAlias("Jessy");
        matrix = new UtilityMatrixDouble();
        play = new Play(a, b, matrix, rounds);
    }
    
    @Test (expected = PlayerNotFoundException.class)
    public void testPlayerNotFoundException() throws ElementNotExistInMatrixException, PlayerNotFoundException {
        play.executeGame();
        play.getScorePlayer("Gustavo");        
    }
    
    @Test
    public void testCompleteRound() throws ElementNotExistInMatrixException, PlayerNotFoundException {
        play.executeGame();
        String f = a.getAlias();
        assertEquals(play.getScorePlayer(a.getAlias()), 2*rounds);
        assertEquals(play.getScorePlayer(b.getAlias()), 4*rounds);
    }
    
    private static class PlayerDouble implements Player{
        String alias;
        
        public void setAlias(String alias){
            this.alias=alias;
        }
        @Override
        public String getPlayerDecision() {
            return Play.COOPERATE;
        }

        @Override
        public void tellOponentDecision(String decision) {
      
        }

        @Override
        public String getAlias() {
            return alias;
        }

        @Override
        public void setStrategy(PlayerStrategy strategy) {
   
        }
        
    }
    private static class UtilityMatrixDouble implements UtilityMatrix{

        @Override
        public int[] getScores(String decisionPlayerA, String decisionPlayerB) throws ElementNotExistInMatrixException {
            return new int[]{2,4};
        }
    }
}
