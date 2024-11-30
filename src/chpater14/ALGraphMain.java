package chpater14;

import static chpater14.Vertex.*;

public class ALGraphMain {
    public static void main(String[] args) {
        Graph<Integer> graph = new ALGraph(5);

        graph.addEdge(A, B);
        graph.addEdge(A, D);
        graph.addEdge(B, C);
        graph.addEdge(C, D);
        graph.addEdge(D, E);
        graph.addEdge(E, A);

        graph.showGraphEdgeInfo();
    }
}
