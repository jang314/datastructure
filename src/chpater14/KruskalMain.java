package chpater14;

import static chpater14.Vertex.*;

public class KruskalMain {
    public static void main(String[] args) {
        ALGraphKruskal<Vertex> graph = new ALGraphKruskal<>(6, ((o1, o2) -> o2.getWeight()-o1.getWeight()));
        graph.addEdge(A, B, 9);
        graph.addEdge(B, C, 2);
        graph.addEdge(A, C, 12);
        graph.addEdge(A, D, 8);
        graph.addEdge(D, C, 6);
        graph.addEdge(A, F, 11);
        graph.addEdge(F, D, 14);
        graph.addEdge(D, E, 3);
        graph.addEdge(E, C, 7);
        graph.addEdge(F, E, 13);

        graph.conKruskalMST();
        graph.showGraphEdgeInfo();
        graph.showGraphEdgeWeightInfo();



    }
}
