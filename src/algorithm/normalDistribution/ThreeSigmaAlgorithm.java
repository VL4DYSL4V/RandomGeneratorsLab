package algorithm.normalDistribution;

import algorithm.evenDistribution.AbstractEvenAlgorithm;
import statistics.StatisticsGenerator;

public class ThreeSigmaAlgorithm implements NormalLabRandom {

    private final AbstractEvenAlgorithm abstractEvenAlgorithm;
    private final StatisticsGenerator statisticsGenerator;

    public ThreeSigmaAlgorithm(StatisticsGenerator statisticsGenerator, AbstractEvenAlgorithm algorithm) {
        this.statisticsGenerator = statisticsGenerator;
        this.abstractEvenAlgorithm = algorithm;
    }

    @Override
    public double getRandom() {
        double result = 0;
        for(int i = 0; i < 12; i++){
            result += abstractEvenAlgorithm.getRandom();
        }
        return result - 6;
    }

    @Override
    public String getStatistics() {
        return statisticsGenerator.getForNormalDistribution(this);
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
