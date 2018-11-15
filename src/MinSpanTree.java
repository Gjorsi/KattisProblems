
public class MinSpanTree {

    static RedBlackBST<Integer, Integer> tree;
    static WeightedGraph graph;
    static Long weight = 0L;
    static int n,m,u;
    static IndexMinPQ<Long> pq;
    
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while (true) {
            
            n = io.getInt();
            m = io.getInt();
            if (n == 0 && m == 0) break;
            weight = 0L;
            graph = new WeightedGraph(n);
            tree = new RedBlackBST<>();
            
            for (int i=0; i<m; i++) {
                graph.addEdge(io.getInt(), io.getInt(), io.getInt());
            }
            
            prims();
            
            if (tree.size() < n) {
                io.println("Impossible");
            } else {
                io.println(weight);
            }
            
        }
        
        io.close();
    }

    private static void prims() {
        pq = new IndexMinPQ<>(n);
//        for (int i=0; i<n; i++) {
//            pq.add(i, Long.MAX_VALUE/2);
//        }
        
//        pq.changeKey(0, 0L);
        
        pq.add(0, 0L);
        
        while (pq.size() > 0) {
            Long w = pq.peekKey();
            u = pq.poll();
            
            weight += w;
            tree.put(u, 0);
            
            for (Edge<Integer> e : graph.adj(u)) {
                if (!tree.contains(e.dest)) {
                    if (!pq.contains(e.dest)) pq.add(e.dest, (long)e.weight);
                    if (pq.getKey(e.dest) > e.weight) {
                        pq.changeKey(e.dest, (long)e.weight);
                    }
                }
            }
        }
    }

}
