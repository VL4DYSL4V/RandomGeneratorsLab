package algorithm.anotherDistribution;

import algorithm.evenDistribution.AbstractEvenAlgorithm;
import algorithm.evenDistribution.congruent.QuadraticCongruentAlgorithm;
import exception.InvalidParameterException;

public class LogarithmAlgorithm implements AnotherLabRandom {

    private double mu = 17.0;
    private AbstractEvenAlgorithm abstractEvenAlgorithm;
    private final AbstractEvenAlgorithm defaultEvenAlgorithm = new QuadraticCongruentAlgorithm();

    public LogarithmAlgorithm() {
        setDefaultConfig();
    }

    public LogarithmAlgorithm(AbstractEvenAlgorithm abstractEvenAlgorithm) {
        this.abstractEvenAlgorithm = abstractEvenAlgorithm;
    }

    public void setCustomParameters(AbstractEvenAlgorithm abstractEvenAlgorithm, int mu)throws InvalidParameterException{
        check(mu);
        this.mu = mu;
        this.abstractEvenAlgorithm = abstractEvenAlgorithm;
    }

    private void check(int mu) throws InvalidParameterException {
        if (mu <= 1){
            throw new InvalidParameterException("mu must be bigger than 1");
        }
    }
    @Override
    public double getRandom() {
        double u;
        do{
            u = abstractEvenAlgorithm.getRandom();
        }while (u == 0.0);
        return -1 * mu * Math.log(u);
    }

    @Override
    public void setDefaultConfig() {
        this.mu = 17.0;
        this.abstractEvenAlgorithm = defaultEvenAlgorithm;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
