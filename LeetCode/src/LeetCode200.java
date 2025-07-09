public class LeetCode200 {

    // 深度优先搜索，将岛屿淹没
    void dfs(char[][] grid,int r,int c){
        int nr = grid.length;
        int nc = grid[0].length;

        // 越界或是水域则返回
        if(r < 0 || c < 0 ||r >= nr || c >=nc || grid[r][c] != '1' ){
            return;
        }

        // 将当前陆地标记，表示已访问
        grid[r][c] = '2';

        //向四个方向扩展
        dfs(grid, r-1, c);//上
        dfs(grid, r + 1, c); // 下
        dfs(grid, r, c - 1); // 左
        dfs(grid, r, c + 1); // 右
    }

    // 主方法：统计岛屿数量
    public int numIslands(char[][] grid){
        if(grid == null || grid.length ==0){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c); // 全部标记
                }
            }
        }

        return num_islands;
    }

    // 测试主函数
    public static void main(String[] args){
        LeetCode200 solution = new LeetCode200();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result = solution.numIslands(grid);
        System.out.println("岛屿数量为：" + result);
    }



}
