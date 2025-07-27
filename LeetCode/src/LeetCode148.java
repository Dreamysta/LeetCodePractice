
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

class Solution{
    public ListNode sortList(ListNode head){
        return sortList(head,null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if(head == null) return head;

        if(head.next == tail){
            head.next = null;
            return head;
        }

        ListNode slow = head ,fast = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        ListNode list1 = sortList(head,mid);

        ListNode list2 = sortList(mid,tail);

        return merge(list1,list2);
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummyHead = new ListNode(0);

        ListNode temp = dummyHead;

        while (l1 != null && l2 !=null){
            if(l1.val<=l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null) temp.next = l1;

        if(l2 != null) temp.next = l2;

        return dummyHead.next;
    }
}

public class LeetCode148{
    public static void main(String[] args){
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        Solution solution = new Solution();
        ListNode sorted = solution.sortList(head);

        System.out.print("排序结果：");

        while (sorted != null){
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
    }
}
