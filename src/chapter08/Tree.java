package chapter08;

public abstract class Tree<T> {
    /**
     * - 이진 트리 노드를 생성하고 데이터를 저장한다.
     * */
    public TreeNode<T> makeBTreeNode(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);
        return newNode;
    }

    /**
     * - 노드에 저장된 데이터를 반환한다.
     * */
    public T getData(TreeNode<T> node) {
        return node.getData();
    }


    /**
     * - 왼쪽 서브 트리 데이터를 반환한다.
     * */
    public TreeNode<T> getLeftSubTree(TreeNode<T> node) {
        return node.getLeft();
    }

    /**
     * - 오른쪽 서브 트리 데이터를 반환한다.
     * */
    public TreeNode<T> getRightSubTree(TreeNode<T> node) {
        return node.getRight();
    }

    /**
     * - 왼쪽 서브 트리를 연결한다.
     * */
    public void makeLeftSubTree(TreeNode<T> main, TreeNode<T> sub) {
        main.setLeft(sub);
    }

    /**
     * - 오른쪽 서브 트리를 연결한다.
     * */
    public void makeRightSubTree(TreeNode<T> main, TreeNode<T> sub) {
        main.setRight(sub);
    }

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
    public TreeNode<T> removeLeftSubTree(TreeNode<T> btree) {
        TreeNode<T> delNode = null;
        if(btree != null) {
            delNode = btree.getLeft();
            btree.setLeft(null);
        }
        return delNode;
    }

    public TreeNode<T> removeRightSubTree(TreeNode<T> btree) {
        TreeNode<T> delNode = null;
        if(btree != null) {
            delNode = btree.getRight();
            btree.setRight(null);
        }
        return delNode;
    }

    public void changeLeftSubTree(TreeNode<T> main, TreeNode<T> sub) {
        main.setLeft(sub);
    }

    public void changeRightSubTree(TreeNode<T> main, TreeNode<T> sub) {
        main.setRight(sub);
    }
}
