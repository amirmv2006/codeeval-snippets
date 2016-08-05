package ir.amv.snippets.codeeval.luckytickets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by AMV on 8/4/2016.
 */
public class LuckyTickets {

    public static void main(String[] args) throws IOException {
        File file = new File("moderate-level/LuckyTickets.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            int halfDigitCount = Integer.parseInt(line) / 2;
            int maxSumOfDigits = halfDigitCount * 9;
            BigInteger result = new BigInteger("0");
            int loopCount = maxSumOfDigits / 2;
            for (int i = 0; i <= loopCount; i++) {
                BigInteger numCountWithSum_i = noOfNumWithSum10Base(i, halfDigitCount);
                if (i == maxSumOfDigits - i) {
                    result = result.add(numCountWithSum_i.multiply(numCountWithSum_i));
                } else {
                    result = result.add(numCountWithSum_i.multiply(numCountWithSum_i).multiply(new BigInteger("2")));
                }
            }
            System.out.println(result);
        }
    }

    private static BigInteger noOfNumWithSum10Base(int sum, int digitCount) {
        BigInteger calc = noOfNumWithSumAnyDigit(sum, digitCount);
        boolean shouldAdd = false;
        int counter = 1;
        while (sum > 9) {
            sum -= 10;
            if (shouldAdd) {
                calc = calc.add(noOfNumWithSumAnyDigit(sum, digitCount).multiply(combination(digitCount, counter)));
            } else {
                calc = calc.subtract(noOfNumWithSumAnyDigit(sum, digitCount).multiply(combination(digitCount, counter)));
            }
            shouldAdd = !shouldAdd;
            counter += 1;
        }
        return calc;
    }

    private static BigInteger noOfNumWithSumAnyDigit(int sum, int digitCount) {
        return combination(sum + digitCount - 1, digitCount - 1);
    }

    private static BigInteger combination(int n, int k) {
        if (k == 0 || k == n) {
            return new BigInteger("1");
        }
        int bigger = Math.max(k, n-k);
        int smaller = Math.min(k, n-k);
        BigInteger result = new BigInteger("1");
        for (int i = bigger + 1; i <= n; i++) {
            result = result.multiply(new BigInteger(i + ""));
        }
        return result.divide(factorial(smaller));
    }

    private static BigInteger factorial(int num) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= num ;i++) {
            result = result.multiply(new BigInteger("" + i));
        }
        return result;
    }
}
