package chpater14;

import chapter07.ListQueue;
import chapter07.Queue;

public class ALGraphBFS<T> extends Graph<T> {
    private boolean[] visitInfo;
    public ALGraphBFS(int nv) {
        super(nv);
        visitInfo = new boolean[nv+1];
    }

    @Override
    public void showGraphVertex(Vertex visitV) {
        bfsShowGraphVertex(visitV);
    }

    private void bfsShowGraphVertex(Vertex startV) {
        Queue<Vertex> queue = new ListQueue();
        Vertex visitV = startV;
        Vertex nextV = null;

        visitVertex(visitV);

        while(adjList[visitV.idx].LFirst()) {
            nextV = adjList[visitV.idx].getData();
            if(!visitVertex(nextV)) {
                queue.enqueue(adjList[visitV.idx].getData());
            }
            while(adjList[visitV.idx].LNext()) {
                nextV = adjList[visitV.idx].getData();
                if(!visitVertex(nextV)) {
                    queue.enqueue(adjList[visitV.idx].getData());
                }
            }

            if(!queue.qIsEmpty()) {
                visitV = queue.dequeue();
            }else {
                this.visitInfo = new boolean[this.numV];
                break;
            }
        }
    }

    public boolean visitVertex(Vertex vertex) {
        if(!this.visitInfo[vertex.idx]) {
            this.visitInfo[vertex.idx] = true;
            System.out.printf("%s ", vertex.name());
            return false;
        }
        return true;
    }
}
