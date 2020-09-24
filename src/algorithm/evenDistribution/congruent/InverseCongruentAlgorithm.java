package algorithm.evenDistribution.congruent;

import enums.AlgorithmConstants;
import algorithm.evenDistribution.AbstractEvenAlgorithm;
import statistics.StatisticsGenerator;

public class InverseCongruentAlgorithm extends AbstractEvenAlgorithm {

//    private double current = 35317.0; //5795
//    private final double a = -433494437.0; //Полином x^2 - cx - a должен быть неприводим над данным полем. a = -433494437
//    private final double c = 10501.0;//10501

    private int current = 1; // x = 1
    private final int a = 241; // a mod 4 = 1
    private final int c = 6; // c mod 4 = 2;
    private final int m = 10111;
//    private double current = 1; //5795
//    private final int a = 433494437; //Полином x^2 - cx - a должен быть неприводим над данным полем. a = -433494437
//    private final int c = 10501;//10501

    public InverseCongruentAlgorithm(StatisticsGenerator statisticsGenerator) {
        super(statisticsGenerator);
    }

    @Override
    protected double calculateNext() {
//        if (current != a) {
//            current = (a / current + c) % 4096;
//        } else {
//            current = c;
//        }
////        if (current != 0) {
////            current = (a / current + c) % AlgorithmConstants.MOD_FOR_INVERSE.getValue();
////        System.out.println(current);
////        } else {
////            current = c;
////        }
//        return current;
        current = (a / current + c) % m;
        System.out.println(current);
        return current;
//        return legacyAlgorithm();
    }
//
    @Override
    public double getRandom() {
        return this.calculateNext() / m;
    }

    private double legacyAlgorithm() {
        double out;
        if (current != 0.0) {
            out = (a / current + c) % super.getMOD().getValue();
        } else {
            out = c;
        }
        current = (int) out;
        if (out < 0) {
            out *= -1;
        }
        out = super.correctDegreeMaker(out);
        return out;
    }
}
