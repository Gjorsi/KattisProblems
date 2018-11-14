

import java.util.HashMap;

public class WeightedGraph {

    private HashMap<Integer, Vertex> vertices;
    
    public WeightedGraph(int n) {
        this.vertices = new HashMap<>();
        
        for (int i=0; i<n; i++) {
            this.vertices.put(i, new Vertex(i));
        }
    }
    
    public void addEdge(int u, int v, int weight) {
//        vertices.get(u).nbrs.add(new Edge(v,weight, false));
//        vertices.get(v).nbrs.add(new Edge(u,weight, false));
    }

    public Vertex getVertex (int x) {
        return vertices.get(x);
    }
}
