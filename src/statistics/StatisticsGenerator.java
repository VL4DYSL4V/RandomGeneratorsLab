package statistics;

import algorithm.Random;

public interface StatisticsGenerator {

    String getForEvenDistribution(Random random);

    String getForNormalDistribution(Random random);

    String getForAnotherDistribution(Random random);
}
