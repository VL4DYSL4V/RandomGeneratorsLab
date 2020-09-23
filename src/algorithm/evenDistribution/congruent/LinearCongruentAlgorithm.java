package algorithm.evenDistribution.congruent;

import enums.AlgorithmConstants;
import algorithm.evenDistribution.AbstractEvenAlgorithm;
import statistics.StatisticsGenerator;

public class LinearCongruentAlgorithm extends AbstractEvenAlgorithm {

    private double current = 331777.0;

    public LinearCongruentAlgorithm(StatisticsGenerator statisticsGenerator) {
        super(statisticsGenerator);
    }

    @Override
    protected double calculateNext() {
        current = (AlgorithmConstants.A.getValue() * current
                + AlgorithmConstants.C.getValue()) % super.getMOD().getValue();
        return current;
    }
}
