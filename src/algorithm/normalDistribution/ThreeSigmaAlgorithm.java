package algorithm.normalDistribution;

import algorithm.evenDistribution.AbstractEvenAlgorithm;
import algorithm.evenDistribution.congruent.QuadraticCongruentAlgorithm;

public class ThreeSigmaAlgorithm implements NormalLabRandom {

    private AbstractEvenAlgorithm abstractEvenAlgorithm;
    private AbstractEvenAlgorithm defaultAbstractEvenAlgorithm = new QuadraticCongruentAlgorithm();
    // Контракт таков, что этот класс работает только с равномерным
    // распределением, так что в кастомизации этих параметров я не вижу смысла вообще
    private double mediana = 0.0;
    private double sigma = 1.0;

    public ThreeSigmaAlgorithm() {
        setDefaultConfig();
    }

    public ThreeSigmaAlgorithm(AbstractEvenAlgorithm algorithm) {
        this.abstractEvenAlgorithm = algorithm;
    }

    public void setCustomParameters(AbstractEvenAlgorithm algorithm) {
        this.abstractEvenAlgorithm = algorithm;
    }

    @Override
    public double getRandom() {
        double result = 0;
        for (int i = 0; i < 12; i++) {
            result += abstractEvenAlgorithm.getRandom();
        }
        return mediana + (result - 6) * sigma;
    }

    @Override
    public void setDefaultConfig() {
        mediana = 0.0;
        sigma = 1.0;
        this.abstractEvenAlgorithm = defaultAbstractEvenAlgorithm;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
