
public class CountingStars {

    static char[][] arr;
    static boolean[][] vis;
    static int h, w, nStars, caseN = 1;
    static final char star = '-', sky = '#';
    
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        while (io.hasMoreTokens()) {
            h = io.getInt();
            w = io.getInt();
            nStars = 0;
            
            arr = new char[h][w];
            vis = new boolean[h][w];
            
            for (int i=0; i<h; i++) {
                arr[i] = io.getWord().toCharArray();
            }
            
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (arr[i][j] == star && !vis[i][j]) {
                        bfs(i, j);
                        nStars++;
                    }
                }
            }
            
            io.println("Case " + caseN++ + ": " + nStars);
        }
        
        io.close();
    }

    private static void bfs(int i, int j) {
        vis[i][j] = true;
        if (i>0 && arr[i-1][j] == star && !vis[i-1][j]) bfs(i-1, j);
        if (j>0 && arr[i][j-1] == star && !vis[i][j-1]) bfs(i, j-1);
        if (i<h-1 && arr[i+1][j] == star && !vis[i+1][j]) bfs(i+1, j);
        if (j<w-1 && arr[i][j+1] == star && !vis[i][j+1]) bfs(i, j+1);
    }
}
