package chpater14;

import chapter06.ArrayBaseStack;
import chapter06.Stack;

import java.util.Comparator;

public class ALGraphDFS<T> extends Graph<T> {
    private int[] visitInfo;

    public ALGraphDFS(int nv) {
        super(nv);
        this.visitInfo = new int[nv+1];
    }


    @Override
    public void showGraphVertex(Vertex vertex) {
        dfsShowGraphVertex(vertex);
    }
    private void dfsShowGraphVertex(Vertex startV) {
        Stack<Vertex> stack = new ArrayBaseStack<>(Vertex.class);

        Vertex visitV = startV;
        Vertex nextV = null;
        visitVertex(startV);
        stack.SPush(startV);

        while(adjList[visitV.idx].LFirst()) {
            boolean isAllVisited = true;
            nextV = adjList[visitV.idx].getData();
            if(!visitVertex(nextV)) { // 방문하지 않았다면
                isAllVisited = false;
                stack.SPush(visitV);
                visitV = nextV;
            } else {
                while(adjList[visitV.idx].LNext()) {
                    nextV = adjList[visitV.idx].getData();
                    if(!visitVertex(nextV)) {
                        isAllVisited = false;
                        stack.SPush(visitV);
                        visitV = nextV;
                        break;
                    }
                }
            }

            if(isAllVisited) {
                if(!stack.SisEmpty()) {
                    visitV = stack.SPop();
                } else {
                    break;
                }
            }
        }
        this.visitInfo = new int[this.numV + 1];
    }

    public boolean visitVertex(Vertex vertex) {
        if(this.visitInfo[vertex.idx] == 0) {
            this.visitInfo[vertex.idx] = 1;
            System.out.printf("%s ", vertex.name());
            return false;
        }
        return true;
    }
}
