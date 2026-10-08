/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode t=head;
        ListNode before=null;
        for(int i=1;i<left;i++){
            before=t;
            t=t.next;
        }
        ListNode curr=t;
        ListNode prev=null;
        for(int i=0;i<=right-left;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        if(before!=null){
            before.next=prev;
        }
        else{
            head=prev;
        }
        t.next=curr;
        return head;
    }
}*/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head ==  null || left==right) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode before=dummy;
        ListNode lhead=head;
        for(int i=0;i<left-1;i++){
            before=lhead;
            lhead=lhead.next;
        }
        ListNode curr=lhead;
        ListNode prev=null;
        for(int i=0;i<=right-left;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        before.next=prev;
        lhead.next=curr;
        return dummy.next;
    }
}