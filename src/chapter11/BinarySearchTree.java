package chapter11;

import chapter08.BinaryTree;
import chapter08.Tree;
import chapter08.TreeNode;

import java.util.Comparator;

public abstract class BinarySearchTree<T> extends Tree {
    private T bstData;
    protected abstract T bstGetData(TreeNode<T> btree);   // 노드에 저장된 데이터를 반환한다.
    protected abstract void bstInsert(T data);           // BST대상으로 데이터 저장 (노드의 생서과정 포함)
    protected abstract TreeNode<T> bstSearch(T bstData);  // BST대상으로 데이터탐색
    protected abstract TreeNode<T> bseRemove(T bstData);    // 트리에서 노드ㅡㄹ 제거하고 제거든 노드를 반환
    protected abstract void bstShowAll();   // 이진 탐색 틀에 저장된 모든 노드의 데이터를 출력

}
