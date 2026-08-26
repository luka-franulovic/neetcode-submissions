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
    public void reorderList(ListNode head) {
        if (head == null) return;
        if (head.next == null) return;
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            length++;
        }
        int moves = (length - 1) / 2;
        ListNode current = head;
        while (moves > 0){
            ListNode secondToLast = head;
            while (secondToLast.next.next != null){
                secondToLast = secondToLast.next;
            }
            ListNode end = secondToLast.next;
            
            ListNode second = current.next;
            current.next = end;
            secondToLast.next = null;
            end.next = second;

            current = current.next.next;
            moves--;
        }
    }
}
