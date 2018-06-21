package CompanyRecruitCode.网易;

import java.util.Scanner;
/*
java 各数值型大小表示的长度
http://blog.sina.com.cn/s/blog_5eab3d430101fdv6.html
 */

/**
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 * 并且小Q对于能否被3整除这个性质很感兴趣。
 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
 * 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
 * 输出一个整数, 表示区间内能被3整除的数字个数。
 */
/*
遇到对整数各个位数进行处理的情况，有时考虑转成String处理，那都不是太理想的方法，这里取余整除即可得到各个位数。
此题目的解法在于找规律
*/
public class Intern_被3整除 {
    public static int numSum(int n) {
        int res = 0;
        int x;
        while (n > 0) {
            x = n % 10;
            n = n / 10;
            res = res + x;
        }
        return res % 3;
    }

    public static int allSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (numSum(n) + allSum(n - 1)) % 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        int len = high - low + 1;
        int res = 0;
//        for(int i=low;i<=high;i++){
//            System.out.print(numSum(i));
//            System.out.print(" ");
//            if(allSum(i)%3==0){
//                res +=1;
//            }
//        }
//        System.out.println();
//        for(int i=low;i<=high;i++){
//            System.out.print(allSum(i));
//            System.out.print(" ");
//
//        }

        if (numSum(low) == 1) {
            len = len - 1;
            res = 0;
        } else if (numSum(low) == 0) {
            len = len - 2;
            res = 1;
        }

        res = res + 2 * (len / 3) + (len % 3);
        System.out.println(res);
//        return res;
    }
}
