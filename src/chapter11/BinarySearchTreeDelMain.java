package chapter11;

import chapter08.Tree;

public class BinarySearchTreeDelMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bstTree = new BstTree<Integer>((o1, o2) -> o1-o2);

        bstTree.bstInsert(5);
        bstTree.bstInsert(8);
        bstTree.bstInsert(1);
        bstTree.bstInsert(6);
        bstTree.bstInsert(4);
        bstTree.bstInsert(9);
        bstTree.bstInsert(3);
        bstTree.bstInsert(2);
        bstTree.bstInsert(7);

        bstTree.bstShowAll();
        System.out.println();

        bstTree.bseRemove(3);
        bstTree.bstShowAll();
        System.out.println();

        bstTree.bseRemove(8);
        bstTree.bstShowAll();
        System.out.println();

        bstTree.bseRemove(1);
        bstTree.bstShowAll();
        System.out.println();

        bstTree.bseRemove(6);
        bstTree.bstShowAll();
        System.out.println();



    }
}
