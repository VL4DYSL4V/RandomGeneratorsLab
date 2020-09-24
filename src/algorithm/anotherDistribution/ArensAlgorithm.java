package algorithm.anotherDistribution;

import algorithm.evenDistribution.AbstractEvenAlgorithm;
import statistics.StatisticsGenerator;

/**It won't work with a <=1
 * */
public class ArensAlgorithm implements AnotherLabRandom {

    private final StatisticsGenerator statisticsGenerator;
    private final AbstractEvenAlgorithm abstractEvenAlgorithm;
    private final double a = 2.1;

    public ArensAlgorithm(AbstractEvenAlgorithm abstractEvenAlgorithm, StatisticsGenerator statisticsGenerator) {
        this.statisticsGenerator = statisticsGenerator;
        this.abstractEvenAlgorithm = abstractEvenAlgorithm;
    }

    @Override
    public double getRandom() {
        double y;
        double x;
        double v;
        do {
            do {
                double u = abstractEvenAlgorithm.getRandom();
                y = initY(u);
                x = initX(y);
            } while (x <= 0);
            v = abstractEvenAlgorithm.getRandom();
        } while (!valueBiggerThanRandom(v, y, x));
        return x;
    }

    private double initY(double u) {
        return Math.tan(Math.PI * u);
    }

    private double initX(double y) {
        return Math.sqrt(2 * a - 1) * y + a - 1;
    }

    private boolean valueBiggerThanRandom(double random, double y, double x) {
        return random > (1 + Math.pow(y, 2)) * Math.pow(Math.E, exponentOfEInFormula(x, y));
    }

    private double exponentOfEInFormula(double x, double y) {
        return (a - 1) * Math.log(x / (a - 1)) - Math.sqrt(2 * a - 1) * y;
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
