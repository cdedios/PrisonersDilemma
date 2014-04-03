/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  An implementation of player strategy that always coperates if the oponent previous
 *  decisions are cooperate also, only 10% can be desertar.
 *  It's an inteligent strategy
 */
public class SmartStrategy implements PlayerStrategy {

    private List<String> decisionsOtherPlayer;

    public SmartStrategy(){
        this.decisionsOtherPlayer = new LinkedList<String>();
    }
    
    private SmartStrategy(SmartStrategy other){
        
        this.decisionsOtherPlayer = new LinkedList<String>();
        
        if ( !other.decisionsOtherPlayer.isEmpty() ){
            for(String decision : other.decisionsOtherPlayer){
                this.decisionsOtherPlayer.add(decision);
            }
        }
    }
    
    /**
     *  Return the decision based on the strategy. The oponent previous decisions 
     *  are important and cosidered.
     * @return a decision.
     */
    @Override
    public String getDecision() {
        int coop=0,desert=0;
        for(String decision : this.decisionsOtherPlayer ){
            if(decision.equals(Play.COOPERATE)) {
                coop++;
            }else {
                desert++;
            }
            
        }
        if(desert==0){
            return Play.COOPERATE;
        }
        else if((desert*100)/(coop+desert)>10){
            return Play.DESERTOR;
        }            
        return Play.COOPERATE;
    }


    @Override
    public PlayerStrategy deepCopy() {
        return new SmartStrategy(this);
    }

    /**
     *  Saves the oponent previous decision.
     * @param prevDecision
     */
    @Override
    public void tellOponentDecision(String prevDecision) {
        this.decisionsOtherPlayer.add(prevDecision);
    }
    
}
