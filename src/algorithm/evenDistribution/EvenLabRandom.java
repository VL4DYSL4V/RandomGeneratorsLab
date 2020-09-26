package algorithm.evenDistribution;

import algorithm.LabRandom;
import statistics.StatisticsGenerator;

public interface EvenLabRandom extends LabRandom {
    @Override
    default String getStatistics(StatisticsGenerator statisticsGenerator){
        return statisticsGenerator.getForEvenDistribution(this);
    }
}
