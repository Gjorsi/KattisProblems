

import java.util.HashMap;

public class WeightedGraph {

    private HashMap<Integer, Vertex<Integer>> vertices;
    
    public WeightedGraph(int n) {
        this.vertices = new HashMap<>();
        
        for (int i=0; i<n; i++) {
            this.vertices.put(i, new Vertex<Integer>(i));
        }
    }
    
    public void addEdge(int u, int v, int weight) {
        vertices.get(u).nbrs.add(new Edge<Integer>(v,weight));
        vertices.get(v).nbrs.add(new Edge<Integer>(u,weight));
    }

    public Vertex<Integer> getVertex (int x) {
        return vertices.get(x);
    }
    
    public int size() {
        return vertices.size();
    }
    
    public Iterable<Edge<Integer>> adj(int u) {
        return vertices.get(u).nbrs;
    }
}
