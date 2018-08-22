package Interview.网易;

import java.util.Scanner;

public class Code_3 {
    /*
    解法：按区间的结束时间从小到大排序后，从小的区间按顺序选取；

    （１）如果当前区间与已经覆盖的位置重叠（与当前最右位置进行比较），则舍弃；

    （２）否则将此区间摆放在数轴上并更新当前已经覆盖的最右位置
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] time = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                if (sc.hasNext())
                    time[i][j] = sc.nextInt();
            }
        }
        //BubbleSort
        for (int k = 1; k < N; k++) {
            for (int i = 0; i < N - k; i++) {
                if (time[k][1] - time[k][0] < 0) {
                    time[k][1] = time[k][1] + M;
                }

                if (time[i][1] > time[i + 1][1]) {
                    //swap
                    int tmp = time[i + 1][1];
                    time[i + 1][1] = time[i][1];
                    time[i][1] = tmp;
                    tmp = time[i + 1][0];
                    time[i + 1][0] = time[i][0];
                    time[i][0] = tmp;
                }
            }
        }
        int cur = time[0][1];
        int cnt = 1;
        for (int k = 1; k < N; k++) {
            if (time[k][0] >= cur) {
                cur = time[k][1];
                cnt++;
            }
        }

        System.out.print(cnt);

    }
}
