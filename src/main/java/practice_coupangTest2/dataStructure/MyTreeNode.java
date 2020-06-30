package practice_coupangTest2.dataStructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyTreeNode<T> implements Iterator<MyTreeNode<T>> {

    private T data;
    private MyTreeNode<T> parent;
    private List<MyTreeNode<T>> children;

    public MyTreeNode(T data){
        this.data = data;
        this.children = new LinkedList<MyTreeNode<T>>();
    }

    public MyTreeNode<T> addChild(T child){
        MyTreeNode<T> childNode = new MyTreeNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    public Iterator<MyTreeNode<T>> iterator(){
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MyTreeNode<T> next() {
        return null;
    }

    @Override
    public void remove() {

    }

    public T print(){
        return data;
    }

    public void printTree(MyTreeNode root){
        System.out.println(root.data);
        for(int i=0; i<root.children.size(); i++){
            printTree((MyTreeNode)root.children.get(i));
        }
    }
}
