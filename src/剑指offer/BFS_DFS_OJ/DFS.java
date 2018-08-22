package 剑指offer.BFS_DFS_OJ;

import java.util.Stack;

/*
用于遍历和搜索图的算法，沿着树的深度遍历树的节点尽可能深的搜索树的分支。当节点v的所在边都已经当节点v的所在边都己被探寻过，
搜索将回溯到发现节点v的那条边的起始节点。这一过程一直进行到已发现从源节点可达的所有节点为止。如果还存在未被发现的节点，
则选择其中一个作为源节点并重复以上过程，整个进程反复进行直到所有节点都被访问为止。属于盲目搜索。
DFS的思想是从一个顶点V0开始，沿着一条路一直走到底，如果发现不能到达目标解，那就返回到上一个节点，然后从另一条路开始走到底。
DFS适合此类题目：给定初始状态跟目标状态，要求判断从初始状态到目标状态是否有解。

广度优先搜索的缺点出来了：在树的层次较深&子节点数较多的情况下，消耗内存十分严重。
广度优先搜索适用于节点的子节点数量不多，并且树的层次不会太深的情况。
深度优先搜索的缺点：难以寻找最优解，仅仅只能寻找有解。其优点就是内存消耗小，克服了刚刚说的广度优先搜索的缺点。
 */
public class DFS {
    private char[] vertices;//存储节点信息
    private int[][] arcs; //存储边信息
    private int vexnum;//图节点数目
    private boolean[] visited; //判断节点是否被访问


    public DFS(int n) {//初始化
        vertices = new char[n];
        arcs = new int[n][n];
        vexnum = n;
        visited = new boolean[n];
        for (int i = 0; i < vexnum; i++) {
            for (int j = 0; j < vexnum; j++) {
                arcs[i][j] = 0;
            }
        }
    }

    public void setVertices(char[] vertices) {
        this.vertices = vertices;
    }

    // 设置节点访问标记
    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    // 打印遍历节点
    public void visit(int i) {
        System.out.print(vertices[i] + " ");
    }

    // 添加边(无向图)
    public void addEdge(int i, int j) {
        // 边的头尾不能为同一节点
        if (i == j) return;

        arcs[i][j] = 1;
        arcs[j][i] = 1;
    }

    private void traverse(int i) {// 从第i个节点开始深度优先遍历
        //标记第i个节点已经遍历
        visited[i] = true;
        //打印当前遍历的节点
        visit(i);

        //遍历邻接矩阵中i的直接联通关系
        for (int j = 0; j < vexnum; j++) {
            //目标节点与当前节点联通的话，且没有被访问，递归
            if (visited[j] = false && arcs[i][j] == 1) {
                traverse(j);
            }
        }
    }

    public void DFSTraverseRecursive() {
        //初始化节点遍历标记
        for (int i = 0; i < vexnum; i++) {
            visited[i] = false;
        }

        // 从没有被遍历的节点开始深度遍历
        for (int i = 0; i < vexnum; i++) {
            if (visited[i] == false) {
                // 若是连通图，只会执行一次
                traverse(i);
            }
        }
    }

    public void DFSTraverse() {
        for (int i = 0; i < vexnum; i++) {
            visited[i] = false;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < vexnum; i++) {
            if (!visited[i]) {
                stack.add(i);//连通子图起始节点
                do {
                    //出栈
                    int curr = stack.pop();
                    //如果此节点没有被遍历，则遍历该节点并且将子节点入栈
                    if (visited[curr] == false) {
                        visit(curr);
                        visited[curr] = true;

                        // 没遍历的子节点入栈
                        for (int j = vexnum - 1; j >= 0; j--) {
                            if (arcs[curr][j] == 1 && visited[j] == false) {
                                stack.add(j);
                            }
                        }
                    }
                } while (!stack.isEmpty());
            }
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS(9);
        char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        g.setVertices(vertices);
        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(1, 8);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 8);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(3, 8);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 7);
        g.addEdge(5, 0);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 1);
        g.addEdge(6, 3);
        g.addEdge(6, 5);
        g.addEdge(6, 7);
        g.addEdge(7, 3);
        g.addEdge(7, 4);
        g.addEdge(7, 6);
        g.addEdge(8, 1);
        g.addEdge(8, 2);
        g.addEdge(8, 3);

        System.out.print("深度优先遍历（非递归）：");
        g.DFSTraverse();

        System.out.println();

        System.out.print("深度优先遍历（递归）：");
        g.DFSTraverseRecursive();


    }

}
