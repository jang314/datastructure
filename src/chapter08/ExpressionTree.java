package chapter08;

public class ExpressionTree<T> {
    private static final Tree<String> tree = new BinaryTree<>();

    public static void main(String[] args) {
        String sik = "12+7*";
        char[] exp = new char[sik.length()];
        for(int i = 0; i <sik.length(); i++) {
            exp[i] = sik.charAt(i);
        }

        TreeNode<String> treeNode = makeExpTree(exp);
        showPrefixTypeExp(treeNode);
        System.out.println();
        showInfixTypeExp(treeNode);
        System.out.println();
        showPostfixTypeExp(treeNode);

        System.out.println();
        int result = EvaluateExpTree(treeNode);

        System.out.printf("%d", result);
    }

    public static TreeNode<String> makeExpTree(char[] exp) {
        TreeNode<String> treeNode = null;
        TreeNode<String> left = null;
        TreeNode<String> right = null;

        for(int i = 0 ; i < exp.length; i++) {
                if(Character.isDigit(exp[i])) {
                    if(left == null) {
                        left = tree.makeBTreeNode(String.valueOf(exp[i]));
                    } else {
                        right = tree.makeBTreeNode(String.valueOf(exp[i]));
                    }
                } else {
                    treeNode = tree.makeBTreeNode(String.valueOf(exp[i]));
                    tree.makeLeftSubTree(treeNode, left);
                    tree.makeRightSubTree(treeNode, right);
                    if(left != null && right != null) {
                        left = treeNode;
                        right = null;
                    } else if(left != null && right == null) {
                        right = treeNode;
                    }
                }
        }
        return treeNode;
    }

    public static int EvaluateExpTree(TreeNode<String> bt) {
        Tree<String> tree = new BinaryTree<>();
        if(tree.getRightSubTree(bt) == null && tree.getLeftSubTree(bt) == null) {
            return Integer.parseInt(bt.getData());
        }

        Integer op1 = EvaluateExpTree(tree.getLeftSubTree(bt));
        Integer op2 = EvaluateExpTree(tree.getRightSubTree(bt));
        return caluate(op1, op2, bt.getData());
    }



    private static Integer caluate(Integer op1, Integer op2, String target) {
        if(target.equals("+")) {
            return op1 + op2;
        } else if(target.equals("-")) {
            return op1 - op2;
        } else if(target.equals("*")) {
            return op1 * op2;
        } else if(target.equals("/")) {
            return op1 / op2;
        }
        return null;
    }

    private static int getRightValue(TreeNode<String> bt) {
        if(bt.getRight() == null) {
            return Integer.parseInt(bt.getData());
        }
        return getRightValue(bt.getRight());
    }

    public static int getLeftValue(TreeNode<String> bt) {
        if(bt.getLeft() == null) {
            return Integer.parseInt(bt.getData());
        }
        return getLeftValue(bt.getLeft());
    }

    public static void showPrefixTypeExp(TreeNode<String> bt) {
        tree.preorderTraverse(bt, (data) -> showNodeData(data));
    }

    public static void showInfixTypeExp(TreeNode<String> bt) {
        tree.inorderTraverse(bt, (data) -> showNodeData(data));
    }

    public static void showPostfixTypeExp(TreeNode<String> bt) {
        Tree<String> tree = new BinaryTree<>();
        tree.postTraverse(bt, (data) -> showNodeData(data));
    }

    private static void showNodeData(String data) {
        if(Character.isDigit(data.charAt(0))) {
            System.out.printf("%d ", Integer.parseInt(data));
        } else {
            System.out.printf("%s ", data);
        }
    }
}
