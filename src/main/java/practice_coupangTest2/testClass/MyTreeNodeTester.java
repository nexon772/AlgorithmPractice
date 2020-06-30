package practice_coupangTest2.testClass;

import practice_coupangTest2.dataStructure.MyTreeNode;

public class MyTreeNodeTester {

    public static void main(String[] args){
        testMyTreeNode();
    }

    public static void testMyTreeNode(){
        MyTreeNode<Integer> tree = new MyTreeNode<>(3);

        tree.addChild(5);
        tree.addChild(1);

        while(tree.hasNext()){
            System.out.println(tree.next().print());
        }

        tree.printTree(tree);


    }
}
