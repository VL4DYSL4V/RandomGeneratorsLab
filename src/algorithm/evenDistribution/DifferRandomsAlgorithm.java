package algorithm.evenDistribution;

import statistics.StatisticsGenerator;

public class DifferRandomsAlgorithm extends AbstractEvenAlgorithm {

    private AbstractEvenAlgorithm generatorX;
    private AbstractEvenAlgorithm generatorY;

    public DifferRandomsAlgorithm(AbstractEvenAlgorithm generatorX, AbstractEvenAlgorithm generatorY, StatisticsGenerator statisticsGenerator) {
        super(statisticsGenerator);
        if (generatorY instanceof DifferRandomsAlgorithm || generatorX instanceof DifferRandomsAlgorithm) {
            throw new IllegalArgumentException("Class entirely relies on aggregation and can't generate sequences on its own");
        }
        this.generatorX = generatorX;
        this.generatorY = generatorY;
    }

    @Override
    protected double calculateNext() {
        double generated = generatorX.nextInt() - generatorY.nextInt();
        generated = generated < 0 ? generated * -1 : generated;
        generated %= super.getMOD().getValue();
        return generated;
    }

}
