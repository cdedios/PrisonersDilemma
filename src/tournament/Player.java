/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

/**
 * Player interface with the methods to use the player.
 */
public interface Player {
    
    /**
     *  Calculates the player decision using his strategy.
     * @return a string type with the decision made.
     */
    public String getPlayerDecision() ;
    
    /**
     *  Reports to the strategy the previous decidion
     * @param decision The decision made by the other oponent.
     */
    public void tellOponentDecision(String decision);
     
    /**
     *  Returns the name of the player.
     * @return the name of the player.
     */
    public String getAlias();
    
    /**
     *  Setter for the player strategy.
     * @param strategy the new strategy.
     */
    public void setStrategy(PlayerStrategy strategy);
}
