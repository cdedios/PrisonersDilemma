/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import tournament.Play.PlayerNotFoundException;
import tournament.Register.StrategyNotFoundException;
import tournament.UtilityMatrixImp.ElementNotExistInMatrixException;
import tournament.UtilityMatrixImp.IllegalParamException;

/**
 *
 * @author charly
 */
public class PlayTest {
    Player a,b;
    UtilityMatrix matrix;
    Play play;
    int rounds = 4;
    String aliasA = "Heisenberg";
    String aliasB = "Jessy";
    
    @Before
    public void initialize() throws StrategyNotFoundException, IllegalParamException{
        a = new PlayerImp(aliasA, "naive");        
        b = new PlayerImp(aliasB, "cocky");
        matrix = new UtilityMatrixImp(3,2,1,0);
        play = new Play(a, b, matrix, rounds);
    }
   
    @Test
    public void testGetScorePlayer() throws ElementNotExistInMatrixException, PlayerNotFoundException {
        play.executeGame();
        assertEquals(play.getScorePlayer(aliasA), 0);    
        assertEquals(play.getScorePlayer(aliasB), 12);    
    }
    
    @Test (expected = PlayerNotFoundException.class)
    public void testPlayerNotFound() throws PlayerNotFoundException, ElementNotExistInMatrixException {
        play.executeGame();
        assertEquals(play.getScorePlayer("Jaume"), 0);       
    }
}
