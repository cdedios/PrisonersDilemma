/*
 * Repeated Prisoner's Dilemma Tests.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author carlos
 */
public class PlayerImpTest {
    
    //corrects string decisions
    private final String DESERTOR = "desertar";
    private final String COOPERATE = "cooperar";   
    private final String ALIAS = "punisher";
      
    private PlayerStrategyCooperateDouble playerStrategy;    
    
    private static class PlayerStrategyCooperateDouble implements PlayerStrategy{
        
        public String oponentDecision;
        
        public PlayerStrategyCooperateDouble(){ }
        
        @Override
        public String getDecision() {
             return "cooperar";
        }

        @Override
        public void tellOponentDecision(String prevDecision) {
             oponentDecision = prevDecision;
        }
                
        @Override
        public PlayerStrategy deepCopy() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
    
    private static class PlayerStrategyDesertorDouble implements PlayerStrategy{
        
        public PlayerStrategyDesertorDouble(){ }
        
        @Override
        public String getDecision() {
             return "desertar";
        }

        @Override
        public void tellOponentDecision(String prevDecision) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
                
        @Override
        public PlayerStrategy deepCopy() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }
    
    @Before
    public void setUp(){
        this.playerStrategy = new PlayerStrategyCooperateDouble();
    }
    

    @Test
    public void if_alias_is_correct() {
        Player player = new PlayerImp(ALIAS, playerStrategy);
        String result = player.getAlias();
        assertTrue(result.equals(ALIAS));
    }
    
    @Test
    public void if_tell_oponent_decision_is_called_with_correct_decision(){
        Player player = new PlayerImp(ALIAS, playerStrategy);
        player.tellOponentDecision(COOPERATE);
        
        String result = playerStrategy.oponentDecision;
        
        assertTrue(result.equals(COOPERATE));
    }
    
    @Test
    public void if_setPlayerStrategy_changes_strategy_correctly(){
         Player player = new PlayerImp(ALIAS, playerStrategy);
         
         String resultBefore = player.getPlayerDecision();                
         PlayerStrategy psDesertor = new PlayerStrategyDesertorDouble();
         player.setStrategy(psDesertor);      
         String resultAfter = player.getPlayerDecision();
         
         assertFalse(resultBefore.equals(resultAfter));       
     }
    
}
