package repeat1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder_BFS {

    public static void main(String[] args){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(7);
        node.right = new TreeNode(5);
        List<List<Integer>> result = new BinaryTreeLevelOrder_BFS().solve(node);
        System.out.println(result);
    }

    private List<List<Integer>> solve(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            result.add(list);
        }
        return result;
    }
}