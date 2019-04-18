package tree;

public class Test {

    @org.junit.Test
    public void test(){
        Tree<Integer> tree = new Tree<>();
        tree.setRoot(new TreeNode<Integer>(1));
        tree.getRoot().setLeft(new TreeNode<Integer>(2));
        tree.getRoot().getLeft().setRight(new TreeNode<Integer>(3));
        tree.getRoot().setRight(new TreeNode<Integer>(4));
        System.out.println("----------前序遍历----------");
        tree.preOrderTraverse();
        System.out.println("----------中序遍历----------");
        tree.inOrderTraverse();
        System.out.println("----------后序遍历----------");
        tree.postOrderTraverse();

        Integer[] array = new Integer[]{3, 9, 20, null, null, 15, 7};
        Tree<Integer> tree2 = new Tree<>(array);
        tree2.preOrderTraverse();

        System.out.println("树的高度");
        System.out.println(tree.getHeight(tree.getRoot()));

        System.out.println(tree.contains(5));
    }
}
