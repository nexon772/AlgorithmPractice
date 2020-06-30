package practice_coupangTest2.testClass;

public class BinarySearchTreeTester {

    public static void main(String[] args){
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        new BinarySearchTreeTester().makeBinarySearchTree(arr);
    }

    private void makeBinarySearchTree(int[] arr){
        BSTNode root = makeTree(arr, 0, arr.length-1);
        searchBTree(root, 8);
    }

    private BSTNode makeTree(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            BSTNode node = new BSTNode(arr[mid]);
            node.left = makeTree(arr, start, mid - 1);
            node.right = makeTree(arr, mid + 1, end);
            return node;
        }
        return null;
    }

    private void searchBTree(BSTNode n, int find){
        if(find < n.data){
            System.out.println("smaller than "+n.data);
            searchBTree(n.left, find);
        } else if(find > n.data) {
            System.out.println("bigger than "+n.data);
            searchBTree(n.right, find);
        } else {
            System.out.println(n.data);
        }
    }

    class BSTNode{
        int data;
        BSTNode left, right;
        BSTNode(int data){
            this.data = data;
        }
    }
}
