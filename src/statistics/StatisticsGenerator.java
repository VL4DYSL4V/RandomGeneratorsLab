package statistics;

import algorithm.LabRandom;
import algorithm.anotherDistribution.AnotherLabRandom;
import algorithm.evenDistribution.EvenLabRandom;
import algorithm.normalDistribution.NormalLabRandom;

public interface StatisticsGenerator {

    String getForEvenDistribution(EvenLabRandom random);

    String getForNormalDistribution(NormalLabRandom random);

    String getForAnotherDistribution(AnotherLabRandom random);

    String getForAnyRandom(LabRandom labRandom, double leftIntervalBorder, double rightIntervalBorder, double step);
}
