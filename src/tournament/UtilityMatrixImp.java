/*
 * Repeated Prisoner's Dilemma project.
 * Developed by: Carles Blanch & Carlos de Dios
 */
package tournament;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the matrix utilty. implements UtilityMatrix
 */
public class UtilityMatrixImp implements UtilityMatrix {
    
    private Map<Decisions, int[]> matrix;
    
    /**
     *  Matrix constructor with the given parameters.
     * @param t temptation
     * @param r price
     * @param p punishment
     * @param s snithc
     * @throws tournament.UtilityMatrixImp.IllegalParamException if the parameters
     * aren't valid
     */
    public UtilityMatrixImp(int t, int r, int p, int s) throws IllegalParamException{
        
        if(!isParamValid(t,r,p,s)) throw new IllegalParamException();       
        this.matrix = new HashMap<Decisions,int[]>();
        inicializeMatrix(t,r,p,s);       
    }
    
    /**
     *  Calculates the scores of the two players according to their respective
     * decisions.
     * @param decisionPlayerA the decision of playerA
     * @param decisionPlayerB the decision of playerB
     * @return an array of ints with two integers inside one for each player
     * @throws tournament.UtilityMatrixImp.ElementNotExistInMatrixException if the decision
     * is not found inside the utility matrix
     */
    @Override
    public int[] getScores(String decisionPlayerA, String decisionPlayerB) throws ElementNotExistInMatrixException{
         
        Decisions decisions = new Decisions(decisionPlayerA, decisionPlayerB);
        if(!matrix.containsKey(decisions))  throw new ElementNotExistInMatrixException();
        return matrix.get(decisions);
    }
    

    private void inicializeMatrix(int t, int r, int p, int s){
                   
        fillMatrix(Play.COOPERATE,Play.COOPERATE,r,r);
        fillMatrix(Play.COOPERATE,Play.DESERTOR,s,t);
        fillMatrix(Play.DESERTOR,Play.COOPERATE,t,s);
        fillMatrix(Play.DESERTOR,Play.DESERTOR,p,p);
    }
    
    private void fillMatrix(String decisionPlayerA, String decisionPlayerB, int scorePlayerA, int scorePlayerB){
        
        Decisions decisions = new Decisions(decisionPlayerA, decisionPlayerB);
        int[] scores = new int[]{scorePlayerA, scorePlayerB};
        matrix.put(decisions, scores);
    }

    private boolean isParamValid(int t, int r, int p, int s) {
        
        if( (t > r) && (r > p) && (p > s) && (r > (t+s)/2) ){
            return true;
        }
        return false;
    }
    
    /**
     *  The matrix keys must be well formed.
     */
    public static class ElementNotExistInMatrixException extends Exception {

        public ElementNotExistInMatrixException() {
        }
    }

    /**
     *  The parameters must fulfill some restrictions.
     */
    public static class IllegalParamException extends Exception {

        public IllegalParamException() {
        }
    }    
    
    /**
     * Private class Decisions that represents the 2 decisions for the matrix 
     * hashmap instead of concatening both strings and using thema as key we used 
     * this object.
     */
    private class Decisions{
        
        String decisionA;
        String decisionB;
        
        public Decisions(String decisionA, String decisionB){
            this.decisionA = decisionA;
            this.decisionB = decisionB;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Decisions other = (Decisions) obj;
            if ((this.decisionA == null) ? (other.decisionA != null) : !this.decisionA.equals(other.decisionA)) {
                return false;
            }
            if ((this.decisionB == null) ? (other.decisionB != null) : !this.decisionB.equals(other.decisionB)) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + (this.decisionA != null ? this.decisionA.hashCode() : 0);
            hash = 17 * hash + (this.decisionB != null ? this.decisionB.hashCode() : 0);
            return hash;
        }      
    } 
}

