package chapter08;

public class BinaryTreeMain {
    public static void main(String[] args) {
        Tree<Integer> tree = new BinaryTree<>();
        TreeNode<Integer> tree1 = tree.makeBTreeNode(1);
        TreeNode<Integer> tree2 = tree.makeBTreeNode(2);
        TreeNode<Integer> tree3 = tree.makeBTreeNode(3);
        TreeNode<Integer> tree4 = tree.makeBTreeNode(4);

        tree.makeLeftSubTree(tree1, tree2);
        tree.makeRightSubTree(tree1, tree3);
        tree.makeLeftSubTree(tree2, tree4);

        TreeNode<Integer> leftSubTree = tree.getLeftSubTree(tree1);
        TreeNode<Integer> leftSubTree1 = tree.getLeftSubTree(leftSubTree);

        System.out.printf("%d ", tree.getData(leftSubTree));
        System.out.printf("%d ", tree.getData(leftSubTree1));

    }
}
