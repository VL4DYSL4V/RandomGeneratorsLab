package algorithm.evenDistribution.congruent;

import algorithm.evenDistribution.AbstractEvenAlgorithm;
import exception.InvalidParameterException;

public class InverseCongruentAlgorithm extends AbstractEvenAlgorithm {

    private int current = 1;
    private int a = 2;
    private int c = 3;
    private int mod = 2029;

    public InverseCongruentAlgorithm() {
        setDefaultConfig();
    }

    public void setCustomParameters(int a, int c, int exponent)throws InvalidParameterException{
        check(a, c, exponent);
        this.current = 1;
        this.a = a;
        this.c = c;
        this.mod = (int) Math.pow(2, exponent);
    }

    private void check(int a, int c, int exponent) throws InvalidParameterException {
        if(exponent < 3){
            throw new InvalidParameterException("Exponent must be >= 3");
        }
        if(a % 4 != 1 || c % 4 != 2){
            throw new InvalidParameterException("a % 4 must be 1, c % 4 must be 2");
        }
    }

    @Override
    protected double calculateNext() {
        double out;
        if (current != 0.0) {
            out = (a * getInverted(current) + c) % mod;
        } else {
            out = c;
        }
        current = (int) out;
        if (out < 0) {
            out *= -1;
        }
        return out;
    }

    @Override
    public int getMOD() {
        return mod;
    }

    private int getInverted(int target) {
        for (int i = 0; i <= mod; i++) {
            if ((i * target) % mod == 1) {
                return i;
            }
        }
        throw new IllegalStateException("Such inverse doesn't exist");
    }

    @Override
    public void setDefaultConfig() {
        this.current = 1;
        this.a = 2;
        this.c = 3;
        this.mod = 2029;
    }
}
