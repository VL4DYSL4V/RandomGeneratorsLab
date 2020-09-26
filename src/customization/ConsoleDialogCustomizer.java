package customization;

import algorithm.LabRandom;
import algorithm.anotherDistribution.AnotherLabRandom;
import algorithm.anotherDistribution.ArensAlgorithm;
import algorithm.anotherDistribution.LogarithmAlgorithm;
import algorithm.evenDistribution.AbstractEvenAlgorithm;
import algorithm.evenDistribution.DifferRandomsAlgorithm;
import algorithm.evenDistribution.EvenLabRandom;
import algorithm.evenDistribution.FibonacciAlgorithm;
import algorithm.evenDistribution.congruent.InverseCongruentAlgorithm;
import algorithm.evenDistribution.congruent.LinearCongruentAlgorithm;
import algorithm.evenDistribution.congruent.QuadraticCongruentAlgorithm;
import algorithm.normalDistribution.NormalLabRandom;
import algorithm.normalDistribution.PolarCoordinatesAlgorithm;
import algorithm.normalDistribution.RatioAlgorithm;
import algorithm.normalDistribution.ThreeSigmaAlgorithm;
import exception.InvalidParameterException;

import java.util.Map;
import java.util.Scanner;

/**Class will work correctly if only you will use standard all random pack as value, passed to constructor.
 * */
public class ConsoleDialogCustomizer implements Customizer{

    private final Map<Integer, LabRandom> labRandoms;

    public ConsoleDialogCustomizer(Map<Integer, LabRandom> labRandoms){
        this.labRandoms = labRandoms;
    }

    @Override
    public void customize(LabRandom labRandom) {
        Scanner sc = new Scanner(System.in);
        boolean successfulCustomization = false;
        do {
            System.out.println("If you are sure, input any symbol. If not, enter '-'");
            if ("-".equals(sc.next())) {
                return;
            }
            try {
                if (labRandom instanceof AnotherLabRandom) {
                    customizeAnother((AnotherLabRandom) labRandom);
                }else if(labRandom instanceof NormalLabRandom){
                   customizeNormal((NormalLabRandom) labRandom);
                }else if(labRandom instanceof EvenLabRandom){
                    customizeEven((EvenLabRandom) labRandom);
                }
                successfulCustomization = true;
            } catch (InvalidParameterException e) {
                System.out.println(e.getMessage());
            }
        } while (!successfulCustomization);
    }

    private void customizeAnother(AnotherLabRandom anotherLabRandom) throws InvalidParameterException {
        if (anotherLabRandom instanceof ArensAlgorithm) {
            customizeArens((ArensAlgorithm) anotherLabRandom);
        } else if (anotherLabRandom instanceof LogarithmAlgorithm) {
            customizeLogarithm((LogarithmAlgorithm) anotherLabRandom);
        }
    }

    private void customizeNormal(NormalLabRandom normalLabRandom){
        if(normalLabRandom instanceof RatioAlgorithm){
            customizeRatio((RatioAlgorithm) normalLabRandom);
        }else if(normalLabRandom instanceof PolarCoordinatesAlgorithm){
            customizePolar((PolarCoordinatesAlgorithm) normalLabRandom);
        }else if(normalLabRandom instanceof ThreeSigmaAlgorithm){
            customizeThreeSigma((ThreeSigmaAlgorithm) normalLabRandom);
        }
    }

    private void customizeEven(EvenLabRandom evenLabRandom) throws InvalidParameterException {
        if(evenLabRandom instanceof DifferRandomsAlgorithm){
            customizeDifferRandoms((DifferRandomsAlgorithm)evenLabRandom);
        }else if(evenLabRandom instanceof InverseCongruentAlgorithm){
            customizeInverse((InverseCongruentAlgorithm) evenLabRandom);
        }else if(evenLabRandom instanceof FibonacciAlgorithm){
            customizeFibonacci((FibonacciAlgorithm) evenLabRandom);
        }else if(evenLabRandom instanceof QuadraticCongruentAlgorithm){
            customizeQuadratic((QuadraticCongruentAlgorithm) evenLabRandom);
        }else if(evenLabRandom instanceof LinearCongruentAlgorithm){
            customizeLinear((LinearCongruentAlgorithm)evenLabRandom);
        }
    }

    private void customizeArens(ArensAlgorithm arensAlgorithm) throws InvalidParameterException {
        int a = repeatingPositiveIntegerRequest("a");
        arensAlgorithm.setCustomParameters(repeatingChooseEven(), a);
    }

    private void customizeLogarithm(LogarithmAlgorithm logarithmAlgorithm) throws InvalidParameterException {
        int mu = repeatingPositiveIntegerRequest("mu");
        logarithmAlgorithm.setCustomParameters(repeatingChooseEven(), mu);
    }

    private void customizeRatio(RatioAlgorithm ratioAlgorithm) {
        ratioAlgorithm.setCustomParameters(repeatingChooseEven(), repeatingChooseEven());
    }

    private void customizePolar(PolarCoordinatesAlgorithm polarCoordinatesAlgorithm){
        polarCoordinatesAlgorithm.setCustomParameters(repeatingChooseEven());
    }

    private void customizeThreeSigma(ThreeSigmaAlgorithm threeSigmaAlgorithm){
        threeSigmaAlgorithm.setCustomParameters(repeatingChooseEven());
    }

    private void customizeDifferRandoms(DifferRandomsAlgorithm differRandomsAlgorithm) throws InvalidParameterException {
        AbstractEvenAlgorithm abstractEvenAlgorithmX = repeatingChooseEvenForDiffer();
        AbstractEvenAlgorithm abstractEvenAlgorithmY = repeatingChooseEvenForDiffer();
        int mod = repeatingPositiveIntegerRequest("mod");
        differRandomsAlgorithm.setCustomParameters(abstractEvenAlgorithmX, abstractEvenAlgorithmY, mod);
    }

    private void customizeInverse(InverseCongruentAlgorithm inverseCongruentAlgorithm) throws InvalidParameterException {
        int a = repeatingPositiveIntegerRequest("a");
        int c = repeatingPositiveIntegerRequest("c");
        int exponent = repeatingPositiveIntegerRequest("exponent");
        inverseCongruentAlgorithm.setCustomParameters(a, c, exponent);
    }

    private void customizeFibonacci(FibonacciAlgorithm fibonacciAlgorithm) throws InvalidParameterException {
        int x0 = repeatingPositiveIntegerRequest("x0");
        int x1 = repeatingPositiveIntegerRequest("x1");
        int mod = repeatingPositiveIntegerRequest("mod");
        fibonacciAlgorithm.setCustomParameters(x0, x1, mod);
    }

    private void customizeQuadratic(QuadraticCongruentAlgorithm quadraticCongruentAlgorithm) throws InvalidParameterException {
        int seed = repeatingPositiveIntegerRequest("seed");
        int a = repeatingPositiveIntegerRequest("a");
        int c = repeatingPositiveIntegerRequest("c");
        int d = repeatingPositiveIntegerRequest("d");
        int mod = repeatingPositiveIntegerRequest("mod");
        quadraticCongruentAlgorithm.setCustomParameters(seed, a, c, d, mod);
    }

    private void customizeLinear(LinearCongruentAlgorithm linearCongruentAlgorithm) throws InvalidParameterException {
        int seed = repeatingPositiveIntegerRequest("seed");
        int a = repeatingPositiveIntegerRequest("a");
        int c = repeatingPositiveIntegerRequest("c");
        int mod = repeatingPositiveIntegerRequest("mod");
        linearCongruentAlgorithm.setCustomParameters(seed, a, c, mod);
    }

    private int repeatingPositiveIntegerRequest(String paramName){
        String input;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Input " + paramName + " - positive integer");
            input = sc.next();
        }while(!input.matches("[0-9]+"));
        return Integer.parseInt(input);
    }

    private AbstractEvenAlgorithm repeatingChooseEven() {
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.println("Enter number of appropriate algorithm: " +
                    "\n 1 - linear, 2 - quadratic, 3 - fibonacci, 4 - inverse, 5 - differ");
            input = sc.next();
        } while (!input.matches("[12345]"));
        return (AbstractEvenAlgorithm) getRandom(input);
    }

    private AbstractEvenAlgorithm repeatingChooseEvenForDiffer() {
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.println("Enter number of appropriate algorithm: " +
                    "\n 1 - linear, 2 - quadratic, 3 - fibonacci, 4 - inverse");
            input = sc.next();
        } while (!input.matches("[1234]"));
        return (AbstractEvenAlgorithm) getRandom(input);
    }

    private LabRandom getRandom(String input) {
        int key = Integer.parseInt(input) - 1;
        return labRandoms.get(key);
    }

}
