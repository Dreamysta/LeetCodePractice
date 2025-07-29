public class LeetCode141 {

    // 链表节点类定义
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

// 判断链表是否有环的解法（Floyd 判圈算法）
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // 测试主函数
    public static void main(String[] args) {
        LeetCode141 solution = new LeetCode141();

        // 测试1：有环链表（3 -> 2 -> 0 -> -4 -> 指向 node2）
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // 构成环

        System.out.println("测试1：链表是否有环？" + solution.hasCycle(head1));  // 输出: true

        // 测试2：无环链表（1 -> 2）
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println("测试2：链表是否有环？" + solution.hasCycle(head2));  // 输出: false
    }
}
