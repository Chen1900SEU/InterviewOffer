package 剑指offer;

import java.util.*;

/*
https://blog.csdn.net/my_jobs/article/details/43451187
https://www.cnblogs.com/developerY/p/3323264.html
 */
class Vertex {
    String verName;
    String color;
    int discoverTime;
    int finishTime;
    Vertex nextnode;
}

class Graph {
    Vertex[] vertexArray = new Vertex[100];
    int verNum = 0;
    int edgeNum = 0;
}

public class BFS_DFS {
    int time = 0;
    Stack<Vertex> stackVertex = new Stack<>();

    /**
     * 依据用户的输入的string 类型的顶点返回该顶点。
     *
     * @param graph
     * @param str
     * @return 返回一个顶点
     */
    public Vertex getVertex(Graph graph, String str) {
        for (int i = 0; i < graph.verNum; i++) {
            if (graph.vertexArray[i].verName.equals(str)) {
                return graph.vertexArray[i];
            }
        }
        return null;
    }

    /**
     * 依据用户的输入数据初始化一个图，以邻接表的形式构建。
     *
     * @param graph
     */
    public void initialGraph(Graph graph) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入顶点数和边数：");
        graph.verNum = scan.nextInt();
        graph.edgeNum = scan.nextInt();

        System.out.println("请依次输入定点名称：");
        for (int i = 0; i < graph.verNum; i++) {
            Vertex vertex = new Vertex();
            String name = scan.next();
            vertex.verName = name;
            vertex.color = "white";
            vertex.discoverTime = 0;
            vertex.finishTime = 0;
            vertex.nextnode = null;
            graph.vertexArray[i] = vertex;
        }
        System.out.println("请依次输入图的便边：");
        for (int i = 0; i < graph.edgeNum; i++) {
            String preV = scan.next();
            String folV = scan.next();

            Vertex v1 = getVertex(graph, preV);
            if (v1 == null)
                System.out.println("输入边存在图中没有的顶点！");
            Vertex v2 = new Vertex();
            v2.verName = folV;
            v2.nextnode = v1.nextnode;
            v1.nextnode = v2;

//          紧接着下面注释的代码加上便是构建无向图的，不加则是构建有向图的！
//          Vertex1 reV2=getVertex(graph,folV);
//          if(reV2==null)
//              System.out.println("输入边存在图中没有的顶点！");
//          Vertex1 reV1=new Vertex1();
//          reV1.verName=preV;
//          reV1.nextNode=reV2.nextNode;
//          reV2.nextNode=reV1;
        }
    }

    /**
     * 输入图的邻接表
     *
     * @param graph 待输出的图
     */
    public void outputGraph(Graph graph) {
        System.out.println("输出图的邻接链表为：");
        for (int i = 0; i < graph.verNum; i++) {
            Vertex vertex = graph.vertexArray[i];
            System.out.print(vertex.verName);

            Vertex current = vertex.nextnode;
            while (current != null) {
                System.out.print("-->" + current.verName);
                current = current.nextnode;
            }
            System.out.println();
        }
    }

    /**
     * DFS遍历辅助函数，标记颜色是辅助，即根据顶点返回其下标
     *
     * @param vertex 顶点
     * @param graph  图
     * @return返回下标
     */
    public int index(Vertex vertex, Graph graph) {
        for (int i = 0; i < graph.verNum; i++) {
            if (vertex.verName.equals(graph.vertexArray[i].verName))
                return i;
        }
        return -1;
    }

    /**
     * DFS深度优先遍历初始化
     *
     * @param graph 图
     */
    public void DFS(Graph graph) {
        for (int i = 0; i < graph.verNum; i++) {
            if (graph.vertexArray[i].color.equals("white")) {
                DfsVisit(graph.vertexArray[i], graph);
                System.out.println();
            }
        }
    }

    /**
     * DFS递归函数
     *
     * @param vertex 顶点
     * @param graph  图
     */
    public void DfsVisit(Vertex vertex, Graph graph) {
        vertex.color = "gray";
        time = time + 1;
        vertex.discoverTime = time;
        System.out.print(vertex.verName + "-->");

        Vertex current = vertex.nextnode;
        while (current != null) {
            Vertex currentNow = getVertex(graph, current.verName);
            if (currentNow.color.equals("white"))
                DfsVisit(currentNow, graph);
            current = current.nextnode;
        }
        vertex.color = "black";
        time = time + 1;
        vertex.finishTime = time;
    }

    /**
     * 寻找一个节点的邻接点中是否还有白色节点
     *
     * @param vertex 顶点
     * @param graph  图
     * @return 返回白色节点或是null
     */
    public Vertex getAdj(Graph graph, Vertex vertex) {
        Vertex ver = getVertex(graph, vertex.verName);
        Vertex current = ver.nextnode;
        if (current == null)
            return null;
        else {
            Vertex cur = getVertex(graph, current.verName);
            while (current != null && cur.color.equals("gray")) {
                current = current.nextnode;
            }
            if (cur.color.equals("white")) {
                Vertex currentNow = getVertex(graph, current.verName);
                return currentNow;
            } else {
                return null;
            }
        }

    }

    /**
     * 通过栈实现dfs遍历
     *
     * @param graph  图
     * @param vertex 顶点
     */
    public void stackOperator(Graph graph, Vertex vertex) {
        vertex.color = "gray";
        stackVertex.push(vertex);
        System.out.print(vertex.verName + "-->");

        while (!stackVertex.isEmpty()) {
            Vertex ver = stackVertex.peek();
            Vertex current = getAdj(graph, ver);
            if (current != null) {
                stackVertex.push(current);
                current.color = "gray";
                System.out.print(current.verName + "-->");
            } else {
                stackVertex.pop();
            }
        }
    }

    /**
     * DFS遍历主函数
     *
     * @param graph
     */
    public void stackMain(Graph graph) {
        for (int i = 0; i < graph.verNum; i++) {
            if (graph.vertexArray[i].color.equals("white")) {
                stackOperator(graph, graph.vertexArray[i]);
                System.out.println();
            }
        }
    }

    /**
     * BFS广度优先搜索实现
     *
     * @param graph 图
     */
    public void BFS(Graph graph) {
        Vertex current = graph.vertexArray[0];
        current.color = "gray";
        time = time + 1;
        current.discoverTime = time;

        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.offer(current);
        while (queue.peek() != null) {
            Vertex ver = queue.poll();
            time = time + 1;
            ver.finishTime = time;
            System.out.print(ver.verName + "-->");

            Vertex cur = ver.nextnode;
            while (cur != null) {
                Vertex curNow = getVertex(graph, cur.verName);
                if (curNow.color.equals("white")) {
                    curNow.color = "gray";
                    time = time + 1;
                    curNow.discoverTime = time;
                    queue.offer(curNow);
                }
                cur = cur.nextnode;
            }
        }
        System.out.println("null");
    }

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
    /*
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
*/
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
        //bb.bfs(graph, dist, start);
        // bb.dfs(graph, dist, start);

    }

}
