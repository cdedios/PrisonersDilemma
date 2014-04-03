/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import java.util.HashMap;

/**
 * It's used to save the PlayerStrategies, with an asociated name, of the game.
 * Pattern Singleton is aplied.
 */
public class Register {
    private static Register register;
    private static final Object classLock = Register.class;
    private HashMap<String,PlayerStrategy> strategies;
    
    /**
     *  Only one instance of Register will be used on the game.
     * @return the Register 
     */
    public static Register getRegister(){
        synchronized(classLock){
            if (register == null){
                register = new Register();
            }else {
                return register;
            }          
            return register;
        }
    }
    private Register(){
        this.strategies = new HashMap<String, PlayerStrategy>();
        strategies.put("naive", new NaiveStrategy());
        strategies.put("cocky", new CockyStrategy());
        strategies.put("smart", new SmartStrategy());
        strategies.put("random", new RandomStrategy());
        strategies.put("majorityRule", new MajorityRuleStrategy());
    }
    /**
     *  Returns a deep copy of the PlayerStrategy given by parameter.
     * @param key the name of the strategy wanted
     * @return the PlayerStrategy according tho the key.
     * @throws tournament.Register.StrategyNotFoundException
     */
    public PlayerStrategy getStrategy(String key) throws StrategyNotFoundException{
        if (!strategies.containsKey(key)) throw new StrategyNotFoundException();
        return strategies.get(key).deepCopy();
    }

    /**
     *  The PlayerStrategy must be on the system.
     */
    public static class StrategyNotFoundException extends Exception {

        public StrategyNotFoundException() {
        }
    }

}

