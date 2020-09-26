package algorithm.normalDistribution;

import algorithm.evenDistribution.AbstractEvenAlgorithm;
import algorithm.evenDistribution.congruent.LinearCongruentAlgorithm;
import algorithm.evenDistribution.congruent.QuadraticCongruentAlgorithm;

public class RatioAlgorithm implements NormalLabRandom {

    private AbstractEvenAlgorithm abstractEvenAlgorithm1;
    private AbstractEvenAlgorithm abstractEvenAlgorithm2;
    private AbstractEvenAlgorithm defaultEvenAlgorithm1;
    private AbstractEvenAlgorithm defaultEvenAlgorithm2;

    public RatioAlgorithm() {
        this.defaultEvenAlgorithm1 = new LinearCongruentAlgorithm();
        this.defaultEvenAlgorithm2 = new QuadraticCongruentAlgorithm();
        setDefaultConfig();
    }

    public RatioAlgorithm(AbstractEvenAlgorithm algorithm1, AbstractEvenAlgorithm algorithm2) {
        this();
        this.abstractEvenAlgorithm1 = algorithm1;
        this.abstractEvenAlgorithm2 = algorithm2;
    }

    public void setCustomParameters(AbstractEvenAlgorithm algorithm1, AbstractEvenAlgorithm algorithm2){
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
    public void setDefaultConfig() {
        this.abstractEvenAlgorithm1 = defaultEvenAlgorithm1;
        this.abstractEvenAlgorithm2 = defaultEvenAlgorithm2;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
