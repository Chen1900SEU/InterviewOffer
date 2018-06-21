package CompanyRecruitCode.京东;

import java.util.Scanner;

public class JD2018Intern_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] input;
        input = new long[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLong();
        }
        for (long num : input) {
            if (num == 0) {
                System.out.println("No");
            } else {
                boolean judge = true;
                for (long i = 2; i < num; ) {
                    if (num % i == 0) {
                        if ((num / i) % 2 == 1) {
                            System.out.println((num / i) + " " + i);
                            judge = false;
                            break;
                        } else {
                            i += 2;
                        }
                    } else {
                        break;
                    }
//                    judge = false;
                }
                if (judge) {
                    System.out.println("No");
                }

            }
        }
    }
}
