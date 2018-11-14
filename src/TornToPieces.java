import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class TornToPieces {
    
    static UndirectedGraph<String> graph;
    static HashMap<String, String> parent;
    static HashSet<String> visited;
    static String target;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Kattio io = new Kattio(System.in, System.out);

        int n = Integer.parseInt(br.readLine());
        
        graph = new UndirectedGraph<>();
        
        
        for (int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            if (!graph.contains(s[0])) graph.addVertex(s[0]);
            
            for (int j=1; j<s.length; j++) {
                if (!graph.contains(s[j])) graph.addVertex(s[j]);
                if (!graph.areAdj(s[0], s[j])) graph.addEdge(s[0], s[j]);
            }
        }
        
        String[] s = br.readLine().split(" ");
        
        parent = new HashMap<>();
        visited = new HashSet<>();
        target = s[1];
        dfs(s[0]);
        boolean valid = false;
        Stack<String> stack = new Stack<>();
        String c = target;
        while (parent.containsKey(c)) {
            stack.push(c);
            c = parent.get(c);
            if (c == s[0]) {
                valid = true;
                break;
            }
        }
        
        stack.push(c);
        int size = stack.size();
        
        if (valid) {
            for (int i=0; i<size; i++) {
                io.print(stack.pop());
                io.print(" ");
            }
        } else {
            io.println("no route found");
        }
        
        br.close();
        io.close();
        
    }

    private static boolean dfs(String u) {
        if (u == target) return true;
        visited.add(u);
        
        for(Edge<String> nbr : graph.adj(u)) {
            
            if (!visited.contains(nbr.dest)) {
                parent.put(nbr.dest, u);
                if (dfs(nbr.dest)) return true;
            }
        }
        
        return false;
    }

}
