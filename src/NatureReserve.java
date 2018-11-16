
public class NatureReserve {

    static RedBlackBST<Integer, Long> tree;
    static WeightedGraph graph;
    static int n, m, l, s, u, v, we, sx;
    static IndexMinPQ<Long> pq;
    static Long weight;
    static int[] parent;
    
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int cases = io.getInt();
        for (int i=0; i<cases; i++) {
            
            n = io.getInt();
            m = io.getInt();
            l = io.getInt();
            s = io.getInt();
            
            tree = new RedBlackBST<>();
            graph = new WeightedGraph(n);
            pq = new IndexMinPQ<>(n);
            weight = 0L;
            parent = new int[n];
            for (int j=0; j<n; j++) {
                parent[i] = -1;
            }
            
            for (int j=0; j<s; j++) {
                sx = io.getInt()-1;
                pq.add(sx, 0L);
            }
            
            for (int j=0; j<m; j++) {
                u = io.getInt()-1;
                v = io.getInt()-1;
                we = io.getInt();
                graph.addEdge(u, v, we);
                graph.addEdge(v, u, we);
            }
            
            prims();
            
            for (int j=0; j<n; j++) {
                if (parent[i] >= 0) weight += l;
            }
            weight -= s*l;
            
            io.println(weight);
        }
        
        io.close();
        
    }

    private static void prims() {
        
        while (pq.size() > 0) {
            Long w = pq.peekKey();
            u = pq.poll();
            
            weight += w;
            tree.put(u, 0L);
            
            for (Edge<Integer> e : graph.adj(u)) {
                if (!tree.contains(e.dest)) {
                    if (!pq.contains(e.dest)) { 
                        pq.add(e.dest, (long)e.weight);
                        parent[e.dest] = u;
                    }
                    if (pq.getKey(e.dest) > e.weight) {
                        pq.changeKey(e.dest, (long)e.weight);
                        parent[e.dest] = u;
                    }
                }
            }
        }
    }
}
