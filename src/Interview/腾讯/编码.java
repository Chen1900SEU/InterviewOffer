package CompanyRecruitCode.腾讯;
/*
假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下：
a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。
编写一个函数，输入是任意一个编码，输出这个编码对应的Index.
 */

import java.util.Scanner;

import static java.lang.Math.pow;

public class 编码 {
    public static int SumStrAscii(String str) {
        byte[] bytestr = str.getBytes();
        int sum = 0;
        for (int i = 0; i < bytestr.length; i++) {
            sum = sum * 10 + (bytestr[i] - 97);
            System.out.println(bytestr[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char[] s = cin.next().toCharArray();
        int len = s.length;
        int result = 0;
        if (len == 4) {
            result += (s[0] - 'a') * (pow(25, 3) + pow(25, 2) + pow(25, 1) + 1);
            result += (s[1] - 'a') * (pow(25, 2) + pow(25, 1) + 1) + 1;
            result += (s[2] - 'a') * (pow(25, 1) + 1) + 1;
            result += (s[3] - 'a') + 1;
        } else if (len == 3) {
            result += (s[0] - 'a') * (pow(25, 3) + pow(25, 2) + pow(25, 1) + 1);
            result += (s[1] - 'a') * (pow(25, 2) + pow(25, 1) + 1) + 1;
            result += (s[2] - 'a') * (pow(25, 1) + 1) + 1;
        } else if (len == 2) {
            result += (s[0] - 'a') * (pow(25, 3) + pow(25, 2) + pow(25, 1) + 1);
            result += (s[1] - 'a') * (pow(25, 2) + pow(25, 1) + 1) + 1;
        } else {
            result += (s[0] - 'a') * (pow(25, 3) + pow(25, 2) + pow(25, 1) + 1);
        }
        System.out.println(result);
    }

//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        char[] s = cin.next().toCharArray();
//        int n = s.length;
//        //用curSum来保存已有计算结果
//        //sum计算4种情况之和
//        int sum = 0, curSum = 0;
//        for (int i = 0; i < 4; ++i) {
//            curSum *= 25;
//            if (i < n) {
//                curSum += s[i] - 'a';
//            }
//            sum += curSum;
//            if (i < n - 1) {
//                sum += 1;
//            }
//        }
//        System.out.println(sum);
//        cin.close();
//    }

}
