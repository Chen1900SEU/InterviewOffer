package CompanyRecruitCode.网易;


import java.util.Scanner;

/**
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
 * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
 * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
 * 输入包括五行。
 * 第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
 * 第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
 * 第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
 * 第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
 * 第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
 */
/*
确定两个矩形是否相交（即有重叠区域）那就是判断两个矩形的中心坐标的水平和垂直距离
只要这两个值满足某种条件就可以相交。
 */
public class Intern_矩形重叠 {

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] coverleft = new int[1][2];
        int[][] coverright = new int[1][2];
        int[][] left = new int[n][2];
        int[][] right = new int[n][2];//(x,y)
//        int xcleft=0;
//        int ycleft=0;
//        int xcright=0;
//        int ycright=0;
        int res = 1;
//        int[] x1 =new int[n];
//        int[] x2 =new int[n];
//        int[] y1 =new int[n];
//        int[] y2 =new int[n];
        for (int i = 0; i < n; i++) {//i个矩形
            left[i][0] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            left[i][1] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            right[i][0] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            right[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int temp = 1;
//            coverleft[0][0]=max(left[0][0],left[0][0]);
//            coverleft[0][1]=max(left[0][1],left[0][1]);
//            coverright[0][0]=min(right[0][0],right[0][0]);
//            coverright[0][1]=min(right[0][1],right[0][1]);\
            coverleft[0][0] = left[i][0];
            coverleft[0][1] = left[i][1];
            coverright[0][0] = right[i][0];
            coverright[0][1] = right[i][1];


            for (int j = i + 1; j < n; j++) {

                if (max(coverleft[0][0], left[j][0]) < min(coverright[0][0], right[j][0]) && max(coverleft[0][1], left[j][1]) < min(coverright[0][1], right[j][1])) {
                    //左下m(x)<右上min(x),0表示x坐标，i，j表示不同的矩阵
                    //左下m(y)<右上min(y),1表示y坐标，i，j表示不同的矩阵
                    coverleft[0][0] = max(coverleft[0][0], left[j][0]);
                    coverleft[0][1] = max(coverleft[0][1], left[j][1]);
                    coverright[0][0] = min(coverright[0][0], right[j][0]);
                    coverright[0][1] = min(coverright[0][1], right[j][1]);
                    j++;
                    temp += 1;
                }
//                else{
//                    j++;
//                    coverleft[0][0] =  left[j][0];
//                    coverleft[0][1] = left[j][1];
//                    coverright[0][0] = right[j][0];
//                    coverright[0][1] = right[j][1];
//                }

            }
            if (temp >= res)
                res = temp;
        }

        System.out.println(res);
    }

}
