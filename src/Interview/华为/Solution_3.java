package CompanyRecruitCode.华为;

import java.util.*;

public class Solution_3 {
    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        long[][] dp = new long[n + 1][6 * n + 1];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                long x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0;
                if (j - 1 > 0) {
                    x1 = dp[i - 1][j - 1];
                }
                if (j - 2 > 0) {
                    x2 = dp[i - 1][j - 2];
                }
                if (j - 3 > 0) {
                    x3 = dp[i - 1][j - 3];
                }
                if (j - 4 > 0) {
                    x4 = dp[i - 1][j - 4];
                }
                if (j - 5 > 0) {
                    x5 = dp[i - 1][j - 5];
                }
                if (j - 6 > 0) {
                    x6 = dp[i - 1][j - 6];
                }
                dp[i][j] = x1 + x2 + x3 + x4 + x5 + x6;
            }
        }
        double[][] a = new double[2][6 * n];
        List<Map.Entry<Integer, Double>> result = new ArrayList<Map.Entry<Integer, Double>>();
        for (int i = n; i <= 6 * n; i++) {
            //  a[0][i]=i;
            //  a[1][i]=dp[n][i]/Math.pow(6, n);
            AbstractMap.SimpleEntry<Integer, Double> entry = new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i] / Math.pow(6, n));
            result.add(entry);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        List<Map.Entry<Integer, Double>> res = dicesSum(n);
        System.out.print("[");
        for (int i = 0; i <= 5 * n; i++) {
            System.out.print("[" + res.get(i).getKey() + "," + res.get(i).getValue() + "]");
            if (i != 5 * n)
                System.out.print(",");

        }
        // System.out.print(res.get(0).getKey());
        System.out.print("]");


    }
}
