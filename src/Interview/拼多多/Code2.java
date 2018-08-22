package Interview.拼多多;

import java.util.Scanner;

/**
 * 字符串构造
 * 长度为n的字符串P,构造出一个无限长度的字符串s，其中s[i]=p[i%n],求上述方法构造出s的最短字符串P
 */
public class Code2 {
/*    //先找s的最短循环节
    // 求解字符串中的最长重复子串
    public static String maxRepat(String input) {
        // 参数检查
        if (input == null || input.length() == 0) {
            return null;
        }
        // 重复子串的最长长度
        int max = 0;
        // 最长重复子串的起始位置
        int first = 0;
        int k = 0;
        for (int i = 1; i < input.length(); i++) {
            for (int j = 0; j < input.length() - i; j++) {
                if (input.charAt(j) == input.charAt(i + j)) {
                    k++;
                } else {
                    k = 0;
                }
                if (k > max) {
                    max = k;
                    first = j - k + 1;
                }
            }
        }
        if (max >= 0) {
            System.out.println(max);
            return input.substring(first, first + max);
        }
        return null;
    }*/

    public static boolean FindP(String input, String p) {
        int length = p.length();
        for (int i = 0; i < input.length(); i++) {//从头到尾判断
            int k = i % length;
            if (p.charAt(k) == input.charAt(i))
                continue;
            else
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuffer output = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            output.append(input.charAt(i));
            if (FindP(input, output.toString()))//决定是否需要将下一个数append到output
                break;
            else
                continue;
        }

/*        String str1 = "abcabcd";
        String result = maxRepat(str1);
        System.out.println(result);*/

        System.out.println(output);

    }
}
