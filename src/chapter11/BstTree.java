package chapter11;

import chapter08.BinaryTreeTraverse;
import chapter08.Tree;
import chapter08.TreeNode;
import chapter12.AVLRebalance;

import java.awt.print.Pageable;
import java.util.Comparator;
public class BstTree<T> extends BinarySearchTree<T> {


    public BstTree(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    @Override
    public void bstInsert(T data) {
        TreeNode<T> parNode = null;
        TreeNode<T> newNode = new TreeNode<>(data);
        TreeNode<T> curNode = this.root;

        while(curNode != null) {
            if(curNode == newNode.getData()) {
                return ;
            }

            parNode = curNode;

            if(comparator.compare(curNode.getData(), newNode.getData()) > 0) {
                curNode = getLeftSubTree(curNode);
            } else {
                curNode = getRightSubTree(curNode);
            }
        }

        if(parNode == null) {
            this.root = newNode ;
        } else {
            if(comparator.compare(parNode.getData(), newNode.getData()) > 0) {
                makeLeftSubTree(parNode, newNode);
            } else {
                makeRightSubTree(parNode,newNode);
            }
        }
    }

    @Override
    public T bstGetData(TreeNode<T> btree) {
        return (T) getData(btree);
    }

    @Override
    public TreeNode<T> bstSearch(T target) {
        TreeNode<T> curNode = this.root;

        while(curNode!=null) {
            if(curNode.getData() == target) {
                return curNode;
            } else if(comparator.compare(curNode.getData(), target) > 0) {
                curNode = getLeftSubTree(curNode);
            } else {
                curNode = getRightSubTree(curNode);
            }
        }
        return null; // 탐색 대상이 저장되어 있지 않음.
    }

    @Override
    protected TreeNode<T> bseRemove(T target) {
        TreeNode<T> vRoot = new TreeNode<>(null);
        TreeNode<T> delNode = null;
        TreeNode<T> parNode = null;
        TreeNode<T> curNode = root;

        // 루트 노드 삭제 고려
        makeRightSubTree(vRoot, this.root);

        // 삭제 노드 탐색
        while(curNode != null && curNode.getData() != target) {
              parNode = curNode;
              if(comparator.compare(curNode.getData(), target) > 0) {
                  curNode = getLeftSubTree(curNode);
              } else {
                  curNode = getRightSubTree(curNode);
              }
        }

        if(curNode == null) {
            return null;
        }

        delNode = curNode;

        // 1. 삭제 노드가 단말 노드일 때
        if(getLeftSubTree(delNode) == null && getRightSubTree(delNode) == null) {
            if(getLeftSubTree(parNode).getData().equals(target)) {
                removeLeftSubTree(parNode);
            } else {
                removeRightSubTree(parNode);
            }
        }
        // 2. 삭제 노드의 자식 노드가 하나일 때
        else if(getLeftSubTree(delNode) == null || getRightSubTree(delNode) == null) {
            TreeNode<T> cNode = getLeftSubTree(delNode) == null ? getRightSubTree(delNode) : getLeftSubTree(delNode);

            if(getRightSubTree(parNode) != null && getLeftSubTree(parNode) != null) {
                if(getLeftSubTree(parNode).getData().equals(delNode.getData())) {
                    changeLeftSubTree(parNode, cNode);
                } else {
                    changeLeftSubTree(parNode, cNode);
                }
            } else {
                if(getLeftSubTree(parNode) == null) {
                    changeRightSubTree(parNode, cNode);
                } else {
                    changeLeftSubTree(parNode, cNode);
                }
            }
        }
        // 3. 삭제 노드의 자식 노드가 두개일 때
        else {
            TreeNode<T> fNode = getRightSubTree(delNode);
            TreeNode<T> pfNode = delNode;
//          1. 탐색
            while(getLeftSubTree(fNode) != null) {
                pfNode = fNode;
                fNode = getLeftSubTree(fNode);
            }

            // 2. 대입
            delNode.setData(fNode.getData());

            if(getLeftSubTree(pfNode).getData().equals(fNode.getData())) {
                changeLeftSubTree(pfNode, getRightSubTree(fNode));
            } else {
                changeRightSubTree(pfNode, getRightSubTree(fNode));
            }

            // 삭제 대상이 루트라면
            if(!getRightSubTree(vRoot).getData().equals(this.root.getData())) {
                this.root = getRightSubTree(vRoot);
            }
        }
        return new TreeNode<>(target);
    }
//    @Override
    protected TreeNode<T> bseRemove3(T target) {
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
    public void bstShowAll() {
        inorderTraverse(this.root, (data) -> System.out.printf("%d ", data));
    }

    public TreeNode<T> getRoot() {
        return this.root;
    }

    public Comparator<T> getComparator() {
        return  this.comparator;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }



}
