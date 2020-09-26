package util;

import java.util.ArrayList;
import java.util.List;

public class IntegerUtils {

    public boolean isPrime(int a) {
        if (a <= 0) {
            return false;
        }
        if (a == 1 || a == 2 || a == 3) {
            return true;
        }
        if (a % 2 == 0) {
            return false;
        }
        int sqr = (int) Math.sqrt(a) + 1;
        for (int i = 3; i <= sqr; i += 2) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean coprime(int a, int b) {
        List<Integer> factorsOfC = getFactors(a);
        List<Integer> factorsOfMod = getFactors(b);
        for (Integer factC : factorsOfC) {
            if (factorsOfMod.contains(factC) && factC != 1) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        factors.add(number);
        int target = number;
        if (target % 2 == 0) {
            factors.add(2);
            while (target % 2 == 0) {
                target /= 2;
            }
        }

        for (int i = 3; i < target; i += 2) {
            if (target % i == 0) {
                factors.add(i);
            }
        }
        if (target != number && number % target == 0) {
            factors.add(target);
        }
        return factors;
    }
}
