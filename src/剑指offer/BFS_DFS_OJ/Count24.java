package 剑指offer.BFS_DFS_OJ;

import java.util.Scanner;

/**
 * 给出4个整数，要求用加减乘除4个运算使其运算结果变成24，4个数字要不重复的用到计算中。
 * 数字之间的除法中不得出现小数，例如原本我们可以1/4=0.25，但是这里的约束指定了这样操作是不合法的。
 */
/*解答
https://blog.csdn.net/jinzheng069/article/details/70195819
 */
public class Count24 {
    //枚举数字和运算符，DFS即可，注意题目要求计算过程中都不能出现小数，所以做除法时稍作处理
    public static boolean flag = false;
    public static int[] cards = new int[4];

    public static int getNum(String s) {
        if (s.equals("A"))
            return 1;
        else if (s.equals("J"))
            return 11;
        else if (s.equals("Q"))
            return 12;
        else if (s.equals("K"))
            return 13;
        else
            return Integer.parseInt(s);
    }
//
//    public static void dfs(int sum,int cur,int temp){
//        if(flag)
//            return;
//        if(cur==3)//最后一次符号加入的条件执行
//        {
//            if(sum+temp==24)
//                flag=true;
//            if(sum-temp==24)
//                flag=true;
//            if(sum*temp==24)
//                flag=true;
//            if(temp!=0&&sum%temp==0&&sum/temp==24)
//                flag=true;
//            return;
//        }
//
//        dfs(sum+temp, cur+1, cards[cur+1]);
//        dfs(sum-temp, cur+1, cards[cur+1]);
//        dfs(sum*temp, cur+1, cards[cur+1]);
//
//    }

    public static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    /**
     * 全排列 https://blog.csdn.net/jiao_yu/article/details/52493600
     *
     * @param array
     * @param start
     */
    public static void permutation(int[] array, int start) {
        //将整组数中的所有的数分别与第一个数交换，这样就总是在处理后n-1个数的全排列。
        if (start == cards.length - 1) {
            //cards=array;
            calculate24(array[0], 1, 1);
        } else {
            for (int i = start; i < cards.length; i++) {
                swap(array, start, i);//分别与第一个数交换
                permutation(array, start + 1);//后面的全排列
                swap(array, start, i);//换回来
            }
            //return null;
        }
    }

    public static void calculate24(int result, int count, int card) {
        if (flag)
            return;

        if (count == 3) {
            if (result + cards[card] == 24)
                flag = true;
            if (result - cards[card] == 24 || cards[card] - result == 24)
                flag = true;
            if (result * cards[card] == 24)
                flag = true;
            if (result % cards[card] == 0 && result / cards[card] == 0)
                flag = true;
            return;
        }

        calculate24(result + card, count + 1, cards[card + 1]);
        calculate24(result - card, count + 1, cards[card + 1]);
        calculate24(card - result, count + 1, cards[card + 1]);
        calculate24(result * card, count + 1, cards[card + 1]);
        if (result % card == 0 && card != 0)
            calculate24(result / card, count + 1, cards[card + 1]);
        if (card % result == 0 && result != 0)
            calculate24(card / result, count + 1, cards[card + 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] list = input.split(" ");
            for (int i = 0; i < 4; i++) {
                cards[i] = getNum(list[i]);
                System.out.print("Deal" + cards[i] + " ");
                // j++;
            }


            flag = false;

            // dfs(cards[0],1,cards[1]);
            //calculate24(cards[0],1,1);
            permutation(cards, 0);

            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
