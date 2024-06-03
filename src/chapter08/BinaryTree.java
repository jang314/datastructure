package chapter08;

public class BinaryTree<T> extends Tree<T>{

    public BinaryTree() {
        super();
    }


    @Override
    public TreeNode<T> makeBTreeNode(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);
        return newNode;
    }

    @Override
    public T getData(TreeNode<T> node) {
        return node.getData();
    }



    @Override
    public TreeNode<T> getLeftSubTree(TreeNode<T> node) {
        return node.getLeft();
    }

    @Override
    public TreeNode<T> getRightSubTree(TreeNode<T> node) {
        return node.getRight();
    }

    @Override
    public void makeLeftSubTree(TreeNode<T> main, TreeNode<T> sub) {
        main.setLeft(sub);
    }

    @Override
    public void makeRightSubTree(TreeNode<T> main, TreeNode<T> sub) {
        main.setRight(sub);
    }


}
