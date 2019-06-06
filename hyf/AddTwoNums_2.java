package solution;

/*class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
  }
 */
public class AddTwoNums_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode p1 = l1,p2 = l2,p3 = newList;
        int flag = 0;
        for(;p1 != null && p2 != null;p1 = p1.next,p2 = p2.next){
            int value = p1.val + p2.val + flag;
            flag = 0;
            if(value >= 10){
                ListNode N = new ListNode(value - 10);
                flag = 1;
                p3.next = N;
                p3 = N;
            }
            else{
                ListNode N = new ListNode(value);
                p3.next = N;
                p3 = N;
            }
        }

        if(flag == 1 && p1 == null && p2 == null){
            ListNode N = new ListNode(1);
            p3.next = N;
            p3 = N;
            return newList.next;
        }
        ListNode p4;
        if(p1 != null){
            p4 = p1;
        }
        else p4 = p2;

        while(p4 != null){
            int value = p4.val + flag;
            if(value >= 10){
                ListNode N = new ListNode(value - 10);
                p3.next = N;
                p3 = N;
            }
            else{
                flag = 0;
                ListNode N = new ListNode(value);
                p3.next = N;
                p3 = N;
            }
            p4 = p4.next;
        }
        if(flag == 1 && p4 == null){
            ListNode N = new ListNode(1);
            p3.next = N;
            p3 = N;
        }
        return newList.next;
    }
    /*
        恶臭代码
        执行用时 : 10 ms, 在Add Two Numbers的Java提交中击败了83.96% 的用户
        内存消耗 : 42.4 MB, 在Add Two Numbers的Java提交中击败了91.94% 的用户
     */
    public ListNode addTwoNumbers_v2(ListNode l1, ListNode l2){
        ListNode p1 = l1,p2 = l2;
        int l1_num = 0,l2_num = 0,cnt = 1;
        while(p1 != null || p2 != null){
            if(p1 != null){
                l1_num = p1.val*cnt+ l1_num;
                p1 = p1.next;
            }
            if(p2 != null){
                l2_num = p2.val*cnt+l2_num;
                p2 = p2.next;
            }
            cnt *= 10;
        }
        int num = l1_num + l2_num;
        ListNode newlist = new ListNode(0);
        ListNode tail = newlist;
        while(num > 0){
            tail = tail.next = new ListNode(num%10);
            num = num /10;
        }
        return newlist.next;
    }
    /*
        错误，无法处理大数字
     */

    public ListNode addTwoNumbers_v3(ListNode l1, ListNode l2){
        ListNode p1 = l1,p2 = l2,newlist = new ListNode(0),tail = newlist;
        int carry = 0;
        while(p1 != null || p2 != null){
            int x = (p1 == null)?0:p1.val;
            int y = (p2 == null)?0:p2.val;
            int num = x + y + carry;
            carry = num/10;
            tail = tail.next = new ListNode(num%10);
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        }
        if(carry > 0) tail.next = new ListNode(carry);
        return newlist.next;
    }
    /*
        时间复杂度O(Max(l1.length,l2.length))
        空间复杂度O(Max(l1.length,l2.length))
        执行用时 : 11 ms, 在Add Two Numbers的Java提交中击败了62.63% 的用户
        内存消耗 : 43.1 MB, 在Add Two Numbers的Java提交中击败了89.49% 的用户
     */

    ListNode newList = new ListNode(0);
    ListNode tail = newList;
    int carry = 0;
    public ListNode addTwoNumbers_v4(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            if (carry > 0) tail.next = new ListNode(1);
            return newList.next;
        }
        int x = (l1 == null) ? 0 : l1.val;
        int y = (l2 == null) ? 0 : l2.val;
        int num = x + y + carry;
        carry = num / 10;
        tail = tail.next = new ListNode(num % 10);
        return addTwoNumbers_v4((l1 != null)?l1.next:null, (l2 != null)?l2.next:null);
    }
    /*
        递归版本需要用到全局变量
        执行用时 : 10 ms, 在Add Two Numbers的Java提交中击败了83.96% 的用户
        内存消耗 : 42.3 MB, 在Add Two Numbers的Java提交中击败了92.23% 的用户
     */
}
