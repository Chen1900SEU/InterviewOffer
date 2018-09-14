package Interview.招商银行;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        int[] count = new int[N];
        // int res = 0;
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i; j <= 2 * N; ) {
                if (num[j % N] % 2 == 0) {
                    System.out.println("j1--" + j % N);
                    j += 3;
                    count[i] += num[j % N];
                } else {
                    System.out.println("j2--" + j % N);
                    j += 2;
                    count[i] += num[j % N];
                }
            }
        }
        Arrays.sort(count);
        System.out.println(count[0]);
        System.out.println(count[N - 1]);
    }
}
