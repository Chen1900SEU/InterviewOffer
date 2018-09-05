package Interview.拼多多;

import java.util.Scanner;

public class Problem_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[][] board = new String[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] = sc.next();
        for (int j = 0; j < m; j++) {
            //障碍物的位置
            int x = -1;
            //若有障碍物，木块的位置
            int o = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (board[i][j].equals("x")) {
                    x = i;
                    o = i - 1;
                } else if (x == -1)
                    board[i][j].equals(".");
                else if (board[i][j].equals('o')) {
                    board[i][j].equals('.');
                    board[o--][j].equals('o');

                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(board[i][j]);
            System.out.print("\n");
        }
    }
}
