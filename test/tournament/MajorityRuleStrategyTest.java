/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MajorityRuleStrategyTest {
    
    private PlayerStrategy psNaive;
    private PlayerStrategy psCocky;

    
    @Before
    public void setUp(){
        this.psNaive = new NaiveStrategy();
        this.psCocky = new CockyStrategy();
    }
    
    @After
    public void tearDown() {
        this.psNaive = null;
        this.psCocky = null;
    }
   
    /**
     * Test of getDecision method, of class MajorityRuleStrategy.
     */
    @Test
    public void test_if_getDecision_return_the_majority_decision_cooperate() {
        PlayerStrategy ps = new MajorityRuleStrategy();
        ((CompositeStrategy) ps).addStrategy(psNaive);
        ((CompositeStrategy) ps).addStrategy(psCocky);
        ((CompositeStrategy) ps).addStrategy(psNaive);
        
        String resultDecision = ps.getDecision();
        
        assertTrue(resultDecision.equals(Play.COOPERATE));   
    }

    /**
     * Test of getDecision method, of class MajorityRuleStrategy.
     */
    @Test
    public void test_if_getDecision_return_the_majority_decision_desertor() {
        PlayerStrategy ps = new MajorityRuleStrategy();
        ((CompositeStrategy) ps).addStrategy(psCocky);
        ((CompositeStrategy) ps).addStrategy(psCocky);
        ((CompositeStrategy) ps).addStrategy(psNaive);
        
        String resultDecision = ps.getDecision();
        
        assertTrue(resultDecision.equals(Play.DESERTOR));   
    }
    
    
}