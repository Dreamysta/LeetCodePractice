public class LeetCode221 {

    // 主函数入口
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        LeetCode221 solver = new LeetCode221();
        int area = solver.maximalSquare(matrix);
        System.out.println("最大正方形面积是: " + area); // 应输出 4
    }

    // 计算最大正方形面积的方法
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLen = 0;

        int[][] dp = new int[rows][cols]; // dp[i][j] 表示以 (i,j) 为右下角的最大正方形边长

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // 第一行或第一列，最多只能形成边长为1的正方形
                    } else {
                        dp[i][j] = Math.min(
                                Math.min(dp[i - 1][j], dp[i][j - 1]),
                                dp[i - 1][j - 1]
                        ) + 1;
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen; // 返回面积
    }
}
