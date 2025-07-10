import java.util.Arrays;

public class LeetCode169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 测试代码
    public static void main(String[] args) {
        LeetCode169 solution = new LeetCode169();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = solution.majorityElement(nums);
        System.out.println("众数是: " + result); // 输出: 众数是: 2
    }
}
