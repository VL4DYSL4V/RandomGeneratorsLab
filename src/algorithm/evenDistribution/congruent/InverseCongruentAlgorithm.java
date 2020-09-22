package algorithm.evenDistribution.congruent;

import enums.AlgorithmConstants;
import algorithm.evenDistribution.AbstractEvenAlgorithm;

public class InverseCongruentAlgorithm extends AbstractEvenAlgorithm {

    private double current = 0; //1046527
    private final int a = -433494437;
    private final int c = 10501;
    @Override
    public double calculateNext() {
        double out = 0;
        if (Double.compare(current, 0.0) != 0) {
            out = (a / current + c) % AlgorithmConstants.MOD.getValue();
        } else {
            out = c;
        }
        current = out;
        if(out < 0){
            out *= -1;
        }
        return out;
    }

}
