package algorithm.evenDistribution;

import algorithm.evenDistribution.congruent.LinearCongruentAlgorithm;
import algorithm.evenDistribution.congruent.QuadraticCongruentAlgorithm;
import exception.InvalidParameterException;

public class DifferRandomsAlgorithm extends AbstractEvenAlgorithm {
    private AbstractEvenAlgorithm defaultX = new QuadraticCongruentAlgorithm();
    private AbstractEvenAlgorithm defaultY = new LinearCongruentAlgorithm();

    private AbstractEvenAlgorithm generatorX;
    private AbstractEvenAlgorithm generatorY;
    private int mod;

    public DifferRandomsAlgorithm() {
        setDefaultConfig();
    }

    public DifferRandomsAlgorithm(AbstractEvenAlgorithm generatorX, AbstractEvenAlgorithm generatorY) {
        checkAlgorithms(generatorX, generatorY);
        this.mod = super.getMOD();
        this.generatorX = generatorX;
        this.generatorY = generatorY;
    }

    public void setCustomParameters(AbstractEvenAlgorithm generatorX, AbstractEvenAlgorithm generatorY,
                                    int mod) throws InvalidParameterException {
        checkAlgorithms(generatorX, generatorY);
        checkMod(mod);
        this.mod = mod;
    }

    private void checkAlgorithms(AbstractEvenAlgorithm generatorX, AbstractEvenAlgorithm generatorY) {
        if (generatorY instanceof DifferRandomsAlgorithm || generatorX instanceof DifferRandomsAlgorithm) {
            throw new IllegalArgumentException("Class entirely relies on aggregation and can't generate sequences on its own");
        }
    }

    private void checkMod(int mod) throws InvalidParameterException {
        if (mod <= 0) {
            throw new InvalidParameterException("Mod must be positive");
        }
    }

    @Override
    protected double calculateNext() {
        double generated = generatorX.nextInt() - generatorY.nextInt();
        generated = generated < 0 ? generated * -1 : generated;
        generated %= mod;
        return generated;
    }

    @Override
    public void setDefaultConfig() {
        this.mod = super.getMOD();
        this.generatorX = defaultX;
        this.generatorY = defaultY;
    }

    @Override
    public int getMOD() {
        return mod;
    }
}
