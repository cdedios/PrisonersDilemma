/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

/**
 *
 */
public class InfoToObserver{
    
    private String decisionPlayerA, decisionPlayerB;
    private int scorePlayerA, scorePlayerB;
    
    /**
     *
     * @param decisionA
     * @param decisionB
     * @param scoreA
     * @param scoreB
     */
    public InfoToObserver(String decisionA, String decisionB, int scoreA, int scoreB) {
        this.decisionPlayerA = decisionA;
        this.decisionPlayerB = decisionB;
        this.scorePlayerA = scoreA;
        this.scorePlayerB = scoreB;
    }

    /**
     *
     * @return
     */
    public String getDecisionPlayerA() {
        return decisionPlayerA;
    }

    /**
     *
     * @return
     */
    public String getDecisionPlayerB() {
        return decisionPlayerB;
    }

    /**
     *
     * @return
     */
    public int getScorePlayerA() {
        return scorePlayerA;
    }

    /**
     *
     * @return
     */
    public int getScorePlayerB() {
        return scorePlayerB;
    }

}
