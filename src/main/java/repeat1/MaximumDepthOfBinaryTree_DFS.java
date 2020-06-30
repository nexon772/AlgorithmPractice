package repeat1;


import java.util.Stack;

public class MaximumDepthOfBinaryTree_DFS {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(7);

        System.out.println(new MaximumDepthOfBinaryTree_DFS().solve(root));
    }

    private int solve(TreeNode root){
        if(root == null) return 0;
        // save level count
        int result = 0;
        // Stack for TreeNode
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // Stack for level
        Stack<Integer> levelStack = new Stack<>();
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
