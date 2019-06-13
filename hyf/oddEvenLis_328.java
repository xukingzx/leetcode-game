package solution;

import dataStruct.ListNode;

public class oddEvenLis_328 {
    public ListNode oddEvenList_v1(ListNode head) {
        ListNode even = null,odd = null;
        if(head != null && head.next != null){
            even = head;
            odd = head.next;
        }
        while(odd != null && odd.next != null){
            ListNode temp = odd.next.next;
            odd.next.next = even.next;
            even.next = odd.next;
            odd.next = temp;
            even = even.next;
            odd = odd.next;
        }
        return head;
    }
}
