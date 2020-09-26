package main;

import app.Application;
import statistics.LabStatisticsGenerator;
import statistics.StatisticsGenerator;

//TODO: Parameter input logic;
public class Main {

    public static void main(String[] args){
        StatisticsGenerator statisticsGenerator = new LabStatisticsGenerator(10_000);
        Application application = new Application(statisticsGenerator);
        application.run();
    }

}


