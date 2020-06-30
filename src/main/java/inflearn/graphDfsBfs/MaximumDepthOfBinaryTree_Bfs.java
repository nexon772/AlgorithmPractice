package inflearn.graphDfsBfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #BFS #Queue
 */
public class MaximumDepthOfBinaryTree_Bfs {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(7);

        System.out.println(solve(root));

        System.out.println("====================");

        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.left.right.right.right = new TreeNode(7);

        System.out.println(solve(root));
    }

    private static int solve(TreeNode root){
        if(root == null) return 0;

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result++;
        }

        return result;
    }
}
