package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Input:
 *
 */
public class BFS_ShortestReach {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new BFS_ShortestReach().bfs(4, 2, new int[][]{{1,2},{1,3}}, 1)));
        System.out.println(Arrays.toString(new BFS_ShortestReach().bfs(3, 1, new int[][]{{2,3}}, 2)));
    }

    private int[] bfs(int n, int m, int[][] edges, int s){

        TreeNode node = new TreeNode();
        for(int i=0; i<edges.length; i++){
//            insert(list, edges[i]);
        }

        return null;
    }

    private void insert(List<TreeNode> list, int[] edge){
        if(list == null) return;
        if(list.get(edge[0]-1).right == null){
            list.get(edge[0]-1).right = list.get(edge[1]-1);
        } else {

        }
    }

    private TreeNode addRecursive(TreeNode current, int value){
        if(current == null) return new TreeNode(value);
        if(value < current.val){
            current.left = addRecursive(current.left, value);
        } else if(value > current.val){
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    private int maxDepth(TreeNode node){
        return 0;
    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int x){this.val = x;}
}
