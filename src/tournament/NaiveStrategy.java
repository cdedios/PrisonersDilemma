/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;


/**
 *  An implementation of player strategy that always returns cooperate.
 *  It's a simple strategy
 */
public class NaiveStrategy implements PlayerStrategy {
    
    public NaiveStrategy(){ }
    
    @Override
    public String getDecision() {
        return Play.COOPERATE;
    }

    @Override
    public PlayerStrategy deepCopy() {
        return new NaiveStrategy();
    }

    @Override
    public void tellOponentDecision(String prevDecision) {
        
    }    
}
