package chapter12;

import chapter08.TreeNode;
import chapter11.BstTree;

import java.util.Comparator;

public class AVLRebalance<T> extends BstTree<T> {


    public AVLRebalance(Comparator<T> comparator) {
        super(comparator);
    }

    public void bstInsert(T data) {
        super.bstInsert(data);
        this.root = bstInsert(this.root, data);
    }

    protected TreeNode<T> bstInsert(TreeNode<T> root, T data) {
        if(root == null) {
            System.out.println("root is null");
        } else if(getComparator().compare(root.getData(), data) > 0) {
            changeLeftSubTree(root, bstInsert(getLeftSubTree(root), data));
            root = rebalance(root);
        } else if (getComparator().compare(root.getData(), data) < 0) {
            changeRightSubTree(root, bstInsert(getRightSubTree(root), data));
            root = rebalance(root);
        }
        return root;
    }


    public TreeNode<T> bseRemove(T target) {
        TreeNode<T> retNode = super.bseRemove(target);
        rebalance(this.root);
        return retNode;
    }

    private TreeNode<T> rebalance(TreeNode<T> pNode) {
        int diffHeight = getHeightDiff(pNode);
        if(diffHeight > 1) {
            if(getHeightDiff(getLeftSubTree(pNode)) > 0) {
                pNode = rotateLL(pNode);
            } else {
                pNode = rotateRL(pNode);
            }
        } else if(diffHeight < -1) { // pNode의 균형 인수가 -2일 때,
            if(getHeightDiff(getRightSubTree(pNode)) < 0) { // pNode의 오른쪽 자식 노드가 음수이면
                pNode = rotateRR(pNode);
            } else {
                pNode = rotateRL(pNode);    // pNode의 오른쪽 자식 노드가 0 혹은 양수이면
            }
        }

        return pNode;
    }
    /**
     * 트리의 높이를 계산하여 반환
    * */
    public int getHeight(TreeNode<T> treeNode) {
        if(treeNode == null) {
            return 0;
        }

        int leftH = getHeight(getLeftSubTree(treeNode)); // 왼쪽 서브 트리 높이 계산
        int rightH = getHeight(getRightSubTree(treeNode));  // 오른쪽 서브 트리 높이 계산

        return leftH > rightH ? leftH + 1 : rightH + 1;
    }

    /**
     * 두 서브 트리의 '높이의 차(균형 인수)'를 반환
    * */
    public int getHeightDiff(TreeNode<T> treeNode) {
        if(treeNode == null) {
            return 0;
        }
        int leftH = getHeight(getLeftSubTree(treeNode));
        int rightH = getHeight(getRightSubTree(treeNode));

        return leftH - rightH;
    }

    public TreeNode<T> rotateLL(TreeNode<T> pNode) {
        TreeNode<T> cNode = getLeftSubTree(pNode);
        changeLeftSubTree(pNode, getRightSubTree(cNode));
        changeRightSubTree(cNode, pNode);
        return cNode;
    }

    public TreeNode<T> rotateRR(TreeNode<T> pNode) {
        TreeNode<T> cNode = getRightSubTree(pNode); // 4

        changeRightSubTree(pNode, getLeftSubTree(cNode));   //
        changeLeftSubTree(cNode, pNode);

        return cNode;
    }

    public TreeNode<T> rotateLR(TreeNode pNode) {
        TreeNode<T> cNode = getLeftSubTree(pNode);
        changeRightSubTree(cNode, getLeftSubTree(cNode));
        return rotateLL(pNode);
    }

    public TreeNode<T> rotateRL(TreeNode pNode) {
        TreeNode<T> cNode = getRightSubTree(pNode);
        changeLeftSubTree(cNode, getRightSubTree(cNode));
        return rotateRR(pNode);
    }

    private TreeNode<T> rebalance2(TreeNode<T> pNode) {
        TreeNode<T> cNode = pNode;
        int diffHeight = getHeightDiff(pNode);
        if(diffHeight > 1) {
            cNode = getHeightDiff(getLeftSubTree(pNode)) > 0 ? rotateLL(pNode) : rotateLR(pNode);
        } else if(diffHeight < -1) {
            cNode = getHeightDiff(getRightSubTree(pNode)) < 0 ? rotateRR(pNode) : rotateRL(pNode);
        }
        return cNode;
    }
}
