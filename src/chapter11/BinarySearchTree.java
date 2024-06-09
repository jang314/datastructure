package chapter11;

import chapter08.TreeNode;

public abstract class BinarySearchTree<T> {
    protected abstract TreeNode<T> makeBTreeNode();
    protected abstract T getData(TreeNode<T> node);
    protected abstract void setData(TreeNode<T> node, T data);
    protected abstract TreeNode<T> getLeftSubTree(TreeNode<T> node);
    protected abstract TreeNode<T> getRightSubTree(TreeNode<T> node);
    protected abstract void makeLeftSubTree(TreeNode<T> main, TreeNode<T> sub);
    protected abstract void makeRightSubTree(TreeNode<T> main, TreeNode<T> sub);
}
