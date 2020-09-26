package algorithm.evenDistribution;

import enums.AlgorithmConstants;
import exception.InvalidParameterException;

public class FibonacciAlgorithm extends AbstractEvenAlgorithm {
    private double xSecondPrev;
    private double xFirstPrev;
    private double mod;
    private double xCurr;

    public FibonacciAlgorithm() {
        setDefaultConfig();
    }

    public void setCustomParameters(int x0, int x1, int mod) throws InvalidParameterException{
        check(x0, x1, mod);
        this.xCurr = 0.0;
        this.xSecondPrev = x0;
        this.xFirstPrev = x1;
        this.mod = mod;
    }

    private void check(int x0, int x1, int mod) throws InvalidParameterException {
        if(x0 <= 0 || x1 <= 0 || mod <= 0){
            throw new InvalidParameterException("All params must be positive!");
        }
    }

    @Override
    protected double calculateNext() {
        double tmp = xCurr;
        xCurr = (xSecondPrev + xFirstPrev) % mod;
        xSecondPrev = xFirstPrev;
        xFirstPrev = tmp;
        return xCurr;
    }

    @Override
    public void setDefaultConfig() {
        this.xCurr = 0.0;
        this.xSecondPrev = 63245986.0;
        this.xFirstPrev = 102334155.0;
        this.mod = AlgorithmConstants.MAX_MOD.getValue();
    }

    @Override
    public int getMOD() {
        return (int) mod;
    }
}
