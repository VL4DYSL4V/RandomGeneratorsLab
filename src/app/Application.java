package app;

import algorithm.LabRandom;
import algorithm.anotherDistribution.ArensAlgorithm;
import algorithm.anotherDistribution.LogarithmAlgorithm;
import algorithm.evenDistribution.AbstractEvenAlgorithm;
import algorithm.evenDistribution.DifferRandomsAlgorithm;
import algorithm.evenDistribution.FibonacciAlgorithm;
import algorithm.evenDistribution.congruent.InverseCongruentAlgorithm;
import algorithm.evenDistribution.congruent.LinearCongruentAlgorithm;
import algorithm.evenDistribution.congruent.QuadraticCongruentAlgorithm;
import algorithm.normalDistribution.PolarCoordinatesAlgorithm;
import algorithm.normalDistribution.RatioAlgorithm;
import algorithm.normalDistribution.ThreeSigmaAlgorithm;
import statistics.StatisticsGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private List<LabRandom> labRandoms = new ArrayList<>(10);
    private final String greeting = "Hi! This is Vladislav's (From K-23) laboratory work.";
    private final String inputManual = "Please, enter number from 1 to 10 (incl) to see diagrams for different pseudorandom\n"
            + "generators.To see all statistics, enter 'all'. To exit, enter stop";

    public Application(StatisticsGenerator statisticsGenerator) {
        initRandoms(statisticsGenerator);
    }

    public void run() {
        System.out.println(greeting);
        Scanner sc = new Scanner(System.in);
        int index;
        String input = "";
        do {
            System.out.println(inputManual);
            input = sc.next().toLowerCase().trim();
            if (input.matches("[1-9]|10")) {
                index = Integer.parseInt(input) - 1;
                LabRandom labRandom = labRandoms.get(index);
                System.out.println(labRandom);
                System.out.println(labRandom.getStatistics());
            }else if(input.matches("all")){
                printAllStatistics();
            }
        } while (!"stop".equals(input));
    }

    private void initRandoms(StatisticsGenerator statisticsGenerator) {
        AbstractEvenAlgorithm linearCongruentAlg = new LinearCongruentAlgorithm(statisticsGenerator);
        AbstractEvenAlgorithm quadraticCongruentAlgorithm = new QuadraticCongruentAlgorithm(statisticsGenerator);
        AbstractEvenAlgorithm fibonacciAlgorithm = new FibonacciAlgorithm(statisticsGenerator);
        AbstractEvenAlgorithm inverseCongruentAlgorithm = new InverseCongruentAlgorithm(statisticsGenerator);   //    --
        AbstractEvenAlgorithm differRandomsAlgorithm =
                new DifferRandomsAlgorithm(quadraticCongruentAlgorithm, linearCongruentAlg, statisticsGenerator);
        labRandoms.add(linearCongruentAlg);
        labRandoms.add(quadraticCongruentAlgorithm);
        labRandoms.add(fibonacciAlgorithm);
        labRandoms.add(inverseCongruentAlgorithm);
        labRandoms.add(differRandomsAlgorithm);
        LabRandom threeSigmaLabRandom = new ThreeSigmaAlgorithm(statisticsGenerator, linearCongruentAlg);
        LabRandom polarCoordinatesAlgorithm = new PolarCoordinatesAlgorithm(quadraticCongruentAlgorithm, statisticsGenerator);
        LabRandom ratioAlgorithm = new RatioAlgorithm(linearCongruentAlg, quadraticCongruentAlgorithm, statisticsGenerator);
        labRandoms.add(threeSigmaLabRandom);
        labRandoms.add(polarCoordinatesAlgorithm);
        labRandoms.add(ratioAlgorithm);
        LabRandom logarithmAlgorithm = new LogarithmAlgorithm(quadraticCongruentAlgorithm, statisticsGenerator);
        LabRandom arensAlgorithm = new ArensAlgorithm(quadraticCongruentAlgorithm, statisticsGenerator);
        labRandoms.add(logarithmAlgorithm);
        labRandoms.add(arensAlgorithm);
    }

    private void printAllStatistics() {
        labRandoms.forEach((random) -> {
            System.out.println(random);
            System.out.println(random.getStatistics());
        });
    }
}
