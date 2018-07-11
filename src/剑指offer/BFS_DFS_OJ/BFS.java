package 剑指offer.BFS_DFS_OJ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*广度遍历是遍历到某个顶点，然后訪问其连接点a,b。接着訪问a的连接表，
 非常自然的，这种数据结构就是HashMap，以顶点为key。保存每一个顶点的连接表
 */
public class BFS {

    static int count = 0;

    /**
     * @param graph HashMap<Character,LinkedList<Character>> graph 这个HashMap是用于存放图中每一个node的邻接表,
     *              表示此映射所维护的键的类型为Character。此映射值的类型为LinkedList<Character> graph
     *              表示将映射关系存放在graph此映射中,LinkedList<Character> 表示在此Collection中保持元素类型为Character
     * @param dist  是用于存放每一个node与距离顶点s的距离的映射关系
     *              表示此映射所维护的键的类型为Character 此映射所维护的值的类型为Integer。dist表示将映射关系存放到dist此映射中
     * @param start
     */
    private void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, char start) {
        Queue<Character> q = new LinkedList<Character>();
        q.add(start);//将指定元素s插入队列，成功时返回true，假设没有可用空间。则返回illegalStateException
        dist.put(start, 0);
        int i = 0;

        while (!q.isEmpty()) {
            char top = q.poll();// 获取并移除队列的头，返回队列的头，假设队列为空。返回null
            i++;
            System.out.println("The " + i + "th element:" + top + " Distance from s is:" + dist.get(top));
            int d = dist.get(top) + 1;// 得出其周边还未被訪问的节点的距离
            /*
             * graph.get(top)假设此映射包括一个满足 (key==null ? k==null : key.equals(k))
			 * 的从 k 键到 v 值的映射关系，则此方法返回 v；否则返回 null。（最多仅仅能有一个这种映射关系。
			 *  * for（元素变量：元素集合），假设元素集合中全部元素都已遍历过，则结束此循环。 否则运行for循环里的程序块
			 */
            for (Character c : graph.get(top)) {
                // containskey(key) 假设此映射包括对于指定键key的映射关系，则返回true
                if (!dist.containsKey(c))// 假设dist中还没有该元素说明还没有被访问
                {
                    //关联指定键c与指定值d。假设关联关系已存在。则替换旧值d。返回旧值d， 假设无映射关系，则返回null
                    dist.put(c, d);
                    q.add(c); // 将指定元素c插入队列，成功时返回true。假设没有可用空间，则返回illegalStateException
                }
            }
        }
    }

}
