package 剑指offer;

import java.util.*;

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
    /**
     * 通过前序和中序构造树，非递归形式
     *
     * @param pre
     * @param in
     * @return
     */
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
        int[] leftin = Arrays.copyOfRange(in, 0, index);
        int[] rightin = Arrays.copyOfRange(in, index + 1, in.length);

        //分别对左右子树递归
        root.left = reConstructByPreandIn(leftpre, leftin);
        root.right = reConstructByPreandIn(rightpre, rightin);
        return root;
    }

    /**
     * 后序中序遍历构造树
     *
     * @param post
     * @param in
     * @return
     */
    public static TreeNode reConstructByPostandIn(int[] post, int[] in) {
        if (post.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(post[post.length - 1]);//初始化根节点
        int index = -1;
        for (int i = 0; i < in.length; i++) {//根节点在中序中的位置
            if (root.val == in[i]) {
                index = i;
                break;
            }
        }
        /*
         *post[]被分成左右两部分，leftPost：[0...index-1], rightPost:[index...post.lenght-2]
         *in[]被分成左右两部分 leftIn:[0...index-1], rightIn:[index+1...in.lenght-1]
         */
        int[] postleft = Arrays.copyOfRange(post, 0, index);
        int[] postright = Arrays.copyOfRange(post, index, post.length - 1);
        int[] inleft = Arrays.copyOfRange(in, 0, index);
        int[] inright = Arrays.copyOfRange(in, index + 1, in.length);

        root.left = reConstructByPostandIn(postleft, inleft);
        root.right = reConstructByPostandIn(postright, inright);
        return root;
    }

    /**
     https://blog.csdn.net/huhu0769/article/details/52077765
     https://blog.csdn.net/aa8568849/article/details/70243956
     https://blog.csdn.net/jssongwei/article/details/50790253
     **/

    /**
     * 前序遍历递归形式
     *
     * @param node
     */
    public static void PreOrderRecursion(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        PreOrderRecursion(node.left);
        PreOrderRecursion(node.right);
    }

    /**
     * * 前序遍历，非递归实现
     * 1，先入栈根节点，输出根节点val值，再先后入栈其右节点、左结点；
     * 2，出栈左节点，输出其val值，再入栈该左节点的右节点、左节点；直到遍历完该左节点所在子树。
     * 3，再出栈右节点，输出其val值，再入栈该右节点的右节点、左节点；直到遍历完该右节点所在子树。
     *
     * @param node
     * @return
     */
    public static List<Integer> PreOrderStack(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeStack = new Stack<>();

        TreeNode curNode = node;
        while (!treeStack.isEmpty() || curNode != null) {//将所有左孩子压栈
            if (curNode != null) {//压栈之前先访问
                result.add(curNode.val);
                treeStack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = treeStack.pop();
                curNode = curNode.right;
            }
        }
        return result;
//        if(node==null)
//            return result;
//
//        treeStack.push(node);
//
//        while (!treeStack.isEmpty()){
//            node= treeStack.peek();
//            treeStack.pop();
//            result.add(node.val);
//
//            if(node.left!=null) treeStack.push(node.right);//右节点先入栈
//            if(node.right!=null) treeStack.push(node.left);
//            }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public static void PostOrderRecursion(TreeNode node) {
        if (node == null)
            return;
        PostOrderRecursion(node.left);
        PostOrderRecursion(node.right);
        System.out.print(node.val + " ");
    }

    /**
     * https://blog.csdn.net/zhuqiuhui/article/details/51319165
     * 后序遍历递归定义：先左子树，后右子树，再根节点。
     * 后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树。
     * 若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点；
     * 若是位于右子树，则直接访问根节点。
     *
     * @param node
     * @return
     */
    public static List<Integer> PostOrderStack(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeStack = new Stack<>();
        if (node == null)
            return result;
        TreeNode curNode = node;//当前访问的结点
        TreeNode lastVisitNode = null;//上次访问的结点

        while (curNode != null) {        //把currentNode移到左子树的最下边
            treeStack.push(curNode);
            curNode = curNode.left;
        }
        while (!treeStack.isEmpty()) {
            curNode = treeStack.pop();
            //一个根节点被访问的前提是：无右子树或右子树上次已被访问过
            if (curNode.right != null && curNode.right != lastVisitNode) {
                //根节点入栈
                treeStack.push(curNode);
                //进入右子树
                curNode = curNode.right;
                while (curNode != null) {
                    treeStack.push(curNode);
                    //再走到右子树的最左边
                    curNode = curNode.left;
                }
            } else {
                result.add(curNode.val);
                lastVisitNode = curNode;
            }
        }
        return result;
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void InOrderRecursion(TreeNode node) {
        if (node == null)
            return;
        InOrderRecursion(node.left);
        System.out.print(node.val + " ");
        InOrderRecursion(node.right);
    }

    /**
     * 中序遍历非递归形式
     *
     * @param node
     * @return
     */
    public static List<Integer> InOrderStack(TreeNode node) {
        Stack<TreeNode> treeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode curNode = node;
        while (curNode != null || !treeStack.isEmpty()) {
            if (curNode != null) {
                treeStack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = treeStack.pop();//出栈并且访问
                result.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return result;
    }


    /**
     * 层次遍历非递归形式
     *
     * @param node
     * @return
     */
    public static List<Integer> LayerOrder(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if (node != null)
            queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            result.add(curNode.val);
            if (curNode.left != null)
                queue.offer(curNode.left);
            if (curNode.right != null)
                queue.add(curNode.right);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] pre = {6, 3, 1, 2, 5, 4, 9, 7, 8};
        int[] in = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] post = {2, 1, 4, 5, 3, 8, 7, 9, 6};

        //重构二叉树 solution = new 重构二叉树();
        TreeNode root = reConstructByPreandIn(pre, in);
        System.out.print("PreOrderRecursion: ");
        PreOrderRecursion(root);
        System.out.print("\n");
        System.out.print("PostOrderRecursion: ");
        PostOrderRecursion(root);
        System.out.print("\n");
        System.out.print("InOrderRecursion: ");
        InOrderRecursion(root);
        System.out.print("\n");

        TreeNode test = reConstructByPostandIn(post, in);
        List<Integer> res = PreOrderStack(test);
        System.out.print("PreOrderStack: ");
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.print("\n");

        res = PostOrderStack(test);
        System.out.print("PostOrderStack: ");
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.print("\n");

        res = InOrderStack(test);
        System.out.print("InOrderStack: ");
        for (int i : res) {
            System.out.print(i + " ");
        }

        System.out.print("\n");
        res = LayerOrder(test);
        System.out.print("LayerOrder: ");
        for (int i : res) {
            System.out.print(i + " ");
        }


    }

}
