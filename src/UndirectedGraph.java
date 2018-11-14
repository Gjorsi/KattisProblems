

import java.util.HashMap;

public class UndirectedGraph<E> {

    private HashMap<E, Vertex<E>> vertices;
    
    public UndirectedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(E id) {
        vertices.put(id, new Vertex<E>(id));
    }
    
    public void addEdge(E u, E v) {
        vertices.get(u).nbrs.add(new Edge<E>(v, 0));
        vertices.get(v).nbrs.add(new Edge<E>(u, 0));
    }

    public int getSize() {
        return vertices.size();
    }

    public boolean areAdj(E u, E v) {
        for (Edge<E> neighbour : vertices.get(u).nbrs) {
            if (neighbour.dest == v) return true;
        }
        return false;
    }

    public Iterable<Edge<E>> adj(E u) {
        return vertices.get(u).nbrs;
    }
    
    public boolean contains(E key) {
        return (vertices.containsKey(key));
    }
    
    public int nEdges (E u) {
        if (!vertices.containsKey(u)) return 0;
        return vertices.get(u).nbrs.size();
    }

}
