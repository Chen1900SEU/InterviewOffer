package 剑指offer;

import java.util.Arrays;

/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class 重构二叉树 {

    public static TreeNode reConstructByPreandIn(int[] pre, int[] in) {
        //数组为空
        if (pre.length == 0 || in.length == 0)
            return null;
        //遍历pre数组第一个元素为根节点。
        TreeNode root = new TreeNode(pre[0]);
        //根节点在中序遍历中的位置初始化为-1。
        int index = -1;
        for (int i = 0; i < in.length; ++i) {
            if (root.val == in[i]) {
                index = i;
                break;
            }
        }
        /*
        pre[] 被分成左右两部分leftPre:[1...index], rightPre:[index+1...pre.length-1]
        in[] 被分成左右两部分leftIn:[0...index-1], rightIn:[index+1...in.lenght-1]
        */
        int[] leftpre = Arrays.copyOfRange(pre, 1, index + 1);//复制的开始位置（包含），复制的结束位置（不包括）。！！
        int[] rightpre = Arrays.copyOfRange(pre, index + 1, pre.length);
        return root;
    }
}
