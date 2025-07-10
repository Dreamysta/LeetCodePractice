import java.util.Arrays;

public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] answer = new int[N];

        // 第一次遍历：计算前缀积
        answer[0] = 1;
        for (int i = 1; i < N; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // 第二次遍历：乘上后缀积
        int R = 1;
        for (int i = N - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }

    // 测试代码
    public static void main(String[] args) {
        LeetCode238 solution = new LeetCode238();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        System.out.println("结果数组: " + Arrays.toString(result));
        // 输出: 结果数组: [24, 12, 8, 6]
    }
}
