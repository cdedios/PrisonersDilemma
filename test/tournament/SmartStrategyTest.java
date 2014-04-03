/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SmartStrategyTest {
    
    private SmartStrategy st;
    
    @Before
    public void initialize(){
       st = new SmartStrategy(); 
    }

    @Test
    public void test_initial_GetDecision() {
        assertEquals(st.getDecision(),Play.COOPERATE);
    }

    @Test
    public void test_more_than_10percent() {
        st.tellOponentDecision(Play.COOPERATE);
        st.tellOponentDecision(Play.DESERTOR);
        String des = st.getDecision();
        assertEquals(st.getDecision(), Play.DESERTOR);
    }
    @Test
    public void test_les_than_10percent() {
        st.tellOponentDecision(Play.COOPERATE);
        String des = st.getDecision();
        assertEquals(st.getDecision(), Play.COOPERATE);
    }
}
