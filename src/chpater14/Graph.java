package chpater14;

import chapter04.DLinkedList;

import java.util.Comparator;

import static chpater14.Vertex.findByIdx;
import static java.util.Arrays.stream;

public abstract class Graph<T> {
    protected int numV;
    protected int numE;
    protected DLinkedList<Vertex>[] adjList;

    /**
     *  - 그래프의 초기화를 진행한다.
     *  - 인자로 정점의 수를 전달한다.
     * */
    public Graph(int nv) {
        this.adjList = new DLinkedList[nv + 1];
        this.numV = nv;
        this.numE = 0;
        for(int i = 0; i < adjList.length; i++) {
            Comparator<Vertex> comp = (o1, o2) -> o1.idx-o2.idx;
            adjList[i] = new DLinkedList<>();
            adjList[i].SetSortRule(comp);
        }
    }

    /**
     *  - 매개변수 fromV와 toV로 전달된 정점을 연결하는 간선을 그래프에 추가한다.
     * */
    public void addEdge(Vertex fromV, Vertex toV) {
        this.adjList[toV.idx].LInsert(fromV);
        this.adjList[fromV.idx].LInsert(toV);
        this.numE++;
    }


    /**
     *  - 그래프의 간선 정보를 출력한다.
     * */
    public void showGraphEdgeInfo(){
        for(int i = 0; i < this.numV; i++) {
            Vertex vertex = findByIdx(i);
            System.out.printf("%s와 연결된 정점 : ", vertex.name());
            if(this.adjList[i].LFirst()) {
                System.out.printf("%s ", adjList[i].getData());
                while(this.adjList[i].LNext()) {
                    System.out.printf("%s ", adjList[i].getData());
                }
            }
            System.out.println();
        }
    }

    protected abstract void showGraphVertex(Vertex visitV);
}
