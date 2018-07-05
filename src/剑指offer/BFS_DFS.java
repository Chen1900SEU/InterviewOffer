package 剑指offer;

import java.util.*;

/*
https://blog.csdn.net/my_jobs/article/details/43451187
https://www.cnblogs.com/developerY/p/3323264.html
 */

public class BFS_DFS {
    /**
     * Breadth First Search
     * 广度优先遍历树，需要用到队列（Queue）来存储节点对象,队列的特点就是先进先出。先往队列中插入左节点，再插右节点，这样出队就是先左节点后右节点了。
     *
     * @param node
     * @return
     */
    public static ArrayList<Integer> BFS_BinaryTree(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left != null)
                queue.offer(tree.left);
            if (tree.right != null)
                queue.offer(tree.right);
            result.add(tree.val);
        }
        return result;
    }

    /**
     * Depth First Search (类似前中后序遍历)
     * 其过程简要来说是对每一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次。
     * 深度优先遍历各个节点，需要使用到栈（Stack）这种数据结构。stack的特点是是先进后出。
     * 先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> DFS_BinaryTree(TreeNode root) {
        ArrayList<Integer> lists = new ArrayList<Integer>();
        if (root == null)
            return lists;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            //先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
            if (tree.right != null)
                stack.push(tree.right);
            if (tree.left != null)
                stack.push(tree.left);
            lists.add(tree.val);
        }
        return lists;
    }

    /**
     * 图最常用的两种表示方法是邻接表和邻接矩阵。
     * 本文将着重介绍遍历图的两种最常用的方法，分别为广度优先遍历和深度优先遍历，后面会具体介绍为什么这么命名。
     * 首先来看广度优先遍历BFS（Breadth First Search），其主要思想是从起始点开始，将其邻近的所有顶点都加到一个队列（FIFO）中去，
     * 然后标记下这些顶点离起始顶点的距离为1.最后将起始顶点标记为已访问，今后就不会再访问。然后再从队列中取出最先进队的顶点A，
     * 也取出其周边邻近节点，加入队列末尾，将这些顶点的距离相对A再加1，最后离开这个顶点A。依次下去，直到队列为空为止。从上面描述的
     * 过程我们知道每个顶点被访问的次数最多一次（已访问的节点不会再访问），而对于连通图来说，每个顶点都会被访问。加上每个顶点的
     * 邻接链表都会被遍历，因此BFS的时间复杂度是Θ（V+E），其中V是顶点个数，E是边数，也就是所有邻接表中的元素个数。为了更好的说明
     * 这个过程，下图列出了对一个图的BFS的过程
     */
    public static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, char start) {//Character 类用于对单个字符进行操作。

        Queue<Character> q = new LinkedList<>();
        q.add(start);//将s作为起始顶点加入队列
        dist.put(start, 0);
        int i = 0;
        while (!q.isEmpty()) {
            char top = q.poll();//取出队首元素
            i++;
            System.out.println("The " + i + "th element:" + top + " Distance from s is:" + dist.get(top));
            int d = dist.get(top) + 1;//得出其周边还未被访问的节点的距离
            for (Character c : graph.get(top)) {
                if (!dist.containsKey(c))//如果dist中还没有该元素说明还没有被访问
                {
                    dist.put(c, d);
                    q.add(c);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFS_DFS bb = new BFS_DFS();
        // s顶点的邻接表
        LinkedList<Character> list_s = new LinkedList<Character>();
        list_s.add('w');
        list_s.add('r');
        LinkedList<Character> list_w = new LinkedList<Character>();
        list_w.add('s');
        list_w.add('i');
        list_w.add('x');
        LinkedList<Character> list_r = new LinkedList<Character>();
        list_r.add('s');
        list_r.add('v');
        LinkedList<Character> list_x = new LinkedList<Character>();
        list_x.add('w');
        list_x.add('i');
        list_x.add('u');
        list_x.add('y');
        LinkedList<Character> list_v = new LinkedList<Character>();
        list_v.add('r');
        LinkedList<Character> list_i = new LinkedList<Character>();
        list_i.add('u');
        list_i.add('x');
        list_i.add('w');
        LinkedList<Character> list_u = new LinkedList<Character>();
        list_u.add('i');
        list_u.add('x');
        list_u.add('y');
        LinkedList<Character> list_y = new LinkedList<>();
        list_y.add('u');
        list_y.add('x');
        HashMap<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();
        graph.put('s', list_s);
        graph.put('w', list_w);
        graph.put('r', list_r);
        graph.put('x', list_x);
        graph.put('v', list_v);
        graph.put('i', list_i);
        graph.put('y', list_y);
        graph.put('u', list_u);
        HashMap<Character, Integer> dist = new HashMap<Character, Integer>();
        char start = 's';
        bb.bfs(graph, dist, start);
        // bb.dfs(graph, dist, start);

    }

}
