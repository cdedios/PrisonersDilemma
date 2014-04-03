/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import org.junit.Test;
import static org.junit.Assert.*;
import tournament.UtilityMatrixImp.ElementNotExistInMatrixException;
import tournament.UtilityMatrixImp.IllegalParamException;

    
/**
 *
 * @author carlos
 */
public class UtilityMatrixImpTest {
    
    //exemple correct values
    private final int T = 3;
    private final int R = 2;
    private final int P = 1;
    private final int S = 0;
    
    //corrects string decisions
    private final String DESERTOR = "desertar";
    private final String COOPERATE = "cooperar";
    
    @Test //ja es prova el constructor i el getScore
    public void test_if_matrix_is_fill_with_correct_values() throws IllegalParamException, ElementNotExistInMatrixException {
        
        UtilityMatrixImp utilMatrix = new UtilityMatrixImp(T,R,P,S);
        
        int[] caseOne = utilMatrix.getScores(COOPERATE, COOPERATE);
        int[] caseTwo = utilMatrix.getScores(COOPERATE, DESERTOR);
        int[] caseThree = utilMatrix.getScores(DESERTOR, COOPERATE);
        int[] caseFour = utilMatrix.getScores(DESERTOR, DESERTOR);
        
        int[] expectedCaseOne = new int[]{R, R};
        int[] expectedCaseTwo = new int[]{S, T};
        int[] expectedCaseThree = new int[]{T, S};
        int[] expectedCaseFour = new int[]{P, P};
        
        assertArrayEquals(caseOne, expectedCaseOne);
        assertArrayEquals(caseTwo, expectedCaseTwo);
        assertArrayEquals(caseThree, expectedCaseThree);
        assertArrayEquals(caseFour, expectedCaseFour);
    }
    
    @Test(expected = IllegalParamException.class)
    public void test_if_matrix_is_instanciated_with_incorrect_values() throws IllegalParamException, ElementNotExistInMatrixException {
        //no compleix T>R>P>S
        UtilityMatrixImp utilMatrix = new UtilityMatrixImp(S,P,R,T);   
    }
    
    @Test(expected = IllegalParamException.class)
    public void test_if_matrix_is_instanciated_with_incorrect_values_second_condicion() throws IllegalParamException, ElementNotExistInMatrixException {
        //no compleix R > (T+S)/2
        UtilityMatrixImp utilMatrix = new UtilityMatrixImp(100,40,10,2);   
    }
    
    @Test(expected = ElementNotExistInMatrixException.class)
    public void test_if_getScore_with_incorrect_key_first_case() throws IllegalParamException, ElementNotExistInMatrixException {
        
        UtilityMatrixImp utilMatrix = new UtilityMatrixImp(T,R,P,S);
        utilMatrix.getScores("notExist", COOPERATE);            
    }
    
    @Test(expected = ElementNotExistInMatrixException.class)
    public void test_if_getScore_with_incorrect_key_second_case() throws IllegalParamException, ElementNotExistInMatrixException {
        
        UtilityMatrixImp utilMatrix = new UtilityMatrixImp(T,R,P,S);
        utilMatrix.getScores("notExist", DESERTOR);           
    }
    
    @Test(expected = ElementNotExistInMatrixException.class)
    public void test_if_getScore_with_incorrect_key_third_case() throws IllegalParamException, ElementNotExistInMatrixException {
        
        UtilityMatrixImp utilMatrix = new UtilityMatrixImp(T,R,P,S);
        utilMatrix.getScores(COOPERATE, "notExist");           
    }
    
    @Test(expected = ElementNotExistInMatrixException.class)
    public void test_if_getScore_with_incorrect_key_fourth_case() throws IllegalParamException, ElementNotExistInMatrixException {
        
        UtilityMatrixImp utilMatrix = new UtilityMatrixImp(T,R,P,S);
        utilMatrix.getScores(DESERTOR, "notExist");           
    }
    
    
    
}
