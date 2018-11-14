

import java.util.LinkedList;

public class Vertex<E> {
    public E id;
    public LinkedList<Edge<E>> nbrs;
    
    public Vertex(E id) {
        this.id = id;
        this.nbrs = new LinkedList<>();
    }
}
