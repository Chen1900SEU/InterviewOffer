package CompanyRecruitCode.百度;

import java.util.Scanner;

public class 排队 {
    public static int onelit(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (onelit(n - 1)) * n;
        }
    }

    private static long factorial(long n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

    /**
     * 计算组合数，即C(n, m) = n!/((n-m)! * m!)
     *
     * @param n
     * @param m
     * @return
     */
    public static long combination(long n, long m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }

    /**
     * 计算排列数，即A(n, m) = n!/(n-m)!
     *
     * @param n
     * @param m
     * @return
     */
    public static long arrangement(long n, long m) {
        return (n >= m) ? factorial(n) / factorial(n - m) : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (n == 1) {
            System.out.println(onelit(5));
        }
        if (n != 1) {
            //C(2,5)*A(2,2)*A(3,3)*A(2n,2n)-A(n,n)
            long res = (combination(5, 2) * arrangement(2, 2) * arrangement(3, 3) * arrangement(2 * n, 2 * n) - arrangement(n, n)) % 1000000007;

            //long res=(arrangement(2*n,2*n)*10*2*3+arrangement(n,n)*120)%1000000007;
            System.out.println(res);
        }
    }
}
