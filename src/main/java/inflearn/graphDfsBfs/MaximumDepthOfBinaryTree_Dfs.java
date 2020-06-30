package inflearn.graphDfsBfs;

import java.util.Stack;

/**
 * #DFS #Stack
 */
public class MaximumDepthOfBinaryTree_Dfs {

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
        int result = 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();
        stack.push(root);
        levelStack.push(1);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int level = levelStack.pop();
            result = Math.max(result, level);
            if(node.left != null){
                stack.push(node.left);
                levelStack.push(level+1);
            }
            if(node.right != null){
                stack.push(node.right);
                levelStack.push(level+1);
            }
        }


        return result;
    }
}
