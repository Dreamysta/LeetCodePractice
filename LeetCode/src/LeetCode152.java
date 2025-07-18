public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                // 负数时交换最大最小
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }

        return max;
    }

    // 测试用例
    public static void main(String[] args) {
        LeetCode152 sol = new LeetCode152();

        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};
        int[] nums3 = {-2, 3, -4};

        System.out.println("Max product (nums1): " + sol.maxProduct(nums1)); // 输出 6
        System.out.println("Max product (nums2): " + sol.maxProduct(nums2)); // 输出 0
        System.out.println("Max product (nums3): " + sol.maxProduct(nums3)); // 输出 24
    }
}
