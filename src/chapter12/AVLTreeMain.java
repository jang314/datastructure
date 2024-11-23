package chapter12;

import chapter08.TreeNode;
import chapter11.BstTree;
import common.VisitFuncPtr;

import java.util.Arrays;
import java.util.Optional;
import java.util.TreeMap;

public class AVLTreeMain {
    public static void main(String[] args) {
        BstTree<Integer> tree = new AVLRebalance<>((o1, o2) -> o1-o2);
        TreeNode<Integer> root = null;

        tree.bstInsert(1);
        root = tree.getRoot();
        showData(root);

        System.out.println("==============================");

        tree.bstInsert(2);
        root = tree.getRoot();
        showData(root);

        System.out.println("==============================");
//
        tree.bstInsert(3);
        root = tree.getRoot();
        showData(root);

        System.out.println("==============================");

        tree.bstInsert(4);
        root = tree.bstSearch(3);
        showData(root);

        System.out.println("==============================");

        tree.bstInsert(5);
        root = tree.bstSearch(4);
        showData(root);

        System.out.println("==============================");

        tree.bstInsert(6);
        root = tree.bstSearch(5);
        showData(root);
        root = tree.bstSearch(3);
        showData(root);
        root = tree.bstSearch(2);
        showData(root);
    }



    private static void showData(TreeNode<Integer> root) {
        Integer left = Optional.ofNullable(root.getLeft()).map(l -> l.getData()).orElseGet(() -> -1);
        Integer right = Optional.ofNullable(root.getRight()).map(r -> r.getData()).orElseGet(() -> -1);

        System.out.printf("\t\t root = %d \n", root.getData());
        System.out.print(" left = " + ((left > -1) ? left + "\t" : "존재X \t"));
        System.out.print(" right = " + ((right > -1) ? right + "\t" : "존재X \t "));
        System.out.println();
    }

}
