package algorithm.normalDistribution;

import algorithm.evenDistribution.AbstractEvenAlgorithm;
import algorithm.evenDistribution.congruent.QuadraticCongruentAlgorithm;

public class PolarCoordinatesAlgorithm implements NormalLabRandom {

    private AbstractEvenAlgorithm abstractEvenAlgorithm;
    private final AbstractEvenAlgorithm defaultEvenAlgorithm = new QuadraticCongruentAlgorithm();;
    private double anotherCoordinate = 0.0;

    public PolarCoordinatesAlgorithm() {
        setDefaultConfig();
    }

    public PolarCoordinatesAlgorithm(AbstractEvenAlgorithm abstractEvenAlgorithm) {
        this.abstractEvenAlgorithm = abstractEvenAlgorithm;
    }

    public void setCustomParameters(AbstractEvenAlgorithm abstractEvenAlgorithm){
        this.abstractEvenAlgorithm = abstractEvenAlgorithm;
    }

    @Override
    public double getRandom() {
        if (anotherCoordinate != 0.0) {
            double tmp = anotherCoordinate;
            anotherCoordinate = 0.0;
            return tmp;
        }
        double s;
        double v1;
        double v2;
        do {
            v1 = 2 * abstractEvenAlgorithm.getRandom() - 1;
            v2 = 2 * abstractEvenAlgorithm.getRandom() - 1;
            s = Math.pow(v1, 2) + Math.pow(v2, 2);
        } while (s >= 1);
        double factor = Math.sqrt((-2 * Math.log(s)) / s);
        anotherCoordinate = v2 * factor;
        return v1 * factor;
    }

    @Override
    public void setDefaultConfig() {
        this.anotherCoordinate = 0.0;
        this.abstractEvenAlgorithm = defaultEvenAlgorithm;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
