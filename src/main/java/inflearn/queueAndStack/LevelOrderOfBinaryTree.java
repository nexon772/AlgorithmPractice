package inflearn.queueAndStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * #Queue #BFS
 *
 * example #1
 * Input:
 *         /[3]\
 *    /[4]\    [5]
 * [6]    [7]
 * Output:
 * [[3], [4,5], [6,7]]
 */
public class LevelOrderOfBinaryTree {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        List<List<Integer>> result = solve(root);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list =  new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right!= null)
                    queue.offer(node.right);
            }
            result.add(list);
        }
        return result;
    }
}

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int x){
        this.val = x;
    }
}
