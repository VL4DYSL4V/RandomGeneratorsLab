package algorithm.evenDistribution;

import enums.AlgorithmConstants;
import statistics.StatisticsGenerator;

public class FibonacciAlgorithm extends AbstractEvenAlgorithm {

    //    private double xSecondPrev = 514229.0;//29-th fibonacci number, is simple
//    private double xFirstPrev = 832040.0; //30th fibonacci number

    private double xSecondPrev = 63245986.0;
    private double xFirstPrev = 102334155.0;
    private double xCurr = 0.0;

    public FibonacciAlgorithm(StatisticsGenerator statisticsGenerator) {
        super(statisticsGenerator);
    }

    @Override
    protected double calculateNext() {
        double tmp = xCurr;
        xCurr = (xSecondPrev + xFirstPrev) % AlgorithmConstants.MAX_MOD.getValue();
        xSecondPrev = xFirstPrev;
        xFirstPrev = tmp;
        return xCurr;
    }
}
