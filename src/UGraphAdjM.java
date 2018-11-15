
public class UGraphAdjM {

    private boolean[][] adjMatrix;
    private int size;
    
    public UGraphAdjM(int n) {
        this.size = n;
        this.adjMatrix = new boolean[n][n];
    }
    
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = true;
    }

    public int getSize() {
        return size;
    }

    public boolean areAdj(int u, int v) {
        return adjMatrix[u][v];
    }
}
