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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> st = new Stack<ListNode>();
        ListNode node = head;
        while (node != null){
            st.push(node);
            node = node.next;
        }
        if (st.empty()){
            return null;
        }
        ListNode prev = st.pop();
        ListNode result = prev;
        while (!st.empty()){
            ListNode temp = st.pop();
            prev.next = temp;
            prev = temp;
        }
        prev.next = null;
        return result;
    }
}
