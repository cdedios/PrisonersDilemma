/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import java.util.List;

/**
 * The player strategy interface.
 * Decides wich decision has to be made. Is informed of the oponent decision.
 * Can be simple or composite.
 * Allows the deep copy.
 */
public interface PlayerStrategy {    
    /**
     * Gives the decision according to it's own characteristics
     * @return the decision taken by the strategy
     */
    public String getDecision();
    
    /**
     *  Reports the oponent previous decison.
     * @param prevDecision the previous decision.
     */
    public void tellOponentDecision(String prevDecision);
    /**
     *  Returns a deep copy of the PlayerStrategy.
     * @return a deep copy of the PlayerStrategy.
     */
    public PlayerStrategy deepCopy();
}
