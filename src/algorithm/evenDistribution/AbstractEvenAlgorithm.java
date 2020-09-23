package algorithm.evenDistribution;

import algorithm.Random;
import enums.AlgorithmConstants;
import statistics.StatisticsGenerator;

public abstract class AbstractEvenAlgorithm implements Random {

    private final StatisticsGenerator statisticsGenerator;

    public AbstractEvenAlgorithm(StatisticsGenerator statisticsGenerator) {
        this.statisticsGenerator = statisticsGenerator;
    }

    @Override
    public double getRandom() {
        return calculateNext() / (double) getMOD().getValue();
    }

    protected abstract double calculateNext();

    protected AlgorithmConstants getMOD(){
        return AlgorithmConstants.MAX_MOD;
    }

    public final double correctDegreeMaker(double number) {
        double generated = number;
        while (Double.compare(generated, ((double) getMOD().getValue()) / 10) == -1) {
            generated *= 10;
        }
        return generated;
    }

    @Override
    public String toString() {
        return "*** \t " + this.getClass().getName();
    }

    @Override
    public String getStatistics() {
        return statisticsGenerator.getForEvenDistribution(this);
    }

    public final int nextInt() {
        return (int) calculateNext();
    }
}
