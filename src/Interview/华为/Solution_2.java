package CompanyRecruitCode.华为;

import java.util.Scanner;

public class Solution_2 {
    static int[] month = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    static int[] day = new int[10];

    public static void main(String[] args) {

        int k = 6;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 0; i < a; i++) {
            month[2] = 28;//重新更改2月的天数
            if (((1900 + i) % 4 == 0 && (1900 + i) % 100 != 0) || (1900 + i) % 400 == 0) {
                month[2] = 29;
            }
            for (int j = 1; j <= 12; j++) {
                if (i == 0 && j == 1)
                    continue;
                k = (k + month[j - 1] % 7) % 7;   //计算本月的13为星期几
                if (k == 0)
                    k = 7;
                day[k]++;
            }
        }
        System.out.println(day[b + 1]);
//        for(int i=6;i<=7;i++)
//            printf("%d ",day[i]);
//        for(int i=1;i<=5;i++)
//            printf("%d ",day[i]);
    }
//    private static int Result(int year, int weeks){
//        int count = 0;
//        int days = 0;
//        try{
//            if(weeks <=6 && weeks>=0 && year>=0 && year<=400){
//                for(int i=1900; i<1900+year; i++){
//                    if(i==1900)
//                        days+=0;
//                    else{
//                        if(leapyear(i-1)){
//                            days+=366;
//                        }else {
//                            days+=355;
//                        }
//                    }
//                    //days += i==1900?0:(runnian(i-1)?366:365);
//                    int day = days;
//                    for(int j=1; j<=12; j++){
//                        days += getDay(i,j);
//                        if((days-(weeks-1))%7==0){
//                            count++;
//                        }
//                    }
//                    days = day;
//                }
//                if(weeks<0 || weeks>6 || year<0 || year>400)
//                    return -1;
//            }
//        }catch (Exception e){
//            return -1;
//        }
//        return count;
//    }
//    private static int getDay(int i, int j) {
//        if(!leapyear(i)){
//            return day[j-1];
//        }
//        return  j == 3? 29 : day[j-1];
//    }
//    private static boolean leapyear(int i) {
//        return (i%4 == 0 && i % 100 !=0)||i%400 == 0;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = Result(a, b);
//        if (c > 0)
//            System.out.println(c);
//        else
//            System.out.println(-1);
//    }

}


