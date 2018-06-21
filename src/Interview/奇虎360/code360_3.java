package CompanyRecruitCode.奇虎360;

import java.util.Scanner;

public class code360_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        if (K < N) {
            long js = 0;
            for (int i = 0; i < K; ++i) {
                long jst = 1;
                // 只含有i个的 C(K, i) * i ^ n
                for (int j = K; j >= K - i + 1; --j) {
                    jst *= j;
                }
                for (int j = 1; j <= i; ++j) {
                    jst /= j;
                }
                jst *= Math.pow(i, N);
                js += jst;
            }
            long res = ((long) Math.pow(K, N) - js) % 772235;
            System.out.println(res);
        } else if (K > N) {
            long res = 1;
            for (int i = K; i >= K - N + 1; --i) {
                res *= i;
            }
            System.out.println(res % 772235);
        } else { // K == N
            long res = 1;
            for (int i = K; i >= 1; --i) {
                res *= i;
            }
            System.out.println(res % 772235);
        }
    }

}
