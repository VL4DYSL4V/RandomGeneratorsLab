package algorithm.evenDistribution.congruent;

import enums.AlgorithmConstants;
import algorithm.evenDistribution.AbstractEvenAlgorithm;

public class LinearCongruentAlgorithm extends AbstractEvenAlgorithm {

    private double current = 2383.0;

    @Override
    public double calculateNext() {
        current = (AlgorithmConstants.A.getValue() * current
                + AlgorithmConstants.C.getValue()) % AlgorithmConstants.MOD.getValue();
        return current;
    }
    
}
