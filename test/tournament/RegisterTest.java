/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import tournament.Register.StrategyNotFoundException;

/**
 *
 * @author carlos
 */
public class RegisterTest {
       
    @Test
    public void testRegisterInitialization() throws StrategyNotFoundException {
        Register register = Register.getRegister();
        PlayerStrategy result = register.getStrategy("naive");       
        PlayerStrategy expected = new NaiveStrategy();
        
        assertEquals( (result instanceof NaiveStrategy) , (expected instanceof NaiveStrategy) );
    }
    
    @Test
    public void test_getStrategy_cocky() throws StrategyNotFoundException {
        Register register = Register.getRegister();
        PlayerStrategy result = register.getStrategy("cocky");       
        
        assertTrue(result instanceof CockyStrategy);
    }
    
    @Test
    public void test_getStrategy_smart() throws StrategyNotFoundException {
        Register register = Register.getRegister();
        PlayerStrategy result = register.getStrategy("smart");       
        
        assertTrue(result instanceof SmartStrategy);
    }
    
    @Test
    public void test_getStrategy_random() throws StrategyNotFoundException {
        Register register = Register.getRegister();
        PlayerStrategy result = register.getStrategy("random");       
        
        assertTrue(result instanceof RandomStrategy);
    }
        
    @Test
    public void test_getStrategy_MajorityRule() throws StrategyNotFoundException {
        Register register = Register.getRegister();
        PlayerStrategy result = register.getStrategy("majorityRule");       
        
        assertTrue(result instanceof MajorityRuleStrategy);
    }
    
    @Test (expected = StrategyNotFoundException.class)
    public void testStrategyNotFoundException() throws StrategyNotFoundException{
        Register register = Register.getRegister();
        PlayerStrategy ps = register.getStrategy("notValidStrategy");
    }
}
