package Interview.招商银行;

import java.util.Scanner;

public class Code_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        // System.out.println("similarity Ratio=" + minDistance(str1, str2));
        if (str1.equals(str2))
            System.out.println(0);
        else if (minDistance(str1, str2) == 1)
            System.out.println(1);
        else
            System.out.println(0);

    }

    public static int minDistance(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化空字符串的情况
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 增加操作：str1a变成str2后再加上b，得到str2b
                int insertion = dp[i][j - 1] + 1;
                // 删除操作：str1a删除a后，再由str1变为str2b
                int deletion = dp[i - 1][j] + 1;
                // 替换操作：先由str1变为str2，然后str1a的a替换为b，得到str2b
                int replace = dp[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1);
                // 三者取最小
                dp[i][j] = Math.min(replace, Math.min(insertion, deletion));
            }
        }
        return dp[m][n];
    }
}
//    public static float getSimilarityRatio(String source, String target) {
//            return 1 - (float) compare(source, target) / Math.max(source.length(), target.length());
//        }
//
//        private static int compare(String source, String target) {
//
//            int matrix[][];
//            int n = source.length();
//            int m = target.length();
//            int i; //source索引
//            int j; //target索引
//            char ch1;
//            char ch2;
//            int temp; //记录相同字符,值为0/1
//
//            if (n == 0)
//                return m;
//
//            if (m == 0)
//                return n;
//
//            matrix = new int[n + 1][m + 1];
//            for (i = 0; i <= n; i++) { //初始化第一列
//                matrix[i][0] = i;
//            }
//
//            for (j = 0; j <= m; j++) { //初始化第一行
//                matrix[0][j] = j;
//            }
//
//            for (i = 1; i <= n; i++) { //遍历source
//                ch1 = source.charAt(i - 1);
//                //匹配target
//                for (j = 1; j <= m; j++) {
//                    ch2 = target.charAt(j - 1);
//                    if (ch1 == ch2) temp = 0;
//                    else temp = 1;
//                    //左+1,上+1,左上+temp 取最小
//                    matrix[i][j] = min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1, matrix[i - 1][j - 1] + temp);
//                }
//            }
//            return matrix[n][m];
//        }
//
//        private static int min(int one, int two, int three) {
//            return (one = one < two ? one : two) < three ? one : three;
//        }

//        public static void main(String[] args) {
//            String source = "中国";
//            String target = "中国人";
//            System.out.println("similarityRatio=" + Levenshtein.getSimilarityRatio(source, target));
//        }


