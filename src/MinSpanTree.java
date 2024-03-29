
public class MinSpanTree {

    static RedBlackBST<Integer, Integer> tree;
    static WeightedGraph graph;
    static Long weight = 0L;
    static int n,m,u;
    static IndexMinPQ<Long> pq;
    static int[] parent;
    
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        while (true) {
            
            n = io.getInt();
            m = io.getInt();
            if (n == 0 && m == 0) break;
            weight = 0L;
            graph = new WeightedGraph(n);
            tree = new RedBlackBST<>();
            parent = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = -1;
            }
            
            for (int i=0; i<m; i++) {
                graph.addEdge(io.getInt(), io.getInt(), io.getInt());
            }
            
            prims();
            
            if (tree.size() < n) {
                io.println("Impossible");
            } else {
                io.println(weight);
                IndexMinPQ<Integer> parentPQ = new IndexMinPQ<>(n);
                for (int i=1; i<n; i++) {
                    parentPQ.add(i, parent[i]);
                }
                for (int i=0; i<n-1; i++) {
                    io.println(parentPQ.peekKey() + " " + parentPQ.poll());
                }
            }
        }
        
        io.close();
    }

    private static void prims() {
        pq = new IndexMinPQ<>(n);
        pq.add(0, 0L);
        
        while (pq.size() > 0) {
            Long w = pq.peekKey();
            u = pq.poll();
            
            weight += w;
            tree.put(u, 0);
            
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
