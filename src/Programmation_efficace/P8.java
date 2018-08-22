package Programmation_efficace;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Input:第一行包含一个唯一的整数，接下来3n行包含n个被空格分隔的整数，分别代表ABC矩阵。
 * Problem: 判断矩阵A*B是否等于C
 */
public class P8 {
    /*
    Solution: 随机选取一个向量x，测试A(Bx)=Cx。
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//读入行数列数
        int a[][] = new int[n][n];
        int b[][] = new int[n][n];
        int c[][] = new int[n][n];


        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (k == 0)
                        a[i][j] = in.nextInt();
                    else if (k == 1)
                        b[i][j] = in.nextInt();
                    else
                        c[i][j] = in.nextInt();
                }
            }
        }


        System.out.print(freivalds(a, b, c));

    }

    public static int[] mult(int[][] M, int[] n) {
        int[] res = new int[M.length];
        for (int i = 0; i < M.length; i++) {//矩阵行数
            for (int j = 0; j < n.length; j++) {
                res[i] = res[i] + M[i][j] * n[j];
            }
        }
        return res;
    }

    public static boolean freivalds(int[][] a, int[][] b, int[][] c) {

        int len = a.length;
        int[] x = new int[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            x[i] = rand.nextInt(100) + 1;
        }

        return Arrays.equals(mult(a, mult(b, x)), mult(c, x));//使用数组的equals()方法来检查两个数组是否相等
    }


}
