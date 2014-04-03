/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

/**
 *  An implementation of player strategy that returns the majority decision 
 *  of al his strategies.
 *  It's an inteligent strategy
 */
public class MajorityRuleStrategy extends CompositeStrategy{

    public MajorityRuleStrategy(){
        super();
    }
    

    public MajorityRuleStrategy(MajorityRuleStrategy other){
        super();
  
            for(PlayerStrategy ps : other.strategies){
                super.addStrategy(ps.deepCopy());
            } 
    }

    /**
     *  Of all the strategies that is composed this strategy returns the majority
     * answer for all of them.
     * @return
     */
    @Override
    public String getDecision() {
        int desertor = 0;
        int cooperate = 0;
        
        for(PlayerStrategy strategy : super.strategies){                    
            if(strategy.getDecision().equals(Play.COOPERATE))
                cooperate++;
            else
                desertor++;      
        }
           
        if(desertor < cooperate)
            return Play.COOPERATE;
        else                        
            return Play.DESERTOR;
        
    }

    /**
     *  Reports the oponent previous decision to all his strategies.
     * @param prevDecision oponent previous decision.
     */
    @Override
    public void tellOponentDecision(String prevDecision){
        for(PlayerStrategy ps : super.strategies){ 
            ps.tellOponentDecision(prevDecision);
        }
    }

    /**
     *  A deep copy of the strategy.
     * @return the copy.
     */
    @Override
    public PlayerStrategy deepCopy() {
        return new MajorityRuleStrategy(this);
    }
    
    
}
