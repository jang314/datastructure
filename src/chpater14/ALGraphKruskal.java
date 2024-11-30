package chpater14;

import chapter06.ArrayBaseStack;
import chapter06.Stack;
import chapter09.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ALGraphKruskal<T> extends Graph<T> {
    private PriorityQueue<Edge> pQueue;
    private boolean[] visitInfo;

    public ALGraphKruskal(int nv, Comparator<Edge> comp) {
        super(nv);
        pQueue = new PriorityQueue<>(comp);
        this.visitInfo = new boolean[this.numV];
    }

    public void addEdge(Vertex fromV, Vertex toV, int weight) {
        super.addEdge(fromV, toV);
        pQueue.add(new Edge(fromV, toV, weight));
    }

    public void conKruskalMST() {
        Edge[] edges = new Edge[20]; // 복원할 간선 정보 저장
        Edge edge = null;
        int eidx = 0;

        while(this.numE + 1 != this.numV) {
            edge = pQueue.poll();
            removeEdge(edge);

            if(!isConnVertex(edge)) {
                recoverEdge(edge);
                edges[eidx++] = edge;
            }
        }

        for(int i = 0; i<eidx; i++) {
            pQueue.add(edges[i]);
        }
    }

    public void removeEdge(Edge edge) {
        Vertex fromV = edge.getV1();
        Vertex toV = edge.getV2();

        removeWayEdge(fromV, toV);
        removeWayEdge(toV, fromV);

        this.numE--;
    }

    private void removeWayEdge(Vertex fromV, Vertex toV) {
        if(this.adjList[fromV.idx].LFirst()) {
            if(this.adjList[fromV.idx].getData().equals(toV)) {
                this.adjList[fromV.idx].LRemove();
                return;
            }
            while(this.adjList[fromV.idx].LNext()) {
                if(this.adjList[fromV.idx].getData().equals(toV)) {
                    this.adjList[fromV.idx].LRemove();
                    return;
                }
            }
        }
    }

    public boolean isConnVertex(Edge edge) {
        Stack<Vertex> stack = new ArrayBaseStack<>(Vertex.class);

        Vertex visitV = edge.getV1();
        Vertex nextV = null;
        visitVertex(edge.getV1());
        stack.SPush(edge.getV1());

        while(adjList[visitV.idx].LFirst()) {
            boolean isAllVisited = true;
            nextV = adjList[visitV.idx].getData();
            if(edge.getV2().equals(nextV)) {
                this.visitInfo = new boolean[this.numV + 1];
                return true;
            }

            if(!visitVertex(nextV)) {
                isAllVisited = false;
                stack.SPush(visitV);
                visitV = nextV;
            } else {
                while(adjList[visitV.idx].LNext()) {
                    nextV = adjList[visitV.idx].getData();
                    if(edge.getV2().equals(nextV)) {
                        this.visitInfo = new boolean[this.numV + 1];
                        return true;
                    }
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
        this.visitInfo = new boolean[this.numV + 1];
        return false;
    }

    public void recoverEdge(Edge edge) {
        Vertex fromV = edge.getV1();
        Vertex toV = edge.getV2();
        this.adjList[fromV.idx].LInsert(toV);
        this.adjList[toV.idx].LInsert(fromV);
        this.numE++;
    }

    @Override
    protected void showGraphVertex(Vertex visitV) {

    }
    public boolean visitVertex(Vertex vertex) {
        if(!this.visitInfo[vertex.idx]) {
            this.visitInfo[vertex.idx] = true;
//            System.out.printf("%s ", vertex.name());
            return false;
        }
        return true;
    }

    public void showGraphEdgeWeightInfo() {
        PriorityQueue<Edge> copyQueue = this.pQueue;
        while(!copyQueue.isEmpty()) {
            Edge edge = copyQueue.poll();
            System.out.printf("(%s-%s), w: %d \n", edge.getV1(), edge.getV2(), edge.getWeight());
        }
    }
}
