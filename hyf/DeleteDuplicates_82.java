package waitSolve;

import dataStruct.ListNode;
import java.util.List;

public class DeleteDuplicates_82 {
    public ListNode deleteDuplicates_v1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node_ptr = new ListNode(Integer.MIN_VALUE + 98);
        node_ptr.next = head;
        ListNode pre = node_ptr,ptr = node_ptr.next;
        head = pre;
        while(ptr != null){
            while(ptr.next != null && ptr.val == ptr.next.val) ptr = ptr.next;
            if(pre.next != ptr){
                pre.next = ptr.next;
                ptr = ptr.next;
            }
            else{
                pre = pre.next;
                ptr = ptr.next;
            }
        }
        return head.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)  return head;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
        else head.next = deleteDuplicates(head.next);
        return head;
    }

}
