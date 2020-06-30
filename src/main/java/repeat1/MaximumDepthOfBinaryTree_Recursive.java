package repeat1;

public class MaximumDepthOfBinaryTree_Recursive {

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(7);

        System.out.println(new MaximumDepthOfBinaryTree_Recursive().solve(root));
    }

    private int solve(TreeNode root){
        return maxDepth(root);
    }

    private int maxDepth(TreeNode node){
        if(node == null) return 0;
        int leftMax = maxDepth(node.left);
        int rightMax = maxDepth(node.right);
        return Math.max(leftMax, rightMax)+1;
    }
}
