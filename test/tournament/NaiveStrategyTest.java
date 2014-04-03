/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carlos
 */
public class NaiveStrategyTest {
    

        
    @Test
    public void test_get_decision(){
        PlayerStrategy ps = new NaiveStrategy();
        String decision = ps.getDecision();
        
        assertEquals(decision, Play.COOPERATE);
    }
    
    @Test
    public void test_if_deepcopy_returns_a_object_type_NaiveStrategy(){
        PlayerStrategy ps = new NaiveStrategy();
        PlayerStrategy deepCopy = ps.deepCopy();
        assertTrue(deepCopy instanceof NaiveStrategy);
    }
    
    @Test
    public void test_if_deepcopy_returns_a_new_object_NaiveStrategy(){
        PlayerStrategy ps = new NaiveStrategy();
        PlayerStrategy deepCopy = ps.deepCopy();
        assertNotSame(ps, deepCopy);
    }
}
