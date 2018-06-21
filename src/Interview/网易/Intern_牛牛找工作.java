package CompanyRecruitCode.网易;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。
 * 在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 * Input:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 * <p>
 * Output:
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 */
/*
https://blog.csdn.net/eff666/article/details/63692840
https://blog.csdn.net/exceptional_derek/article/details/9852929

*/
public class Intern_牛牛找工作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (N < 1 || M < 1) {
            return;
        }
        int[][] jobs = new int[N][2];
        int[][] friend = new int[M][2];
        for (int i = 0; i < N; i++) {
            jobs[i][1] = sc.nextInt();//难度
            jobs[i][0] = sc.nextInt();//报酬
        }
        Arrays.sort(jobs, (o1, o2) -> {
            //由小到大排序（前者减去后者）;由大到小排序（后者减去前者）
            return o2[0] - o1[0];//按照报酬
        });
        for (int i = 0; i < M; i++) {
            friend[i][0] = sc.nextInt();//朋友的能力
            friend[i][1] = i;//朋友编号
        }
        Arrays.sort(friend, (o1, o2) -> o2[0] - o1[0]);//!!!非常好用降序排序
//        Arrays.sort(friend, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[0]-o1[0];//朋友能力从高到低
//            }
//        });
        int jobIdx = 0, peopleIdx = 0;
        int[] result = new int[N];
        while (jobIdx < N && peopleIdx < M) {
            //找报酬高的的工作，如果一个工作连能力最高的人都没能拿到，那么即使报酬高也只能所有人都拿不到了。
            if (jobs[jobIdx][1] <= friend[peopleIdx][0]) {
                result[friend[peopleIdx][1]] = jobs[jobIdx][0];
                //friend[peopleIdx][1] 记录friend的id，
                peopleIdx++;
            } else {
                jobIdx++;
            }
        }
        for (int i = 0; i < M; i++)
            System.out.println(result[i]);
    }
}
