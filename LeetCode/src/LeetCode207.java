import java.util.*;

public class LeetCode207 {

    // 判断是否可以完成所有课程
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建图的邻接表
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses]; // 每门课的入度

        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 构建图和入度数组
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int pre = edge[1];
            graph.get(pre).add(course); // pre 是 course 的前置课程
            indegree[course]++;         // course 的入度加 1
        }

        // 所有入度为 0 的课程加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0; // 记录已经完成的课程数量

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 当前完成的课程
            count++; // 完成课程数加 1

            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--; // 相邻课程入度减 1
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor); // 如果入度为 0，加到队列中
                }
            }
        }

        // 所有课程都完成了就返回 true，否则 false
        return count == numCourses;
    }

    // 主函数，用于测试
    public static void main(String[] args) {
        // 测试用例1：可以完成所有课程
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println("测试用例1结果：" + canFinish(numCourses1, prerequisites1)); // true

        // 测试用例2：存在环，无法完成所有课程
        int numCourses2 = 2;
        int[][] prerequisites2 = {{0, 1}, {1, 0}};
        System.out.println("测试用例2结果：" + canFinish(numCourses2, prerequisites2)); // false
    }
}
