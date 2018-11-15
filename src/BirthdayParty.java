
public class BirthdayParty {

    static UndirectedGraph<Integer> graph;
    
    public static void main(String[] args) {
        
        graph = new UndirectedGraph<>();
        Kattio io = new Kattio(System.in, System.out);

        int p, c, u, v;
        
        while (true) {
            p = io.getInt();
            c = io.getInt();
            
            if (p == 0 && c == 0) break;
            
            if (c == 0) {
                io.println("no");
                continue;
            }
            
            for (int i=0; i<c; i++) {
                u = io.getInt();
                v = io.getInt();
                if (!graph.contains(u)) graph.addVertex(u);
                if (!graph.contains(v)) graph.addVertex(v);
                
                graph.addEdge(u, v);
            }
            
            boolean yes = false;
            
            
            if (yes) io.println("yes");
            else io.println("no");
        }
        
        io.close();
    }
    
    

}
