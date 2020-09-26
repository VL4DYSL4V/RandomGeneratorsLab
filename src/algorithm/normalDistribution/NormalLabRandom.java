package algorithm.normalDistribution;

import algorithm.LabRandom;
import statistics.StatisticsGenerator;

public interface NormalLabRandom extends LabRandom {

    @Override
    default String getStatistics(StatisticsGenerator statisticsGenerator){
        return statisticsGenerator.getForNormalDistribution(this);
    }
}
