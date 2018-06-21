package CompanyRecruitCode.华为;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/*
在GBK编码下，请编写一个截取字符串的函数， 输入为一个字符串和字节数，输出为按字节截取的字符串。
但是要保证汉字不被截半个，同时忽略字符串中的数字后输出最终结果。


输入描述:
一行字符串和待截取的字节数
输出描述:
单独的一行截取后的字符串
示例1
输入
华HUA
4
输出
华HU
备注:
要保证汉字不被截半个，同时忽略字符串中的数字后输出最终结果。
 */
public class Solution_1 {

    public static String splitString(String str, int length) throws UnsupportedEncodingException {
        //空输入
        if (str == null || str.length() < 1 || length < 1) {
            return "";
        }

        //用于统计这个字符串中有几个中文字符
        int wordCount = 0;
        //统一按照gbk编码来得到他的字节数组，因为不同的编码字节数组是不一样的。
        byte[] gbks = str.getBytes("GBK");

        //gbks中,汉字是两个负数表示
        for (int i = 0; i < length; i++) {
            int val = gbks[i];
            if (val < 0) {
                wordCount++;
            }

        }

        //完整的汉字
        if (wordCount % 2 == 0) {
            return str.substring(0, (length - (wordCount / 2)));
        }
        //半个汉字 所以  -1
        return str.substring(0, (length - (wordCount / 2) - 1));

    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = scan.nextInt();
        // System.out.println(str);
        String res = splitString(str, n);
        System.out.println(res);

    }
    /*
    import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scan =new Scanner(System.in);
        String str=scan.nextLine();
        int n=scan.nextInt();
        //去除所有的数字
        str=str.replaceAll("\\d+","");
        //空输入,空截取
        if (str == null || str.length() < 1 || n < 1) {
            System.out.println("");
        }
        //统计字符串中有几个中文字符
        int ChineseCount = 0;
        byte[]gbk=str.getBytes("GBK");

        for(int i=0;i<n;i++){
            int val = gbk[i];
            if(val<0){
                ChineseCount++;
            }
        }
        //不能截半个
        String res="";
        if (ChineseCount%2==0){
            res=str.substring(0,(n-(ChineseCount/2)));
            //System.out.println(str.substring(0,(n-(ChineseCount/2))));
        }else{
            res=str.substring(0,(n-(ChineseCount/2)-1));
            //System.out.println(str.substring(0,(n-(ChineseCount/2)-1)));
        }
        System.out.println(res.replaceAll("\\d+",""));
    }
}
     */
}
