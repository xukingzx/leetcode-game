package solution;

import dataStruct.ListNode;

public class SwapListValue_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = head,pre = null;
        while(newHead != null && newHead.next != null){
            ListNode temp = newHead.next;
            newHead.next = temp.next;
            temp.next = newHead;
            if(pre != null) pre.next = temp;
            if(newHead == head) head = newHead;
            newHead = newHead.next;
        }
        return head;
    }
}
