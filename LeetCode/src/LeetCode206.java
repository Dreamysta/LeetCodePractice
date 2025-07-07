public class LeetCode206 {
    // 定义单链表的节点类
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    // 链表反转方法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    // 打印链表的方法
    public void printList(ListNode head){
        ListNode curr = head;
        while (curr != null){
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // 主函数，用于测试
    public static void main(String[] args) {
        LeetCode206 solution = new LeetCode206();

        // 创建一个链表：1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("原始链表:");
        solution.printList(head);

        // 反转链表
        ListNode reversed = solution.reverseList(head);

        System.out.println("反转后的链表:");
        solution.printList(reversed);
    }
}
