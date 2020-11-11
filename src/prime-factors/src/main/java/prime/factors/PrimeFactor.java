package prime.factors;

import java.util.ArrayList;

public class PrimeFactor {
    public static ArrayList<Long> generate(Long number) {
        ArrayList<Long> factorization = new ArrayList<Long>();
        Long index = Long.valueOf(2);
        for (; index < number; index++) {
            while (number % index == 0) {
                factorization.add(index);
                number = number / index;
            }
        }
        if (number > 2) {
            factorization.add(number);
        }
        return factorization;
    }
}
