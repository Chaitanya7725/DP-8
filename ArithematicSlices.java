
// TC: O(n ^ 2) all the integers in the input array is traversed
// SC: O(1) as no extra DS is used 

// TC: O(n) all the integers in the input array is traversed
// SC: O(n) as 1D array is used

// TC: O(n) all the integers in the input array is traversed
// SC: O(1) as no extra DS is used 

// Runs successfully on leetcode
// in the first approach, 2 loops are used to traverse and count.
// In the second approach, the dp array is used to store the slices
// in the 3rd approach, variables are used
public class ArithematicSlices {

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices1(new int[] { 1, 2, 3, 4 })); // 3
        System.out.println(numberOfArithmeticSlices1(new int[] { 1 })); // 0

        System.out.println(numberOfArithmeticSlices2(new int[] { 1, 2, 3, 4 })); // 3
        System.out.println(numberOfArithmeticSlices2(new int[] { 1 })); // 0

        System.out.println(numberOfArithmeticSlices3(new int[] { 1, 2, 3, 4 })); // 3
        System.out.println(numberOfArithmeticSlices3(new int[] { 1 })); // 0
    }

    public static int numberOfArithmeticSlices1(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i + 1] - nums[i] == nums[j + 1] - nums[j])
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    public static int numberOfArithmeticSlices2(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;
        int count = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n - 2; i++) {
            if (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i])
                dp[i + 2] += dp[i + 1] + 1;
        }
        for (int i = 0; i < n; i++) {
            count += dp[i];
        }
        return count;
    }

    public static int numberOfArithmeticSlices3(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;
        int n = nums.length;
        int prev = 0;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            prev = nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i] ? prev + 1 : 0;
            count += prev;
        }
        return count;
    }

}