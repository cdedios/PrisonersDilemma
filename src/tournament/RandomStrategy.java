/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import java.util.Random;

/**
 *  An implementation of player strategy that returns the decision randomly.
 *  It's a simple strategy
 */
public class RandomStrategy implements PlayerStrategy {
    Random gen;
    

    public RandomStrategy(){
        gen = new Random();
    }
    

    @Override
    public String getDecision() {
        if(gen.nextBoolean()) 
            return Play.DESERTOR;
        else return Play.COOPERATE;
    }


    @Override
    public PlayerStrategy deepCopy() {
        return new RandomStrategy();
    }


    @Override
    public void tellOponentDecision(String prevDecision) {

    }
    
}
