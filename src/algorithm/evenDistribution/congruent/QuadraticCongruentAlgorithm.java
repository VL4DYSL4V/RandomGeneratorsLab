package algorithm.evenDistribution.congruent;

import enums.AlgorithmConstants;
import algorithm.evenDistribution.AbstractEvenAlgorithm;
import exception.InvalidParameterException;
import util.IntegerUtils;

import java.util.List;

public class QuadraticCongruentAlgorithm extends AbstractEvenAlgorithm {

    private IntegerUtils integerUtils = new IntegerUtils();
    private double seed = 333667.0;
    private int a;
    private int c;
    private int d;
    private int mod;

    public QuadraticCongruentAlgorithm() {
        setDefaultConfig();
    }

    public void setCustomParameters(int seed, int a, int c, int d, int mod) throws InvalidParameterException {
        check(seed, a, c, d, mod);
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.d = d;
        this.mod = mod;
    }

    private void check(int seed, int a, int c, int d, int mod) throws InvalidParameterException {
        if (mod <= 0 || a < 0 || c < 0 || d < 0 || seed < 0) {
            throw new InvalidParameterException("Params must be positive!");
        }
        if (a >= mod || c >= mod || d > 0 || seed >= mod) {
            throw new InvalidParameterException("Params must be less then mod!");
        }
        if (integerUtils.isPrime(mod)) {
            return;
        }
        if (!integerUtils.coprime(c, mod)) {
            throw new InvalidParameterException("Mod and c must be coprime numbers!");
        }
        if (mod % 3 == 0 && 3 * c % 9 == d) {
            throw new InvalidParameterException("d != 3c mod 9, if mod % 3 == 0");
        }
        int b = a - 1; //Conditions are commented, because they are redundant
        /*if (mod % 4 == 0 && d != b % 4 && d % 2 != 0) {
            throw new InvalidParameterException("d must be divisible by 2 if mod % 4 == 0 then d = (a - 1) % 4");
        } else*/ if (mod % 2 == 0 && d != b % 2) {
            throw new InvalidParameterException("if mod % 2 == 0 then d = (a - 1) % 2");
        }
        List<Integer> modFactors = integerUtils.getFactors(mod);
        modFactors.removeIf((entry) -> !integerUtils.isPrime(entry));
        for (Integer simpleFactor : modFactors) {
            if (simpleFactor > b || simpleFactor > d) {
                break;
            }
            if (/*d % simpleFactor != 0 ||*/b % simpleFactor != 0) {
                throw new InvalidParameterException("d and (a - 1) must be divisible by all simple factors of mod!");
            }
        }

    }

    @Override
    protected double calculateNext() {
        seed = (d * Math.pow(seed, 2) + a * seed + c) % mod;
        return seed;
    }

    @Override
    public int getMOD() {
        return mod;
    }

    @Override
    public void setDefaultConfig() {
        this.a = AlgorithmConstants.A.getValue();
        this.c = AlgorithmConstants.C.getValue();
        this.d = AlgorithmConstants.D.getValue();
        this.mod = AlgorithmConstants.MIN_MOD.getValue();
    }
}
