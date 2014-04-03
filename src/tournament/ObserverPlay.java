/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import java.util.Observable;
import java.util.Observer;

/**
 * Represents an observer of the game.
 * Is informed of the changes they happen in the game
 * 
 */
public class ObserverPlay implements Observer{
    
    private String decisionPlayerA;
    private String decisionPlayerB;
    private int scorePlayerA;
    private int scorePlayerB;

    /**
     * Returns the decision taken by the playerA.
     * @return the decision of playerA.
     */
    public String getDecisionPlayerA() {
        return decisionPlayerA;
    }

    /**
     * Returns the decision taken by the playerB.
     * @return the decision of playerB.
     */
    public String getDecisionPlayerB() {
        return decisionPlayerB;
    }

    /**
     * Returns the score for playerA.
     * @return the score for playerA.
     */
    public int getScorePlayerA() {
        return scorePlayerA;
    }

    /**
     * Returns the score for playerB.
     * @return the score for playerB.
     */
    public int getScorePlayerB() {
        return scorePlayerB;
    }
    
    /**
     * Save changes (which receives as parameter) that have been made in the class observed.
     */
    @Override
    public void update(Observable o, Object o1) {
        Play play = (Play)o;
        InfoToObserver ito = (InfoToObserver)o1;
        this.decisionPlayerA = ito.getDecisionPlayerA();
        this.decisionPlayerB = ito.getDecisionPlayerB();
        this.scorePlayerA = ito.getScorePlayerA();
        this.scorePlayerB = ito.getScorePlayerB();
    }
    
}
