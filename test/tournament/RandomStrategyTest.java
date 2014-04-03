/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author darwin
 */
public class RandomStrategyTest {
     RandomStrategy ps;
    
    @Before
    public void initialize(){
         ps = new RandomStrategy();
    }
    /**
     * Test of getDecision method, of class RandomStrategy.
     */
    @Test
    public void testGetDecision() {
        String result = ps.getDecision();
        assertTrue(result.equals(Play.COOPERATE) || result.equals(Play.DESERTOR));
    }
    
    /**
     * Test of deepCopy method, of class RandomStrategy.
     */
    @Test
    public void test_if_deepcopy_returns_a_object_type_RandomStrategy(){
        PlayerStrategy deepCopy = ps.deepCopy();
        assertTrue(deepCopy instanceof RandomStrategy);
    }
    
    /**
     * Test of deepCopy method, of class RandomStrategy.
     */
    @Test
    public void test_if_deepcopy_returns_a_new_object_RandomStrategy(){
        PlayerStrategy deepCopy = ps.deepCopy();
        assertNotSame(ps, deepCopy);
    }
}