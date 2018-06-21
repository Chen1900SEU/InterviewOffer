package CompanyRecruitCode.奇虎360;

import java.util.Arrays;
import java.util.Scanner;

public class code360_2 {
    public static boolean isEqual(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2] == nums[nums.length / 2 - 1] ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numSample = sc.nextInt();
        for (int i = 0; i < numSample; ++i) {
            int n = sc.nextInt();
            int[] nums = new int[n * 2];
            for (int j = 0; j < n * 2; ++j) {
                nums[j] = sc.nextInt();
            }
            if (isEqual(nums)) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
