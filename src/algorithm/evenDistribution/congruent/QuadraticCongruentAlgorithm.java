package algorithm.evenDistribution.congruent;

import enums.AlgorithmConstants;
import algorithm.evenDistribution.AbstractEvenAlgorithm;
import statistics.StatisticsGenerator;

public class QuadraticCongruentAlgorithm extends AbstractEvenAlgorithm {

    private double current = 333667.0;
    private AlgorithmConstants mod = AlgorithmConstants.MOD_2;

    public QuadraticCongruentAlgorithm(StatisticsGenerator statisticsGenerator) {
        super(statisticsGenerator);
    }

    @Override
    protected double calculateNext() {
        current = (AlgorithmConstants.D.getValue() * Math.pow(current, 2)
                + AlgorithmConstants.A.getValue() * current + AlgorithmConstants.C.getValue()) % mod.getValue();
        return current;
    }

    @Override
    protected AlgorithmConstants getMOD() {
        return mod;
    }

}
