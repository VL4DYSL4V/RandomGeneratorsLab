package algorithm.normalDistribution;

import algorithm.evenDistribution.AbstractEvenAlgorithm;
import statistics.StatisticsGenerator;

public class RatioAlgorithm implements NormalLabRandom {

    private final AbstractEvenAlgorithm abstractEvenAlgorithm1;
    private final AbstractEvenAlgorithm abstractEvenAlgorithm2;
    private final StatisticsGenerator statisticsGenerator;

    public RatioAlgorithm(AbstractEvenAlgorithm algorithm1,
                          AbstractEvenAlgorithm algorithm2, StatisticsGenerator statisticsGenerator) {
        this.statisticsGenerator = statisticsGenerator;
        this.abstractEvenAlgorithm1 = algorithm1;
        this.abstractEvenAlgorithm2 = algorithm2;
    }

    @Override
    public double getRandom() {
        double V = abstractEvenAlgorithm2.getRandom();
        double result;
        double U = 0.0;
        while (U == 0.0) {
            U = abstractEvenAlgorithm1.getRandom();
        }
        result = calculateResult(U, V);
        while (! mayReturn(result, U)) {
            result = calculateResult(U, V);
            do {
                U = abstractEvenAlgorithm1.getRandom();
            }while (U == 0.0);
        }
        return result;
    }

    private boolean mayReturn(double x, double U) {
        return x <= (-4) * Math.log(U);
    }

    private double calculateResult(double U, double V) {
        return Math.sqrt(8.0 / Math.E) * ((V - 0.5) / U);
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
