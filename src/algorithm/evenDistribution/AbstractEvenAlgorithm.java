package algorithm.evenDistribution;

import algorithm.Random;
import enums.AlgorithmConstants;

public abstract class AbstractEvenAlgorithm implements Random {

    @Override
    public double getRandom() {
        return correctDegreeMaker(calculateNext()) / AlgorithmConstants.MOD.getValue();
    }

    public abstract double calculateNext();

    public final double correctDegreeMaker(double number){
        double generated = number;
        while (Double.compare(generated, ((double) AlgorithmConstants.MOD.getValue()) / 10) == -1) {
            generated *= 10;
        }
        return generated;
    }

    @Override
    public String toString() {
        return "*** \t " + this.getClass().getName();
    }

}
