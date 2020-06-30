package hackerrank;

public class Tree_HuffmanDecoding {
    /*
    void decode(String s, Node root) {
        char[] sArray = s.toCharArray();
        Node head = root;
        String result = "";
        for(char ch : sArray){
            switch(ch){
                case '1':
                    // right
                    if(head.right != null){
                        head = head.right;
                    }
                    break;
                case '0':
                    if(head.left != null){
                        head = head.left;
                    }
                    break;
                default:
                    break;
            }
            if(head.right == null && head.left == null){
                result += head.data;
                head = root;
            }
        }
        System.out.println(result);
    }

     */
}
