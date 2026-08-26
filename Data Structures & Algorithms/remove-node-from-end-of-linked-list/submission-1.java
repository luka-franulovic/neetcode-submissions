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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        int removalIndex = length - n;
        ListNode before = new ListNode();
        ListNode toRemove = new ListNode();
        ListNode after = new ListNode();
        temp = head;
        if (removalIndex == 0){ 
            head = head.next;
            return head;
        }
        for (int i = 0; i < removalIndex; i++){
            before = temp;
            temp = temp.next;
        }
        toRemove = before.next;
        if (toRemove != null){
            after = toRemove.next;
            before.next = after;
        }
        else{
            before.next = null;
        }
        return head;
    }
}
