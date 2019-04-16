package tree;

import java.util.ArrayList;

public class Tree<Element> {
    private TreeNode<Element> root;

    private int size;

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public Tree(){
        this.root = null;
    }

    public Tree(Element[] elements){
        createTreeByArray(root, elements, 0);
    }

    public TreeNode<Element> createTreeByArray(TreeNode<Element> root, Element[] elements, int i){
        //TODO:这里算法有问题
        if(i < elements.length){
            if(elements[i] == null){
                return null;
            } else{
                root = new TreeNode<>(elements[i]);
                root.setLeft(createTreeByArray(root.getLeft(), elements, 2 * i + 1));
                root.setRight(createTreeByArray(root.getRight(), elements, 2 * i + 2));
                return root;
            }
        }
        return root;
    }

    private void inOrderTraverse(TreeNode<Element> root){
        if(root != null){
            inOrderTraverse(root.getLeft());
            System.out.println(root.getData() + " ");
            inOrderTraverse(root.getRight());
        }
    }

    public void preOrderTraverse(){
        preOrderTraverse(this.root);
    }

    private void preOrderTraverse(TreeNode<Element> root){
        if(root != null){
            System.out.println(root.getData() + " ");
            preOrderTraverse(root.getLeft());
            preOrderTraverse(root.getRight());
        }
    }

    public void postOrderTraverse(){
        postOrderTraverse(this.root);
    }

    private void postOrderTraverse(TreeNode<Element> root){
        if(root != null){
            postOrderTraverse(root.getLeft());
            postOrderTraverse(root.getRight());
            System.out.println(root.getData() + " ");
        }
    }

    public void inOrderTraverse(){
        inOrderTraverse(this.root);
    }

    public TreeNode<Element> getRoot(){
        return this.root;
    }

    public void setRoot(TreeNode<Element> root){
        this.root = root;
    }
}
