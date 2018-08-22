package Interview.网易;

import java.util.Scanner;

public class Code_2 {

    public static int[] find(int[] height) {
        int[] find = new int[4];
        find[0] = height[0];//定义最大值为该数组的第一个数
        find[1] = height[0];//定义最小值为该数组的第一个数
        find[2] = 0;//max下标
        find[3] = 0;//min 下表

        for (int i = 0; i < height.length; i++) {
            if (find[0] < height[i]) {
                find[0] = height[i];
                find[2] = i;
            }
            if (find[1] > height[i]) {
                find[1] = height[i];
                find[3] = i;
            }
        }
        return find;//0 max 1 min
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int m = sc.nextInt();

        int[] height = new int[s];
        int[][] step = new int[m][2];//m行

        int n = 0;
        int k = 0;

        for (int i = 0; i < s; i++) {
            height[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            if (find(height)[0] - find(height)[1] <= 1) {
                n = height[find(height)[2]] - height[find(height)[3]];
                break;
            } else {
                step[i][0] = find(height)[2];//max
                step[i][1] = find(height)[3];//min

                height[find(height)[2]]--;
                height[find(height)[3]]++;
                //System.out.println(step.length);
                n = height[find(height)[2]] - height[find(height)[3]];
            }
        }

        System.out.print(n);
        System.out.print(" ");
        System.out.println(step.length);
        for (int i = 0; i < step.length; i++) {
            int a = step[i][0] + 1;
            int b = step[i][1] + 1;
            System.out.println(a + " " + b);
        }
    }
}
