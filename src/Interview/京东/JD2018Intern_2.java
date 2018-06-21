package CompanyRecruitCode.京东;

import java.util.Scanner;

public class JD2018Intern_2 {//问题相当于原来序列有多少的子回文

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char[] str = (cin.next()).toCharArray();
        System.out.println(str[0] + " " + str[1]);
        int[][] dp = new int[100][100];
        int len = str.length - 1;//数组的下标!!!
        for (int i = 0; i <= len; i++)
            dp[i][i] = 1;
        for (int i = 0; i <= (len - 1); i++)
            if (str[i] == str[i + 1])
                dp[i][i + 1] = 1;
        for (int l = 3; l <= len + 1; l++) {//此处上界是什么注意
            for (int i = 0; i <= len - l + 1; i++) {
                int j = i + l - 1;
                System.out.println(str[i] + " " + str[j]);
                if (str[i] != str[j])
                    continue;
                dp[i][j] = 1;
                for (int p = i + 1; p <= j - 1; p++) {
                    for (int q = p; q <= j - 1; q++) {
                        if (str[p] == str[q])
                            dp[i][j] += dp[p][q];
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                System.out.print(dp[i][j] + " ");
                ans += dp[i][j];
            }
            System.out.print("\n");
        }
        System.out.println(ans);
    }
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        char[] str = ("1"+cin.next()).toCharArray();
//        System.out.println(str[0]+" "+str[1]);
//        int [][] dp=new  int[100][100];
//        int len = str.length-1;
//        for (int i = 1; i <= len; i++)
//            dp[i][i] = 1;
//        for (int i = 1; i <= (len - 1); i++)
//            if (str[i] == str[i + 1])
//                dp[i][i + 1] = 1;
//        for (int l = 3; l <= len; l++) {
//            for (int i = 1; i <= len - l + 1; i++) {
//                int j = i + l - 1;
//                if (str[i] != str[j])
//                    continue;
//                dp[i][j] = 1;
//                for (int p = i + 1; p <= j - 1; p++) {
//                    for (int q = p; q <= j - 1; q++) {
//                        if (str[p] == str[q])
//                            dp[i][j] += dp[p][q];
//                    }
//                }
//            }
//        }
//
//        long ans = 0;
//        for(int i=1;i<=len;i++){
//            for(int j =1;j<=len;j++){
//                ans +=dp[i][j];
//            }
//        }
//        System.out.println(ans);
//    }
}
