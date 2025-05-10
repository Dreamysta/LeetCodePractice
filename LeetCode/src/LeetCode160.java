public class LeetCode160 {
    // 定义链表节点
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 相交链表解法
    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;

            ListNode pA = headA;
            ListNode pB = headB;

            while (pA != pB) {
                pA = (pA == null) ? headB : pA.next;
                pB = (pB == null) ? headA : pB.next;
            }

            return pA;
        }
    }

    // 测试代码入口
    public static void main(String[] args) {
        // 创建公共部分 c1 -> c2 -> c3
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        c1.next = c2;
        c2.next = c3;

        // 创建链表 A: a1 -> a2 -> c1
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        a1.next = a2;
        a2.next = c1;

        // 创建链表 B: b1 -> b2 -> b3 -> c1
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        // 调用方法
        Solution solution = new Solution();
        ListNode intersection = solution.getIntersectionNode(a1, b1);

        // 输出结果
        if (intersection != null) {
            System.out.println("相交节点值是：" + intersection.val);
        }
        else {
            System.out.println("两个链表不相交");
        }
    }
}
