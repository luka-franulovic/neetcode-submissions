/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> set = new HashMap<Node, Node>();
        Node tmp = head;
        while (tmp != null){
            Node copy = new Node(tmp.val);
            set.put(tmp, copy);
            tmp = tmp.next;
        }

        tmp = head;
        while (tmp != null){
            Node copy = set.get(tmp);
            copy.next = set.get(tmp.next);
            copy.random = set.get(tmp.random);
            tmp = tmp.next;
        }
        
        return set.get(head);

    }
}
