package Interview.拼多多;
//https://www.nowcoder.com/discuss/101060?tdsourcetag=s_pctim_aiomsg

import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        int normalattcak = sc.nextInt();
        int buffedattack = sc.nextInt();
        int res = 0;
        //聚力0 普通攻击 1 超级攻击 2
        if (hp <= normalattcak) {
            res = 1;
        } else if (buffedattack < 2 * normalattcak) {
            for (int i = 0; i < hp; ) {
                i = i + normalattcak;
                res += 1;
            }
        } else {
            for (int i = 0; i < hp; ) {
                i = i + buffedattack;
                res += 2;
            }
        }
        System.out.println(res);
    }
}

/*
import java.io.BufferedInputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int hp = sc.nextInt();
        int normalattcak = sc.nextInt();
        int buffedattack = sc.nextInt();
        if (buffedattack - normalattcak <= normalattcak) {
            int count = (int) Math.ceil((double)hp / (double)normalattcak);
            System.out.println(count);
        } else {
            int count = (int) Math.floor((double)hp / (double)buffedattack);
            if (hp - count * buffedattack <= normalattcak) {
                count *= 2;
                count++;
            } else {
                count++;
                count *= 2;
            }
            System.out.println(count);
        }
    }
}

 */