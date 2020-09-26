package algorithm.evenDistribution;

import enums.AlgorithmConstants;

public abstract class AbstractEvenAlgorithm implements EvenLabRandom {

    @Override
    public double getRandom() {
        return calculateNext() / getMOD();
    }

    protected abstract double calculateNext();

    public int getMOD(){
        return AlgorithmConstants.MAX_MOD.getValue();
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    public final int nextInt() {
        return (int) calculateNext();
    }
}
