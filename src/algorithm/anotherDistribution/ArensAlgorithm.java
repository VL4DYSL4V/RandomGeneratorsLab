package algorithm.anotherDistribution;

import algorithm.evenDistribution.AbstractEvenAlgorithm;
import algorithm.evenDistribution.congruent.QuadraticCongruentAlgorithm;
import exception.InvalidParameterException;

public class ArensAlgorithm implements AnotherLabRandom {

    private AbstractEvenAlgorithm abstractEvenAlgorithm;
    private final AbstractEvenAlgorithm defaultEvenAlgorithm = new QuadraticCongruentAlgorithm();
    private double a = 2.1;

    public ArensAlgorithm() {
        setDefaultConfig();
    }

    public ArensAlgorithm(AbstractEvenAlgorithm abstractEvenAlgorithm) {
        this.abstractEvenAlgorithm = abstractEvenAlgorithm;
    }

    public void setCustomParameters(AbstractEvenAlgorithm abstractEvenAlgorithm, int a)throws InvalidParameterException{
        check(a);
        this.abstractEvenAlgorithm = abstractEvenAlgorithm;
        this.a = a;
    }

    private void check(int a) throws InvalidParameterException {
        if (a <= 1){
            throw new InvalidParameterException("a must be bigger than 1");
        }
    }

    @Override
    public double getRandom() {
        double y;
        double x;
        double v;
        do {
            do {
                double u = abstractEvenAlgorithm.getRandom();
                y = initY(u);
                x = initX(y);
            } while (x <= 0);
            v = abstractEvenAlgorithm.getRandom();
        } while (!valueBiggerThanRandom(v, y, x));
        return x;
    }

    private double initY(double u) {
        return Math.tan(Math.PI * u);
    }

    private double initX(double y) {
        return Math.sqrt(2 * a - 1) * y + a - 1;
    }

    private boolean valueBiggerThanRandom(double random, double y, double x) {
        return random > (1 + Math.pow(y, 2)) * Math.pow(Math.E, exponentOfEInFormula(x, y));
    }

    private double exponentOfEInFormula(double x, double y) {
        return (a - 1) * Math.log(x / (a - 1)) - Math.sqrt(2 * a - 1) * y;
    }

    @Override
    public void setDefaultConfig() {
        this.a = 2.1;
        this.abstractEvenAlgorithm = defaultEvenAlgorithm;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
