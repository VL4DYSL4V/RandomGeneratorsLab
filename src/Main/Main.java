package Main;

import app.Application;
import statistics.LabStatisticsGenerator;

//TODO: Lab is finished, but InverseCongruentAlgorithm doesn't work properly.
public class Main {

    public static void main(String[] args) {
        Application application = new Application(new LabStatisticsGenerator());
        application.run();
    }

}


