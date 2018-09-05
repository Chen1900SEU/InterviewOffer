package Interview.携程;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Code_2 {
    public static double klDistance(int[] p, int[] q) {
        HashMap<Integer, Integer> pp = new HashMap<>();
        HashMap<Integer, Integer> qq = new HashMap<>();
        int cp = 0;
        int cq = 0;
        for (int i = 0; i < p.length; ++i) {
            cp++;
            if (pp.containsKey(p[i])) {
                pp.put(p[i], pp.get(p[i]) + 1);
            } else {
                pp.put(p[i], 1);
            }
        }
        for (int i = 0; i < q.length; ++i) {
            cq++;
            if (qq.containsKey(q[i])) {
                qq.put(q[i], qq.get(q[i]) + 1);
            } else {
                qq.put(q[i], 1);
            }
        }
        double result = 0.0;
        for (Integer k : pp.keySet()) {
            double px = ((double) pp.get(k) / (double) cp);
            double qx = ((double) qq.get(k) / (double) cq);
            double temp = px * (Math.log((double) (px / qx)) / Math.log((double) 2));
            result += temp;
        }
        // System.out.println(result);
        return (double) (Math.round(result * 100) / 100.0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String[] pp = line1.split("\\s+");
        String[] qq = line2.split("\\s+");
        int[] p = new int[pp.length];
        int[] q = new int[qq.length];
        for (int i = 0; i < p.length; ++i) {
            p[i] = Integer.parseInt(pp[i]);
        }
        for (int i = 0; i < q.length; ++i) {
            q[i] = Integer.parseInt(qq[i]);
        }
        System.out.println(klDistance(p, q));
    }
}
