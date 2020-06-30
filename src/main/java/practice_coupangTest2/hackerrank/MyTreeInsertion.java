package practice_coupangTest2.hackerrank;

public class MyTreeInsertion {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,5,3,6,4};
        Node root = null;
        for(int num : arr){
            root = insert(root, num);
        }

        System.out.println("==== preOrder ====");
        preOrder(root);
        System.out.println("==== postOrder ====");
        postOrder(root);
        System.out.println("==== inOrder ====");
        inOrder(root);

        System.out.println(getHeight(root));
    }

    private static Node insert(Node root, int data){
        if(root != null){
            Node cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
        } else {
            return new Node(data);
        }
        return root;
    }

    private static void preOrder(Node root){
        System.out.println(root.data);
        if(root.left != null) preOrder(root.left);
        if(root.right != null) preOrder(root.right);
    }

    private static void postOrder(Node root){
        if(root.left != null) postOrder(root.left);
        if(root.right != null) postOrder(root.right);
        System.out.println(root.data);
    }

    private static void inOrder(Node root){
        if(root.left != null) inOrder(root.left);
        System.out.println(root.data);
        if(root.right != null) inOrder(root.right);
    }

    private static int getHeight(Node root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right)+1;
    }
}
