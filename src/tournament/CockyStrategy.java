/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

/**
 *  An implementation of player strategy that always returns desertar.
 *  It's a simple strategy
 */
public class CockyStrategy implements PlayerStrategy{
    

    public CockyStrategy(){ }


    @Override
    public String getDecision() {
        return Play.DESERTOR;
    }

    @Override
    public PlayerStrategy deepCopy() {
        return new CockyStrategy();
    }

    @Override
    public void tellOponentDecision(String prevDecision) {
        
    }
    
}
