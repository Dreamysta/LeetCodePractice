public class LeetCode215 {

    // 快速选择函数：在 nums[l..r] 中找第 k 小的元素（k 是下标）
    int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k]; // 区间内只有一个元素，直接返回

        int x = nums[l];            // 选择第一个元素作为基准值 pivot
        int i = l - 1, j = r + 1;   // 初始化左右指针（Hoare 分区法）

        // 分区过程
        while (i < j) {
            do i++; while (nums[i] < x); // 找左边第一个大于等于 pivot 的位置
            do j--; while (nums[j] > x); // 找右边第一个小于等于 pivot 的位置
            if (i < j) {
                // 交换不符合条件的元素
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        // 根据 k 的位置判断递归方向
        if (k <= j) return quickselect(nums, l, j, k);      // k 在左边
        else return quickselect(nums, j + 1, r, k);         // k 在右边
    }

    // 主函数：返回数组中第 k 个最大的元素
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 转换成第 n - k 小的元素（因为索引从 0 开始）
        return quickselect(nums, 0, n - 1, n - k);
    }

    // 测试主函数
    public static void main(String[] args) {
        LeetCode215 solution = new LeetCode215();

        // 示例数组和 k 值
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        // 打印结果
        int result = solution.findKthLargest(nums, k);
        System.out.println("第 " + k + " 个最大的元素是: " + result);
    }
}
