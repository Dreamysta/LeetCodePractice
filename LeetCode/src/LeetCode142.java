public class LeetCode142 {

    // 定义链表节点类
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 检测环的入口
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    // 测试用例
    public static void main(String[] args) {
        LeetCode142 solution = new LeetCode142();

        // 构造链表：3 -> 2 -> 0 -> -4
        //                    ↑         ↓
        //                   ← ← ← ← ← ←
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // 构成环，入口为 node2

        ListNode entry = solution.detectCycle(head);
        if (entry != null) {
            System.out.println("环的入口节点值为: " + entry.val);
        } else {
            System.out.println("链表无环");
        }
    }
}
