package chpater14;

import static chpater14.Vertex.*;

public class BFSMain {
    public static void main(String[] args) {
        Graph<Vertex> graph = new ALGraphBFS<>(7);
        graph.addEdge(A, B);
        graph.addEdge(A, D);
        graph.addEdge(B, C);
        graph.addEdge(D, C);
        graph.addEdge(D, E);
        graph.addEdge(E, F);
        graph.addEdge(E, G);

        graph.showGraphEdgeInfo();
        graph.showGraphVertex(A);
        System.out.println();
        graph.showGraphVertex(C);
        System.out.println();
        graph.showGraphVertex(E);
        System.out.println();
        graph.showGraphVertex(G);
    }
}
