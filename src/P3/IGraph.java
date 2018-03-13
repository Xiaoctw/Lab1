package com.company;

public interface IGraph<E> {
    boolean addVertex(E v);
    boolean addEdge(E v1,E v2);
    int getDistance(E v1,E v2);
    String depthFirstSearch(E v);
    String breadFirstSearch(E v);
}
