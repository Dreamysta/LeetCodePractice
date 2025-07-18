import java.util.Deque;
import java.util.LinkedList;

public class LeetCode155 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public LeetCode155() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE); // 初始最小值为最大整数
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // 测试用例
    public static void main(String[] args) {
        LeetCode155 stack = new LeetCode155();

        stack.push(3);
        stack.push(5);
        System.out.println("Min: " + stack.getMin()); // 输出 3

        stack.push(2);
        stack.push(1);
        System.out.println("Min: " + stack.getMin()); // 输出 1

        stack.pop();
        System.out.println("Min: " + stack.getMin()); // 输出 2

        System.out.println("Top: " + stack.top());    // 输出 2

        stack.pop();
        System.out.println("Min: " + stack.getMin()); // 输出 3
    }
}
