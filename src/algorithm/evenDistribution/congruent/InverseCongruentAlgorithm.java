package algorithm.evenDistribution.congruent;

import enums.AlgorithmConstants;
import algorithm.evenDistribution.AbstractEvenAlgorithm;
import statistics.StatisticsGenerator;

public class InverseCongruentAlgorithm extends AbstractEvenAlgorithm {

    private double current = 35317; //5795
    private final int a = -433494437; //Полином x^2 - cx - a должен быть неприводим над данным полем. a = -433494437
    private final int c = 10501;//10501

    public InverseCongruentAlgorithm(StatisticsGenerator statisticsGenerator) {
        super(statisticsGenerator);
    }

    @Override
    protected double calculateNext() {
        double out;
        if (Double.compare(current, 0.0) != 0) {
            out = (a / current + c) % super.getMOD().getValue();
        } else {
            out = c;
        }
        current = out;
        if (out < 0) {
            out *= -1;
        }
        out = super.correctDegreeMaker(out);
        System.out.println(out / super.getMOD().getValue());
        return out;
    }

}
