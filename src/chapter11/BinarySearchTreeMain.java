package chapter11;

import chapter08.TreeNode;

import java.util.Comparator;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        Comparator<Integer> comp = (o1, o2) -> o1-o2;
        BinarySearchTree<Integer> bstTree = new BstTree<>(comp);

        bstTree.bstInsert(9);
        bstTree.bstInsert(1);
        bstTree.bstInsert(6);
        bstTree.bstInsert(2);
        bstTree.bstInsert(8);
        bstTree.bstInsert(3);
        bstTree.bstInsert(5);

        TreeNode<Integer> node1 = bstTree.bstSearch( 1);
        if(node1 == null) {
            System.out.println("탐색 실패");
        } else {
            System.out.printf("탐색에 성공한 키의 값 : %d \n", bstTree.bstGetData(node1));
        }


        TreeNode<Integer> node4 = bstTree.bstSearch( 4);
        if(node4 == null) {
            System.out.println("탐색 실패");
        } else {
            System.out.printf("탐색에 성공한 키의 값 : %d \n", bstTree.bstGetData(node4));
        }

        TreeNode<Integer> node6 = bstTree.bstSearch(6);
        if(node6 == null) {
            System.out.println("탐색 실패");
        } else {
            System.out.printf("탐색에 성공한 키의 값 : %d \n", bstTree.bstGetData(node6));
        }
        TreeNode<Integer> node7 = bstTree.bstSearch( 7);
        if(node7 == null) {
            System.out.println("탐색 실패");
        } else {
            System.out.printf("탐색에 성공한 키의 값 : %d \n", bstTree.bstGetData(node7));
        }
    }
}
