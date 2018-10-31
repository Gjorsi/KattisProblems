import java.util.HashMap;
import java.util.LinkedList;

@SuppressWarnings("rawtypes") 
public class Graph<E extends Comparable<E>> {

    private HashMap<E, Vertex<E>> vertices;
    
    
    public Graph () {
        vertices = new HashMap<>();
    }
    
    public void addVertex(E label) {
        vertices.put(label, new Vertex<E>(label));
    }
    
    public void addEdge(E from, E to, int weight) {
        vertices.get(from).edges.add(new Edge(vertices.get(to), weight));
        vertices.get(to).edges.add(new Edge(vertices.get(from), weight));
    }
    
    public int getWeight(E from, E to) {
        return 0;
    }
    
    private class Vertex<E extends Comparable<E>> implements Comparable<Vertex<E>> {
        private E label;
        private LinkedList<Edge> edges;
        
        public Vertex (E label) {
            this.edges = new LinkedList<>();
        }

        @Override
        public int compareTo(Vertex<E> other) {
            return this.label.compareTo(other.label);
        }
    }
    
    private class Edge {
        private Vertex dest;
        private int weight;
        
        public Edge (Vertex destination, int weight) {
            this.dest = destination;
            this.weight = weight;
        }
        
        public Vertex getDest () {
            return this.dest;
        }
        
        public int getWeight () {
            return this.weight;
        }
    }
}
