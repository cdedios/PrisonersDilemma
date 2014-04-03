/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import tournament.Register.StrategyNotFoundException;

/**
 * Represents a player of the game. Implements Player interface.
 * This player knows his strategy and delegates to it his decisions. 
 * Also reports to the strategy the oponent previous decision.
 */
public class PlayerImp implements Player{

    private String alias;
    private PlayerStrategy playerStrategy;
    private Register register;
        
    /**
     *  Player constructor, creates a player with the given alias and playerStrategy
     * @param alias The name of the player
     * @param playerStrategy The name of the player strategy
     * @throws tournament.Register.StrategyNotFoundException if this playerStrategy is not
     * valid.
     */
    public PlayerImp(String alias, String playerStrategy)throws StrategyNotFoundException{
        this.register = Register.getRegister();
        this.alias = alias;
        this.playerStrategy = register.getStrategy(playerStrategy);
    }
    
    /**
     *  Player constructor, creates a player with the given alias and playerStrategy
     * @param alias The name of the player
     * @param playerStrategy The player strategy
     * 
     */
    public PlayerImp(String alias, PlayerStrategy playerStrategy){
        this.alias = alias;
        this.playerStrategy = playerStrategy;
    }
    
    /**
     *  Calculates the player decision using his strategy.
     * @return a string type with the decision made.
     */
    @Override
    public String getPlayerDecision(){
        return this.playerStrategy.getDecision();
    }
    
    /**
     *  Reports to the strategy the previous decidion
     * @param decision The decision made by the other oponent.
     */
    @Override
    public void tellOponentDecision(String decision){
        this.playerStrategy.tellOponentDecision(decision);
    }
    
    /**
     *  Setter for the player strategy.
     * @param strategy the new strategy.
     */
    @Override
    public void setStrategy(PlayerStrategy strategy){
        this.playerStrategy=strategy;
    }
    
    /**
     *  Returns the name of the player.
     * @return the name of the player.
     */
    @Override
    public String getAlias(){
        return this.alias;
    }
}
