import java.util.Stack;

public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;  // 获取温度数组的长度
        int[] answer = new int[n];  // 创建一个与 temperatures 长度相同的数组来存储结果
        Stack<Integer> stack = new Stack<>();  // 创建一个栈，用来存储尚未找到升温日的温度索引

        for (int i = 0; i < n; i++) {  // 遍历每一天的温度
            // 如果栈不为空，并且当前温度比栈顶索引对应的温度高
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();  // 弹出栈顶元素，表示找到了该温度的升温日
                answer[prevDay] = i - prevDay;  // 计算出升温日距离，更新结果数组
            }
            stack.push(i);  // 将当前温度的索引压入栈中
        }

        return answer;  // 返回结果数组
    }

    // 示例测试
    public static void main(String[] args) {
        LeetCode739 solver = new LeetCode739();  // 创建类实例
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};  // 示例温度数组
        int[] result = solver.dailyTemperatures(temps);  // 调用方法获取结果

        for (int days : result) {  // 遍历结果数组并打印
            System.out.print(days + " ");  // 输出每个元素
        }
    }
}
