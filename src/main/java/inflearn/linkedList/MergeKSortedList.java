package inflearn.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * #PriorityQueue
 *
 * example #1
 * Input:
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * Output:
 * 1->1->2->3->4->4->5->6
 */
public class MergeKSortedList {

    public static void main(String[] args){
        run();
    }

    public static void run(){

        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(5);

        ListNode ln2 = new ListNode(1);
        ln2.next = new ListNode(3);
        ln2.next.next = new ListNode(4);

        ListNode ln3 = new ListNode(2);
        ln3.next = new ListNode(6);

        ListNode result = solve(new ListNode[]{ln1, ln2, ln3});
        printListNode(result);
    }

    private static ListNode solve(ListNode[] nodes){
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(comp);
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        for(ListNode node : nodes){
            if(node != null){
                queue.offer(node);
            }
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if(node.next != null){
                queue.offer(node.next);
            }
        }
        return newHead.next;
    }

    static Comparator<ListNode> comp = new Comparator<ListNode>(){
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };

    private static void printListNode(ListNode node){
        ListNode mNode = node;
        while(mNode != null){
            System.out.print(mNode.val+" ");
            mNode = mNode.next;
        }
    }
}
