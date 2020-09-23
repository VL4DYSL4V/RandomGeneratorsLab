package app;

import algorithm.Random;
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
    private List<Random> randoms = new ArrayList<>(10);
    private final String greeting = "Hi! This is Vladislav's laboratory work.";
    private final String inputManual = "Please, enter number from 0 to 9 (incl) to see diagrams\n" +
            " for different pseudorandom generators. To exit, enter stop";

    public Application(StatisticsGenerator statisticsGenerator) {
        initRandoms(statisticsGenerator);
    }

    public void run() {
        System.out.println(greeting);
        Scanner sc = new Scanner(System.in);
        int index;
        String input;
        do {
            System.out.println(inputManual);
            input = sc.next();
            if (!input.matches("[0-9]")) {
                continue;
            }
            index = Integer.parseInt(input);
            Random random = randoms.get(index);
            System.out.println(random);
            System.out.println(random.getStatistics());
        } while (!"stop".equals(input.toLowerCase().trim()));
    }

    private void initRandoms(StatisticsGenerator statisticsGenerator) {
        AbstractEvenAlgorithm linearCongruentAlg = new LinearCongruentAlgorithm(statisticsGenerator);
        AbstractEvenAlgorithm quadraticCongruentAlgorithm = new QuadraticCongruentAlgorithm(statisticsGenerator);
        AbstractEvenAlgorithm fibonacciAlgorithm = new FibonacciAlgorithm(statisticsGenerator);
        AbstractEvenAlgorithm inverseCongruentAlgorithm = new InverseCongruentAlgorithm(statisticsGenerator);   //    --
        AbstractEvenAlgorithm differRandomsAlgorithm =
                new DifferRandomsAlgorithm(quadraticCongruentAlgorithm, linearCongruentAlg, statisticsGenerator);
        randoms.add(linearCongruentAlg);
        randoms.add(quadraticCongruentAlgorithm);
        randoms.add(fibonacciAlgorithm);
        randoms.add(differRandomsAlgorithm);
        randoms.add(inverseCongruentAlgorithm);
        Random threeSigmaRandom = new ThreeSigmaAlgorithm(statisticsGenerator, linearCongruentAlg);
        Random ratioAlgorithm = new RatioAlgorithm(linearCongruentAlg, quadraticCongruentAlgorithm, statisticsGenerator);
        Random polarCoordinatesAlgorithm = new PolarCoordinatesAlgorithm(quadraticCongruentAlgorithm, statisticsGenerator);
        randoms.add(threeSigmaRandom);
        randoms.add(ratioAlgorithm);
        randoms.add(polarCoordinatesAlgorithm);
        Random logarithmAlgorithm = new LogarithmAlgorithm(quadraticCongruentAlgorithm, statisticsGenerator);
        Random arensAlgorithm = new ArensAlgorithm(quadraticCongruentAlgorithm, statisticsGenerator);
        randoms.add(logarithmAlgorithm);
        randoms.add(arensAlgorithm);
    }

    private void printAllStatistics() {
        randoms.forEach((random) -> {
            System.out.println(random);
            System.out.println(random.getStatistics());
        });
    }
}
