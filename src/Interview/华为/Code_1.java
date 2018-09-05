package Interview.华为;

import java.math.BigInteger;
import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        BigInteger r = new BigInteger("1");
        BigInteger sum1 = new BigInteger("0");
        BigInteger sum2 = new BigInteger("0");
        for (int i = s1.length() - 1; i >= 0; i--) {
            int num = s1.charAt(i) - 'a';
            sum1 = sum1.add(BigInteger.valueOf(num).multiply(r));
            r = r.multiply(BigInteger.valueOf(26));
        }
        r = BigInteger.valueOf(1);
        for (int i = s2.length() - 1; i >= 0; i--) {
            int num = s2.charAt(i) - 'a';
            sum2 = sum2.add(BigInteger.valueOf(num).multiply(r));
            r = r.multiply(BigInteger.valueOf(26));
        }

        BigInteger sum = sum1.add(sum2);
        String str = "";
        while (!sum.equals(BigInteger.valueOf(0))) {
            int fz = sum.mod(BigInteger.valueOf(26)).intValue();
            str += (char) (fz + 'a');
            sum = sum.divide(BigInteger.valueOf(26));
        }

        for (int i = str.length() - 1; i >= 0; i--)
            System.out.print(str.charAt(i));
        System.out.println();

    }

}
