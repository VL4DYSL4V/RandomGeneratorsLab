package algorithm.anotherDistribution;

import algorithm.evenDistribution.AbstractEvenAlgorithm;
import statistics.StatisticsGenerator;

public class LogarithmAlgorithm implements AnotherLabRandom {

    private final double mu = 17.0;
    private final StatisticsGenerator statisticsGenerator;
    private final AbstractEvenAlgorithm abstractEvenAlgorithm;

    public LogarithmAlgorithm(AbstractEvenAlgorithm abstractEvenAlgorithm, StatisticsGenerator statisticsGenerator) {
        this.statisticsGenerator = statisticsGenerator;
        this.abstractEvenAlgorithm = abstractEvenAlgorithm;
    }

    @Override
    public double getRandom() {
        double u;
        do{
            u = abstractEvenAlgorithm.getRandom();
        }while (u == 0.0);
        return -1 * mu * Math.log(u);
    }

    @Override
    public String getStatistics() {
        return statisticsGenerator.getForAnotherDistribution(this);
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
