package 剑指offer;
/*
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class 二维数组中查找 {

    public static boolean Find(int target, int[][] array) {
        int col = array[0].length - 1;//列最大下标
        int row = array.length - 1;//行最大下标
        for (int i = row, j = 0; i >= 0 && j <= col; ) {
            if (array[i][j] > target) {
                i--; //从最左下角选择一个数，if array[i][j]>target，第i行整个都不需要再次判断；
            } else if (array[i][j] < target) {
                j++;//if array[i][j]>target，第j列整个都不需要再次判断；
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 16;
        if (Find(target, array)) {
            System.out.println(target);
        } else {
            System.out.println("No answer!");
        }
    }


}
