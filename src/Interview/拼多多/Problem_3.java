package Interview.拼多多;

import java.util.HashMap;
import java.util.Scanner;

public class Problem_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int a = sc.nextInt();

        int len = 0;//循环节长度
        //去除整数部分
        b %= a;
        //记录除法的次数
        int i = 0;
        //hashmap 记录小数部分每个数的位置
        HashMap<Integer, Integer> mymap = new HashMap<>();
        while (b != 0) {
            boolean flag = mymap.containsKey(b);
            if (!flag) {
                mymap.put(b, i++);
            } else {
                len = i - mymap.get(b);
                System.out.println(mymap.get(b) + " " + len);
                break;
            }
            b = b * 10;
            b %= a;
        }
        if (b == 0)
            System.out.println(i + " " + 0);
    }

}
