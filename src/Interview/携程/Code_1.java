package Interview.携程;
//https://blog.csdn.net/autoliuweijie/article/details/52244246

import java.util.HashMap;
import java.util.Scanner;

public class Code_1 {
    //H(Y|X)=Sum(p(x)H(Y|X=x))
    //统计1且x个数
    //H(Y|x=x)
    public static void main(String[] args) {
        HashMap<Integer, Integer> y_1 = new HashMap();
        HashMap<Integer, Integer> y_0 = new HashMap();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] strArray = input.split(",");
            System.out.print(strArray[1]);
            if (strArray[1].equals(" 1")) {
                if (y_1.containsKey(strArray[0])) {
                    y_1.put(Integer.valueOf(strArray[0]), y_1.get(strArray[0]) + 1);
                } else {
                    y_1.put(Integer.valueOf(strArray[0]), 1);
                }
            } else {
                if (y_0.containsKey(strArray[0])) {
                    y_0.put(Integer.valueOf(strArray[0]), y_1.get(strArray[0]) + 1);
                } else {
                    y_0.put(Integer.valueOf(strArray[0]), 1);
                }
            }
        }
        System.out.print(y_1.keySet());
        System.out.print(y_0.keySet());
    }

    public static double calH(int x, int y) {
        return (-x / y) * Math.log((x / y));
    }

    public static double calp(int x, int y) {
        return x / y;
    }


}
