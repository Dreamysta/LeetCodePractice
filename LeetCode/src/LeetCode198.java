public class LeetCode198 {
    public int rob(int[] nums) {//nums是钱
        if (nums.length == 0) return 0;

        int N = nums.length;
        int[] dp = new int[N + 1];// dp[k] 表示抢前 k 间房子的最大金额
        dp[0] = 0;
        dp[1] = nums[0];

        for (int k = 2; k <= N; k++) {
            //抢不抢最后一间
            dp[k] = Math.max(dp[k - 1], nums[k - 1] + dp[k - 2]);
        }

        return dp[N];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        LeetCode198 solution = new LeetCode198();
        int result = solution.rob(nums);
        System.out.println("最大可抢金额（优化前）: " + result);

    }
}
