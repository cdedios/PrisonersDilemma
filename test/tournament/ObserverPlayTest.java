/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author darwin
 */
public class ObserverPlayTest {
    
    private Play play;
    private UtilityMatrix utilMatrix;
    private Player playerA;
    private Player playerB;
    private final String COOPERATE = "cooperar";
    private final String DESERTOR = "desertar";
    
    //exemple correct values
    private final int T = 3;
    private final int R = 2;
    private final int P = 1;
    private final int S = 0;
    
    
    @Before
    public void setUp() throws UtilityMatrixImp.IllegalParamException, Register.StrategyNotFoundException {
        this.utilMatrix = new UtilityMatrixImp(3, 2, 1, 0);
        this.playerA = new PlayerImp("aliasA", "naive");
        this.playerB = new PlayerImp("aliasB", "cocky");
        
    }
    
    @After
    public void tearDown() {
        this.utilMatrix = null;
        this.playerA = null;
        this.playerB = null;         
    }

    /**
     * Test of update method, of class ObserverPlay.
     */
    @Test
    public void test_update_one_round() throws UtilityMatrixImp.ElementNotExistInMatrixException {
        ObserverPlay observer = new ObserverPlay();
        
        int rounds = 1;
        this.play = new Play(playerA, playerB, utilMatrix, rounds);
        play.addObserver(observer);
        play.executeGame();
        
        String decisionA = observer.getDecisionPlayerA();
        String decisionB = observer.getDecisionPlayerB();
        int scoreA = observer.getScorePlayerA();
        int scoreB = observer.getScorePlayerB();
        
        String decisionA_Exp = COOPERATE;
        String decisionB_Exp = DESERTOR;
        int scoreA_Exp = S;
        int scoreB_Exp = T;
        
        assertTrue(decisionA.equals(decisionA_Exp));
        assertTrue(decisionB.equals(decisionB_Exp));
        assertTrue(scoreA == scoreA_Exp);
        assertTrue(scoreB == scoreB_Exp);
    }
    
    @Test
    public void test_update_more_round() throws UtilityMatrixImp.ElementNotExistInMatrixException {
        ObserverPlay observer = new ObserverPlay();
        
        int rounds = 10;
        this.play = new Play(playerA, playerB, utilMatrix, rounds);
        play.addObserver(observer);
        play.executeGame();
        
        String decisionA = observer.getDecisionPlayerA();
        String decisionB = observer.getDecisionPlayerB();
        int scoreA = observer.getScorePlayerA();
        int scoreB = observer.getScorePlayerB();
        
        String decisionA_Exp = COOPERATE;
        String decisionB_Exp = DESERTOR;
        int scoreA_Exp = S * rounds;
        int scoreB_Exp = T * rounds;
        
        assertTrue(decisionA.equals(decisionA_Exp));
        assertTrue(decisionB.equals(decisionB_Exp));
        assertTrue(scoreA == scoreA_Exp);
        assertTrue(scoreB == scoreB_Exp);
    }
    
    @Test
    public void test_if_you_may_assign_over_one_observers() throws UtilityMatrixImp.ElementNotExistInMatrixException {
        ObserverPlay observerOne = new ObserverPlay();
        ObserverPlay observerTwo = new ObserverPlay();
        
        int rounds = 10;
        this.play = new Play(playerA, playerB, utilMatrix, rounds);
        play.addObserver(observerOne);
        play.addObserver(observerTwo);
        play.executeGame();
        
        String decisionA_One = observerOne.getDecisionPlayerA();
        String decisionB_One = observerOne.getDecisionPlayerB();
        int scoreA_One = observerOne.getScorePlayerA();
        int scoreB_One = observerOne.getScorePlayerB();
        
        String decisionA_Two = observerTwo.getDecisionPlayerA();
        String decisionB_Two = observerTwo.getDecisionPlayerB();
        int scoreA_Two = observerTwo.getScorePlayerA();
        int scoreB_Two = observerTwo.getScorePlayerB();
        
        String decisionA_Exp = COOPERATE;
        String decisionB_Exp = DESERTOR;
        int scoreA_Exp = S * rounds;
        int scoreB_Exp = T * rounds;
        
        assertTrue(decisionA_One.equals(decisionA_Exp));
        assertTrue(decisionB_One.equals(decisionB_Exp));
        assertTrue(scoreA_One == scoreA_Exp);
        assertTrue(scoreB_One == scoreB_Exp);
        
        assertTrue(decisionA_Two.equals(decisionA_Exp));
        assertTrue(decisionB_Two.equals(decisionB_Exp));
        assertTrue(scoreA_Two == scoreA_Exp);
        assertTrue(scoreB_Two == scoreB_Exp);
    }
}