package algorithm.evenDistribution.congruent;

import enums.AlgorithmConstants;
import algorithm.evenDistribution.AbstractEvenAlgorithm;

public class QuadraticCongruentAlgorithm extends AbstractEvenAlgorithm {
 
    private double current = 3967.0;

    @Override
    public double calculateNext() {
         current = (AlgorithmConstants.D.getValue() * Math.pow(current, 2)
                 + AlgorithmConstants.A.getValue() * current
                 +  AlgorithmConstants.C.getValue()) % AlgorithmConstants.MOD.getValue();
        return current;
    }

}
