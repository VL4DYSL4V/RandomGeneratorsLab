package algorithm.normalDistribution;

import algorithm.Random;
import algorithm.evenDistribution.AbstractEvenAlgorithm;
import statistics.StatisticsGenerator;

public class PolarCoordinatesAlgorithm implements Random {

    private final AbstractEvenAlgorithm abstractEvenAlgorithm;
    private final StatisticsGenerator statisticsGenerator;
    private double anotherCoordinate = 0.0;

    public PolarCoordinatesAlgorithm(AbstractEvenAlgorithm abstractEvenAlgorithm, StatisticsGenerator statisticsGenerator) {
        this.abstractEvenAlgorithm = abstractEvenAlgorithm;
        this.statisticsGenerator = statisticsGenerator;
    }

    @Override
    public double getRandom() {
        if(anotherCoordinate != 0.0){
            double tmp = anotherCoordinate;
            anotherCoordinate = 0.0;
            return tmp;
        }
        double s;
        double v1;
        double v2;
        do {
             v1 = 2*abstractEvenAlgorithm.getRandom() - 1;
             v2 = 2*abstractEvenAlgorithm.getRandom() - 1;
             s = Math.pow(v1, 2) + Math.pow(v2, 2);
        }while(s >= 1);
        double factor = Math.sqrt(( -2 * Math.log(s)) / s);
        anotherCoordinate = v2 * factor;
        return v1 * factor;
    }

    @Override
    public String getStatistics() {
        return statisticsGenerator.getForNormalDistribution(this);
    }

    @Override
    public String toString() {
        return "*** \t " + this.getClass().getName();
    }
}
