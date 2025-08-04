import java.util.Arrays;

public class LeetCode322 {
    public int coinChange(int[] coins,int amount){
        int max = Integer.MAX_VALUE;

        int[] dp = new int[amount + 1];

        for (int j = 0;j < dp.length;j++){
            dp[j] = max;
        }

        dp[0] = 0;

        for (int i = 0;i < coins.length;i++){
            for(int j = coins[i];j <= amount;j++){
                if(dp[j - coins[i]] != max){
                    dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == max ? -1:dp[amount];
    }
    public static void main(String[] args) {
        LeetCode322 solution = new LeetCode322();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = solution.coinChange(coins, amount);
        System.out.println("最少需要的硬币数是: " + result);  // 输出应为 3 （5+5+1）
    }


}
