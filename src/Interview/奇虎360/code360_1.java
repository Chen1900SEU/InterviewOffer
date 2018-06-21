package CompanyRecruitCode.奇虎360;

import java.util.Arrays;
import java.util.Scanner;

public class code360_1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String a=sc.next();
//        System.out.println(a);
//        int N = sc.nextInt();
//        int K = sc.nextInt();
//        int sum = (int) (Math.pow(K,N)-K);
//        sum = sum%772235;
//        System.out.println(sum);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        int[] sum = new int[n];
        Arrays.fill(sum, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                x = sc.nextInt();
                sum[i] += x;
            }
            if (sum[i] == 0) {
                sum[i] = -1;
            } else if (sum[i] % 5 == 0) {
                sum[i] = sum[i] / 5;
            } else {
                sum[i] = -1;
//                int temp = sum[i]/5;
//                sum[i] = 5*(temp+1)-sum[i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(sum[i]);
        }
    }


    //public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
////        Array ans = new a
//        int ans = 0, x;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                x = sc.nextInt();
//            }
//        }
//        System.out.println(ans);
//    }

}
