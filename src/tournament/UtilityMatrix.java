/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import tournament.UtilityMatrixImp.ElementNotExistInMatrixException;

/**
 *  Utility matrix interface with the methods to implement.
 * @author carlos
 */
public interface UtilityMatrix {
    /**
     *  Calculates the scores of the two players according to their respective
     * decisions.
     * @param decisionPlayerA the decision of playerA
     * @param decisionPlayerB the decision of playerB
     * @return an array of ints with two integers inside one for each player
     * @throws tournament.UtilityMatrixImp.ElementNotExistInMatrixException if the decision
     * is not found inside the utility matrix
     */
    public int[] getScores(String decisionPlayerA, String decisionPlayerB) throws ElementNotExistInMatrixException;

}
