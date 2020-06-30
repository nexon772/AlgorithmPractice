package inflearn.graphDfsBfs;

/**
 * #Recursive
 *
 * example #1
 * Input:
 *             /[3]\
 *         /[1]\    [4]
 *     /[5]    [8]
 * [7]
 * Output:
 * 4
 *
 * example #2
 * Input:
 *        /[3]\
 *    /[1]\    [4]
 * [5]    [8]\
 *           [9]\
 *              [7]
 * Output:
 * 5
 */
public class MaximumDepthOfBinaryTree_Rec {

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
        int result = maxDepth(root);
        return result;
    }

    private static int maxDepth(TreeNode node){
        if(node == null) return 0;
//        System.out.println(node.val);
        int leftMax = maxDepth(node.left);
        int rightMax = maxDepth(node.right);
        return Math.max(leftMax, rightMax)+1;
    }
}

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int x){
        this.val = x;
    }
}