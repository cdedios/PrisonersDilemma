/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author darwin
 */
public class CockyStrategyTest {
    
    private final String DESERTOR = "desertar";
        
    @Test
    public void test_get_decision(){
        PlayerStrategy ps = new CockyStrategy();
        String decision = ps.getDecision();
        
        assertEquals(decision, DESERTOR);
    }
    
    @Test
    public void test_if_deepcopy_returns_a_object_type_CockyStrategy(){
        PlayerStrategy ps = new CockyStrategy();
        PlayerStrategy deepCopy = ps.deepCopy();
        assertTrue(deepCopy instanceof CockyStrategy);
    }
    
    @Test
    public void test_if_deepcopy_returns_a_new_object_CockyStrategy(){
        PlayerStrategy ps = new CockyStrategy();
        PlayerStrategy deepCopy = ps.deepCopy();
        assertNotSame(ps, deepCopy);
    }
}