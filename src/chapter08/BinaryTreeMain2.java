package chapter08;

public class BinaryTreeMain2 {
    public static void main(String[] args) {
        Tree<Integer> tree = new BinaryTreeTraverse<>();
        TreeNode<Integer> tree1 = tree.makeBTreeNode(1);
        TreeNode<Integer> tree2 = tree.makeBTreeNode(2);
        TreeNode<Integer> tree3 = tree.makeBTreeNode(3);
        TreeNode<Integer> tree4 = tree.makeBTreeNode(4);
        TreeNode<Integer> tree5 = tree.makeBTreeNode(5);
        TreeNode<Integer> tree6 = tree.makeBTreeNode(6);

        tree.makeLeftSubTree(tree1, tree2);
        tree.makeRightSubTree(tree1, tree3);
        tree.makeLeftSubTree(tree2, tree4);
        tree.makeRightSubTree(tree2, tree5);
        tree.makeRightSubTree(tree3, tree6);

        tree.preorderTraverse(tree1, (data) -> System.out.printf("%d ", data));
        System.out.println();
        tree.inorderTraverse(tree1, (data) -> System.out.printf("%d ", data));
        System.out.println();
        tree.postTraverse(tree1, (data) -> System.out.printf("%d ", data));

    }


}
