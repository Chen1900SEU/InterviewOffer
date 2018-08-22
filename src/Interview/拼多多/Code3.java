package Interview.拼多多;

/**
 * 二维生物的旅行
 * 二维生物hip当前处于x轴的0坐标，打算去拜访她的老朋友hop(位于target位置)，Hip迈出的第N步，步长为n，从第一步算起。
 * 每一步走之前可以决定是向左走还是向右走，但是每次只能走一个方向，求hip到hop最少要走几步?
 * 输入是target 在坐标上的值，输出走的步数，无法到达就是输出-1
 */
public class Code3 {
    //int count = 0;
    public static int walk(int target, int last, int num) {

        if (target == num + last || target == last - num)
            return num;
        else {
            //num++;
            walk(target, last + num, num + 1);
            walk(target, last - num, num + 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int count = walk(6, 0, 0);
        System.out.print(count);
    }
}
