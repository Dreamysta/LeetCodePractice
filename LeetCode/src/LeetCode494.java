import java.util.*;

public class LeetCode494 {
    public int findTargetSumWays(int[] nums,int target){
        int sum = 0;
        for(int num:nums){
            sum += num;
        }

        int diff = sum - target;

        if(diff < 0 || diff%2 != 0){
            return 0;
        }

        int neg = diff/2;

        int[] dp = new int[neg + 1];
        dp[0] = 1;

        for(int num : nums){
            for(int j = neg ; j >= num ; j--){
                dp[j] += dp[j - num];
            }
        }

        return  dp[neg];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 2};
        int target = 3;

        LeetCode494 solution = new LeetCode494();
        int result = solution.findTargetSumWays(nums, target);

        System.out.println("能组成目标和 " + target + " 的方法数是: " + result);
    }

}
