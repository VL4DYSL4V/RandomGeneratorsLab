package algorithm;

import statistics.StatisticsGenerator;

public interface LabRandom {

    double getRandom();

    String getStatistics(StatisticsGenerator statisticsGenerator);

    void setDefaultConfig();
}
