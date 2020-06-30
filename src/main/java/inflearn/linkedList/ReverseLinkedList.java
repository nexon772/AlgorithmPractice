package inflearn.linkedList;

/**
 * example #1
 * Input:
 * 1->2->3->null
 * Output:
 * 3->2->1->null
 */
public class ReverseLinkedList {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        printListNode(solve(node));
    }

    private static ListNode solve(ListNode input){
        ListNode current = input;
        ListNode prev = null;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private static void printListNode(ListNode node){
        ListNode mNode = node;
        while(mNode != null){
            System.out.print(mNode.val+" ");
            mNode = mNode.next;
        }
    }
}
