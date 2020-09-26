package algorithm.anotherDistribution;

import algorithm.LabRandom;
import statistics.StatisticsGenerator;

public interface AnotherLabRandom extends LabRandom {

    @Override
    default String getStatistics(StatisticsGenerator statisticsGenerator){
        return statisticsGenerator.getForAnotherDistribution(this);
    }
}
