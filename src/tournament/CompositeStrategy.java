/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import java.util.ArrayList;
import java.util.List;

/**
 *  Abstract Strategy that represents an strategy with multiple strategies inside.
 * The Composite pattern is aplied.
 * @author carlos
 */
public abstract class CompositeStrategy implements PlayerStrategy {
    
    /**
     *  The components of the composite.
     */
    protected List<PlayerStrategy> strategies;
    
    /**
     *
     */
    public CompositeStrategy(){
        this.strategies = new ArrayList<PlayerStrategy>();
    }
    
    /**
     *  Add an strategy to the components.
     * @param ps
     */
    public void addStrategy(PlayerStrategy ps){
        this.strategies.add(ps);
    }
    
}
