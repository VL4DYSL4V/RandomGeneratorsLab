package Main;

import app.Application;
import statistics.LabStatisticsGenerator;

//TODO: InverseCongruentAlgorithm works, but not properly.
public class Main {

    public static void main(String[] args) {
        Application application = new Application(new LabStatisticsGenerator());
        application.run();
    }

}


