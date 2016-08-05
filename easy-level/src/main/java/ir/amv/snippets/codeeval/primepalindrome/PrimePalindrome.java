package ir.amv.snippets.codeeval.primepalindrome;

/**
 * Created by AMV on 8/1/2016.
 */
public class PrimePalindrome {

    public static void main(String[] args) {
        for (int i = 1000; i > 0; i--) {
            int halfI = i / 2;
            boolean isPalindromic = true;
            double v = Math.log10(i);
            int round = (int) Math.floor(v);
            round++;
            for (int l = 0; l < round / 2; l++) {
                String s = String.valueOf(i);
                if (s.charAt(l) != s.charAt(round - l - 1)) {
                    isPalindromic = false;
                    break;
                }
            }
            if (!isPalindromic) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 2; j < halfI; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (!isPrime) {
                continue;
            }
            System.out.println("i = " + i);
            break;
        }
    }

}
