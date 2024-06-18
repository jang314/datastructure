package chapter11;

import chapter08.TreeNode;

import java.util.Comparator;

public class BstTree<T> extends BinarySearchTree<T> {
    private TreeNode<T> root;
    private Comparator<T> comparator ;

    public BstTree(Comparator<T> comparator) {
        this.root = new TreeNode<>(null);
        this.comparator = comparator;
    }

    @Override
    protected T bstGetData(TreeNode<T> btree) {
        return (T) getData(btree);
    }

    @Override
    protected void bstInsert(T data) {
        if(root.getData() == null) {
            root.setData(new TreeNode<>(data));
            return;
        }
        TreeNode<T> pNode = null; // parentNode
        TreeNode<T> cNode = root; // currentNode
        TreeNode<T> nNode = null; // newNode


        while(cNode != null) {
            if(cNode.getData() == data) {
                return;
            }

            pNode = cNode;

            if(comparator.compare(cNode.getData(), data) > 0) {
                cNode = getLeftSubTree(cNode);
            } else {
                cNode = getRightSubTree(cNode);
            }
        }

        // pNode의 자식 노드로 추가할 때 새노드의 생성
        nNode = makeBTreeNode(data);

        // pNode의 자식 노드로 새 노드를 추가
        if(pNode != null) {
            if(comparator.compare(pNode.getData(), data) > 0) {
                makeLeftSubTree(pNode, nNode);
            } else {
                makeRightSubTree(pNode, nNode);
            }
        }
    }

    @Override
    protected TreeNode<T> bstSearch( T target) {
        TreeNode<T> cNode = this.root;
        T cd = null;
        while(cNode != null) {
            cd = cNode.getData();
            if(target == cd) {
                return cNode;
            } else if(comparator.compare(cd, target) > 0) {
                cNode = getLeftSubTree(cNode);
            } else {
                cNode = getRightSubTree(cNode);
            }
        }
        return null; // 탐색 대상이 저장되어 있지 않음.
    }

    @Override
    protected TreeNode<T> bseRemove(T target) {
        //삭제 대상이 루ㅡ 노드인 경우ㅡㄹ 별도로 고려해야함
        TreeNode<T> pVroot = makeBTreeNode(null); // 가상 뤁트 노드
        TreeNode<T> pNode = pVroot ; //parentNode
        TreeNode<T> cNode = this.root;
        TreeNode<T> dNode; // delNode;

        // 루트 노드를 pVroot가 가리키는 노드의 오른쪽 자식 노드가 되게한다.
        changeRightSubTree(pVroot, this.root);

        // 삭제 대상인노드 ㅊ탐색
        while (cNode != null && getData(cNode) != target) {
            pNode = cNode;
            if(comparator.compare(cNode.getData(), target) > 0) {
                cNode = getLeftSubTree(cNode);
            } else {
                cNode = getRightSubTree(cNode);
            }
        }
        // 삭제 대상이 존재하지 않으면
        if(cNode == null) {
            return null;
        }

        dNode = cNode; // 삭제 대상을 dNode가 가리키게 한다.

        // 첫번째경우 : 삭제 대상이 단말 노드인 경우
        if(getLeftSubTree(dNode) == null && getRightSubTree(dNode)==null) {
            if(getLeftSubTree(pNode)== dNode) {
                removeLeftSubTree(pNode);
            } else {
                removeRightSubTree(pNode);
            }
            // 삭제 대상이 하나의 자식 노드를 갖는 경우
        } else if(getLeftSubTree(dNode) == null || getRightSubTree(dNode) == null) {
            TreeNode<T> dcNode = null; // 삭제 대상의 자식 노드를 가리킴
            if(getLeftSubTree(dNode) != null) {
                dcNode = getLeftSubTree(dNode);
            } else {
                dcNode = getRightSubTree(dNode);
            }

            if(getLeftSubTree(pNode) == dNode) {
                changeLeftSubTree(pNode, dcNode);
            } else {
                changeRightSubTree(pNode, dcNode);
            }
        } else { //세번째 경우 : 두개의 자식 노드를 모두 갖는 경우
            TreeNode<T> mNode = getRightSubTree(dNode); // 대체 노드를 가리킴
            TreeNode<T> mpNode = dNode;
            T delData;

            // 삭제 대상의 대체 노드를 찾는다.
            while(getLeftSubTree(mNode) != null) {
                mpNode = mNode;
                mNode = getLeftSubTree(mNode);
            }

            // 대체 노드에 저장된 값을 삭제할 노드에 대입한다.
            delData = dNode.getData();
            dNode.setData(mNode.getData());

            if(getLeftSubTree(mpNode) == mNode) {
                changeLeftSubTree(mpNode, getRightSubTree(mNode));
            } else {
                changeRightSubTree(mpNode, getRightSubTree(mNode));
            }

            dNode = mNode;
            dNode.setData(delData);
            return dNode;
        }

        return null;
    }

    @Override
    protected void bstShowAll() {

    }


}
