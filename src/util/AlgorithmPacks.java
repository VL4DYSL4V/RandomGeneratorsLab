package util;

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

import java.util.HashMap;
import java.util.Map;

public class AlgorithmPacks {

    public static Map<Integer, LabRandom> standardAllRandomPack(){
        Map<Integer, LabRandom> labRandoms = new HashMap<>();
        AbstractEvenAlgorithm linearCongruentAlg = new LinearCongruentAlgorithm();
        AbstractEvenAlgorithm quadraticCongruentAlgorithm = new QuadraticCongruentAlgorithm();
        AbstractEvenAlgorithm fibonacciAlgorithm = new FibonacciAlgorithm();
        AbstractEvenAlgorithm inverseCongruentAlgorithm = new InverseCongruentAlgorithm();
        AbstractEvenAlgorithm differRandomsAlgorithm =
                new DifferRandomsAlgorithm(quadraticCongruentAlgorithm, linearCongruentAlg);
        labRandoms.put(0, linearCongruentAlg);
        labRandoms.put(1, quadraticCongruentAlgorithm);
        labRandoms.put(2, fibonacciAlgorithm);
        labRandoms.put(3, inverseCongruentAlgorithm);
        labRandoms.put(4, differRandomsAlgorithm);
        LabRandom threeSigmaLabRandom = new ThreeSigmaAlgorithm();
        LabRandom polarCoordinatesAlgorithm = new PolarCoordinatesAlgorithm(quadraticCongruentAlgorithm);
        LabRandom ratioAlgorithm = new RatioAlgorithm(linearCongruentAlg, quadraticCongruentAlgorithm);
        labRandoms.put(5, threeSigmaLabRandom);
        labRandoms.put(6, polarCoordinatesAlgorithm);
        labRandoms.put(7, ratioAlgorithm);
        LabRandom logarithmAlgorithm = new LogarithmAlgorithm(quadraticCongruentAlgorithm);
        LabRandom arensAlgorithm = new ArensAlgorithm(quadraticCongruentAlgorithm);
        labRandoms.put(8, logarithmAlgorithm);
        labRandoms.put(9, arensAlgorithm);
        return labRandoms;
    }
}
