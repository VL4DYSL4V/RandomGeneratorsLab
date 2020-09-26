package algorithm.evenDistribution.congruent;

import enums.AlgorithmConstants;
import algorithm.evenDistribution.AbstractEvenAlgorithm;
import exception.InvalidParameterException;
import util.IntegerUtils;

import java.util.List;

public class LinearCongruentAlgorithm extends AbstractEvenAlgorithm {

    private final IntegerUtils integerUtils = new IntegerUtils();
    private double seed = 331777.0;
    private int a;
    private int c;
    private int mod;

    public LinearCongruentAlgorithm() {
        setDefaultConfig();
    }

    public void setCustomParameters(int seed, int a, int c, int mod)throws InvalidParameterException{
        check(seed, a, c, mod);
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.mod = mod;
    }

    private void check(int seed, int a, int c, int mod) throws InvalidParameterException {
        if (mod <= 0 || a < 0 || c < 0 || seed < 0) {
            throw new InvalidParameterException("Params must be positive!");
        }
        if (a >= mod || c >= mod || seed >= mod) {
            throw new InvalidParameterException("Params must be less then mod!");
        }
        if(integerUtils.isPrime(mod)){
            return;
        }
        int b = a - 1;
        if(mod % 4 == 0 && b % 4 != 0){
            throw new InvalidParameterException("If mod % 4 == 0, then (a - 1) % 4 == 0");
        }
        if(! integerUtils.coprime(c, mod)){
            throw new InvalidParameterException("Mod and c must be coprime numbers!");
        }
        List<Integer> modFactors = integerUtils.getFactors(mod);
        modFactors.removeIf((entry) -> !integerUtils.isPrime(entry));
        for(Integer simpleFactor : modFactors){
            if(b < simpleFactor){
                return;
            }
            if(b % simpleFactor != 0){
                System.out.println(b);
                System.out.println(simpleFactor);
                throw new InvalidParameterException("(a - 1) must be divisible by all simple factors of mod!");
            }
        }
    }

    @Override
    protected double calculateNext() {
        seed = (a * seed + c) % mod;
        return seed;
    }

    @Override
    public int getMOD() {
        return mod;
    }

    @Override
    public void setDefaultConfig() {
//        this.current = 331777.0;
        this.a = AlgorithmConstants.A.getValue();
        this.c = AlgorithmConstants.C.getValue();
        this.mod = AlgorithmConstants.MAX_MOD.getValue();
    }

}
