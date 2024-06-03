package chapter08;

public class BinaryTreeTraverseMain {
    public static void main(String[] args) {
        Tree<Integer> tree = new BinaryTree<>();
        TreeNode<Integer> treeNode1 = tree.makeBTreeNode(1);
        TreeNode<Integer> treeNode2 = tree.makeBTreeNode(2);
        TreeNode<Integer> treeNode3 = tree.makeBTreeNode(3);
        TreeNode<Integer> treeNode4 = tree.makeBTreeNode(4);

        tree.makeLeftSubTree(treeNode1, treeNode2);
        tree.makeRightSubTree(treeNode1, treeNode3);
        tree.makeLeftSubTree(treeNode2, treeNode4);

        tree.inorderTraverse(treeNode1);
    }
}
