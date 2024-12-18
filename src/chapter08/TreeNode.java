package chapter08;


public class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T data;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data == null ? (T) "NULL" : data;
    }

    public void setData(TreeNode<T> node) {
        this.data = node.getData();
    }

    public void setData(T data) {
        this.data = data;
    }


}
