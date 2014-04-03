/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import java.util.Observable;
import tournament.Register.StrategyNotFoundException;
import tournament.UtilityMatrixImp.ElementNotExistInMatrixException;

/**
 * Represents a game, knows both players, the utility matrix and also the global score of the game.
 * Executes a game with a determinated number of rounds
 * 
 */
public class Play extends Observable{
    /**
     *  Two possible decisions for players.
     */
    public static final String DESERTOR = "desertar";
    public static final String COOPERATE = "cooperar";
      
    private Player playerA, playerB;    
    private UtilityMatrix matrix;
    private int scoreA, scoreB;
    private int rounds;
        
    /**
     *  Play constructor, returns a Play instance with the configuration given
     *  by the parameters, the strategy of the players will be a Player class problem.
     * @param aliasPlayerA The name of playerA
     * @param aliasPlayerB The name of playerB
     * @param strategyPlayerA The name of playerA strategy
     * @param strategyPlayerB The name of playerA strategy
     * @param matrix The utility matrix to calculate the score
     * @param rounds The number of rounds of the game
     * @throws tournament.Register.StrategyNotFoundException if strategyPlayerA or
     *  strategyPlayerB are incorrect
     */
    public Play (String aliasPlayerA, String aliasPlayerB, String strategyPlayerA,
            String strategyPlayerB, UtilityMatrix matrix, int rounds) throws StrategyNotFoundException{
        
        this.playerA = new PlayerImp(aliasPlayerA, strategyPlayerA);
        this.playerB = new PlayerImp(aliasPlayerB, strategyPlayerB);
        this.matrix = matrix;
        this.rounds = rounds;
    }
    /**
     *  Play constructor, returns a Play instance with the configuration given
     *  by the parameters.
     * @param PlayerA The instance of playerA
     * @param PlayerB The instance of playerB
     * @param matrix The utility matrix to calculate the score
     * @param rounds The number of rounds of the game
     */
    public Play(Player playerA, Player playerB, UtilityMatrix matrix, int rounds){
        
        this.playerA = playerA;
        this.playerB = playerB;
        this.matrix = matrix;
        this.rounds = rounds;
        this.scoreA = 0;
        this.scoreB = 0;       
    }
        
    /**
     *  Executes a game with a determinated number of rounds.
     * @throws tournament.UtilityMatrixImp.ElementNotExistInMatrixException
     */
    public void executeGame() throws ElementNotExistInMatrixException{
        
        for(int i = 0; i < rounds; i++){
            String decisionA,decisionB;
            decisionA = playerA.getPlayerDecision();
            decisionB = playerB.getPlayerDecision();            
            int[] bothScores = matrix.getScores(decisionA,decisionB);
            playerA.tellOponentDecision(decisionB);
            playerB.tellOponentDecision(decisionA);
            scoreA += bothScores[0];
            scoreB += bothScores[1];
            comunicateObservers(decisionA,decisionB,scoreA,scoreB);  
        }
    }
    
    /**
     *  Return the score of the player name given by parameter.
     * @param alias The name of the player to know the score.
     * @return a integer with the score of the player named alias
     * @throws tournament.Play.PlayerNotFoundException if there is no player named
     * alias.
     */
    public int getScorePlayer(String alias) throws PlayerNotFoundException{
        
        if(playerA.getAlias().equals(alias)){
            return scoreA;
        }else if(playerB.getAlias().equals(alias)){
            return scoreB;
        }else{
            throw new PlayerNotFoundException();
        }     
    }
    
    private void comunicateObservers(String decisionPlayerA, String decisionPlayerB, int scorePlayerA, int scorePlayerB){
        super.setChanged();
        InfoToObserver ito = new InfoToObserver(decisionPlayerA, decisionPlayerB, scorePlayerA, scorePlayerB);
        super.notifyObservers(ito);
    }

    /**
     *  Exception if there is no player with the name given on getScorePlayer
     */
    public static class PlayerNotFoundException extends Exception {

        /**
         *
         */
        public PlayerNotFoundException() {
        }
    }
    
}
