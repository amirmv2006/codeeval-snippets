package ir.amv.snippets.codeeval.sumofprimes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMV on 8/2/2016.
 */
public class SumOfPrimes {

    public static void main(String[] args) {
        List<Integer> primeNums = new ArrayList<Integer>();
        int count = primeNums.size();
        for (int i = 2; count < 1000; i++) {
            boolean isPrime = true;
            for (Integer primeNum : primeNums) {
                if (i % primeNum == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNums.add(i);
                count = primeNums.size();
            }
        }
        Integer result = 0;
        for (Integer primeNum : primeNums) {
            result += primeNum;
        }
        System.out.println(result);
    }
}
