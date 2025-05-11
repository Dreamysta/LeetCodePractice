public class LeetCode234 {

    // 定义链表节点类
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // 主算法：判断是否为回文链表
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表
        ListNode prev = null;
        while (slow != null) {
            ListNode nextTemp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextTemp;
        }

        // 比较前半部分和反转的后半部分
        ListNode left = head, right = prev;
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // 创建链表（用于测试）
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // 测试主程序
    public static void main(String[] args) {
        LeetCode234 sol = new LeetCode234();
        int[] values = {1, 2, 3, 2, 1};
        ListNode head = createList(values);
        System.out.println("是否为回文链表: " + sol.isPalindrome(head));  // 输出 true
    }
}
