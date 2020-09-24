package algorithm.evenDistribution;

import enums.AlgorithmConstants;
import statistics.StatisticsGenerator;

public abstract class AbstractEvenAlgorithm implements EvenLabRandom {

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
        if(number <= 0.0){
            throw new IllegalArgumentException("Number must be positive");
        }
        double generated = number;
        while (Double.compare(generated, ((double) getMOD().getValue()) / 10) == -1) {
            generated *= 10;
        }
        return generated;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public String getStatistics() {
        return statisticsGenerator.getForEvenDistribution(this);
    }

    public final int nextInt() {
        return (int) calculateNext();
    }
}
