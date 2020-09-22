package algorithm.evenDistribution;

import algorithm.Random;
import enums.AlgorithmConstants;

public class DifferRandomsAlgorithm extends AbstractEvenAlgorithm {

    private Random generatorX;
    private Random generatorY;

    public DifferRandomsAlgorithm(Random generatorX, Random generatorY) {
        this.generatorX = generatorX;
        this.generatorY = generatorY;
    }

    @Override
    public double calculateNext() {
        double generated = (generatorX.getRandom() - generatorY.getRandom()) % AlgorithmConstants.MOD.getValue();
        if (generated < 0) {
            generated *= -1;
        }
        return generated;
    }
}
