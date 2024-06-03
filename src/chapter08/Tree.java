package chapter08;

public abstract class Tree<T> {


    public abstract TreeNode<T> makeBTreeNode(T t);

    public abstract T getData(TreeNode<T> node);

    public abstract TreeNode<T> getLeftSubTree(TreeNode<T> node);

    public abstract TreeNode<T> getRightSubTree(TreeNode<T> node);

    public abstract void makeLeftSubTree(TreeNode<T> main, TreeNode<T> sub);

    public abstract void makeRightSubTree(TreeNode<T> main, TreeNode<T> sub);

    public void preorderTraverse(TreeNode<T> tree) {
        if (tree == null) return;

        System.out.printf("%d \n", tree.getData());
        preorderTraverse(tree.getLeft());
        preorderTraverse(tree.getRight());

    }

    public void inorderTraverse(TreeNode<T> tree) {
        if (tree == null) return;
        inorderTraverse(tree.getLeft());
        System.out.printf("%d \n", tree.getData());
        inorderTraverse(tree.getRight());
    }

    public void postTraverse(TreeNode<T> tree) {
        if (tree == null) return;
        postTraverse(tree.getLeft());
        postTraverse(tree.getRight());
        System.out.printf("%d \n", tree.getData());
    }

    public void preorderTraverse(TreeNode<T> tree, BinaryTreeTraverse.VisitFuncPtr<T> action) {
        if (tree == null) return;
        action.action(tree.getData());
        preorderTraverse(tree.getLeft(), action);
        preorderTraverse(tree.getRight(), action);
    }

    public void inorderTraverse(TreeNode<T> tree, BinaryTreeTraverse.VisitFuncPtr<T> action) {
        if (tree == null) return;
        inorderTraverse(tree.getLeft(), action);
        action.action(tree.getData());
        inorderTraverse(tree.getRight(), action);
    }

    public void postTraverse(TreeNode<T> tree, BinaryTreeTraverse.VisitFuncPtr<T> action) {
        if (tree == null) return;

        postTraverse(tree.getLeft(), action);
        postTraverse(tree.getRight(), action);
        action.action(tree.getData());
    }

    public TreeNode<T> deleteTree(TreeNode<T> treeNode) {
        if (treeNode == null) return null;

        deleteTree(treeNode.getLeft());
        deleteTree(treeNode.getRight());
        return null;
    }

}
