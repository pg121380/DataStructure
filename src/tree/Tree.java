package tree;

import java.util.ArrayList;
import java.util.Stack;

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

    /**
     *
     * @param insertRoot    要插入在哪个结点的下面
     * @param value         插入的节点的值
     * @param position      0：插入到左子树， 1：插入到右子树
     * @return  true:插入成功 false:插入失败
     */
    public boolean insert(TreeNode<Element> insertRoot, Element value, int position){
        if(position != 0 && position != 1){
            System.err.println("参数position必须是0/1！");
            return false;
        }
        if(!contains(insertRoot.getData())){
            System.err.println("输入的insertRoot不属于本树！");
            return false;
        }
        if(position == 0){
            insertRoot.setLeft(new TreeNode<>(value));
        } else if (position == 1){
            insertRoot.setRight(new TreeNode<>(value));
        }
        return true;
    }

    /**
     * 由于本类不是二叉搜索树，无法使用递归实现contains()，使用二叉树的非递归遍历实现contains()方法
     * @param value 要查找的value
     * @return  该value是否属于本树
     */
    public boolean contains(Element value){
        Stack<TreeNode<Element>> stack = new Stack<>();
        TreeNode<Element> temp = this.root;
        while(temp != null || !stack.empty()){
            if(temp != null){
                if (temp.getData().equals(value)){
                    return true;
                }
                stack.push(temp);
                temp = temp.getLeft();
            } else {
                temp = stack.pop();
                temp = temp.getRight();
            }
        }
        return false;
    }

    /**
     * 传入树的根节点，递归计算树的高度(此方法应该被写在与树相关的操作的类中)
     * @param root 树根
     * @return 树的高度
     */
    public int getHeight(TreeNode<Element> root){
        if(root == null){
            return 0;
        } else {
            int leftHeight = getHeight(root.getLeft());
            int rightHeight = getHeight(root.getRight());
            return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
        }
    }
}
