package algorithmlab;

import algorithm.evenDistribution.DifferRandomsAlgorithm;
import algorithm.evenDistribution.congruent.InverseCongruentAlgorithm;
import algorithm.evenDistribution.congruent.LinearCongruentAlgorithm;
import algorithm.Random;
import algorithm.evenDistribution.congruent.QuadraticCongruentAlgorithm;
import algorithm.evenDistribution.FibonacciAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmLab {

    //TODO: InverseCongruentAlgorithm is not working.
    public static void main(String[] args) {
        List<Random> randoms = new ArrayList<>(10);
        Random linearCongruentAlg = new LinearCongruentAlgorithm();
        Random quadraticCongruentAlgorithm = new QuadraticCongruentAlgorithm();
        Random fibonacciAlgorithm = new FibonacciAlgorithm();
        randoms.add(linearCongruentAlg);
        randoms.add(quadraticCongruentAlgorithm);
        randoms.add(new InverseCongruentAlgorithm());
        randoms.add(fibonacciAlgorithm);
        randoms.add(new DifferRandomsAlgorithm(fibonacciAlgorithm, fibonacciAlgorithm));
        randoms.forEach((random) -> {
            System.out.println(random);
            testRandom(random);
        });
    }

    private static void testRandom(Random random) {
        for (int i = 0; i < 10; i++) {
            System.out.println(random.getRandom());
        }
    }
}


