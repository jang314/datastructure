package chpater14;

import java.util.Arrays;

public enum Vertex {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6),
    H(7),
    I(8),
    J(9);

    int idx;

    Vertex(int idx) {
        this.idx = idx;
    }

    public static Vertex findByIdx(int findIdx){
        return Arrays.stream(Vertex.values()).filter(vertex -> vertex.idx == findIdx)
                .findAny().orElseThrow(() -> new IllegalStateException());
    }
}
