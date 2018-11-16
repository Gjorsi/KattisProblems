
public class SingleSourceSP {

    static int n,m,q,s, cur;
    static WeightedGraph graph;
    static int[] dist;
    
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        while (true) {
            n = io.getInt();
            m = io.getInt();
            q = io.getInt();
            s = io.getInt();
            if (n == 0 && m == 0 && q == 0 && s == 0) {
                break;
            }
            
            graph = new WeightedGraph(n);
            
            for (int i=0; i<m; i++) {
                graph.addEdge(io.getInt(), io.getInt(), io.getInt());
            }
            
            for (int i=0; i<q; i++) {
                int query = io.getInt();
                dijkstra(query);
                if (dist[query] < Integer.MAX_VALUE/2) io.println(dist[query]);
                else io.println("Impossible");
            }
            
        }
        
        io.close();
    }

    private static void dijkstra(int target) {
        IndexMinPQ<Integer> pq = new IndexMinPQ<>(n);
        pq.add(s, 0);
        
        dist = new int[n];
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            dist[i] = Integer.MAX_VALUE/2;
        }
        dist[s] = 0;
        
        while (!pq.isEmpty()) {
            cur = pq.poll();
            if (cur == target) return;
            visited[cur] = true;
            
            for (Edge<Integer> e : graph.adj(cur)) {
                if (!visited[e.dest] && dist[cur] + e.weight < dist[e.dest]) {
                    dist[e.dest] = dist[cur] + e.weight;
                    pq.add(e.dest, dist[e.dest]);
                }
                
            }
        }
    }

}
