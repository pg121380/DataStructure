package tree;

public class TreeNode<Element> {
    private Element data;

    private TreeNode<Element> left;

    private TreeNode<Element> right;

    public TreeNode(){
        this.setData(null);
        this.setLeft(null);
        this.setRight(null);
    }

    public TreeNode(Element data){
        this.setData(data);
        this.setLeft(null);
        this.setRight(null);
    }

    public TreeNode(Element data, TreeNode<Element> left, TreeNode<Element> right){
        this.setData(data);
        this.setLeft(left);
        this.setRight(right);
    }

    public Element getData() {
        return data;
    }

    public void setData(Element data) {
        this.data = data;
    }

    public TreeNode<Element> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<Element> left) {
        this.left = left;
    }

    public TreeNode<Element> getRight() {
        return right;
    }

    public void setRight(TreeNode<Element> right) {
        this.right = right;
    }
}
