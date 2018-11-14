import java.util.HashMap;

public class AMazing {
    
    public static void main(String[] args) {
        
        Kattio io = new Kattio(System.in, System.out);

        String up = "up", left = "left", right = "right", down = "down", solved = "solved", wall = "wall", ok = "ok";
        HashMap<Integer, String> directions = new HashMap<>();
        directions.put(0, up);
        directions.put(1, right);
        directions.put(2, down);
        directions.put(3, left);
        
        io.println(up);
        io.flush();
        Node cN = new Node();
        
        String c = io.getWord();
        int cGuess = 0;
        
        while (c != solved) {
            if (c == wall) {
                cN.addWall(cGuess);
                cGuess = (cGuess++ % 4);
                io.println(directions.get(cGuess));
            } else if (c == ok) {
                cN.nbrs[cGuess] = new Node(cN, (cGuess+2)%4);
                cN = cN.nbrs[cGuess];
            }
            io.flush();
            c = io.getWord();
        }
        
        io.close();
    }
    
    private static class Node {
        Node[] nbrs = new Node[4];
        boolean[] walls = new boolean[4];
        
        public Node() {
        }
        
        public Node(Node source, int sourceDirection) {
            nbrs[sourceDirection] = source;
        }
        
        public void addWall (int dir) {
            walls[dir] = true;
        }
    }
}
