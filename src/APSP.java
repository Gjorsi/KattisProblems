
public class APSP {
    
    static Long[][] adjM;
    static Long INF = (Long.MAX_VALUE/4);
    static int n,m,q,u,v;
    static long x;
    static Long[][][] sP;
    static Kattio io;
    
    public static void main(String[] args) {
        
        io = new Kattio(System.in, System.out);
        
        while (true) {
            n = io.getInt();
            m = io.getInt();
            q = io.getInt();
            if (n == 0 && m == 0 && q == 0) break;
            
            adjM = new Long[n][n];
            
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    adjM[i][j] = INF;
                }
            }
            
            for (int i=0; i<m; i++) {
                adjM[io.getInt()][io.getInt()] = io.getLong();
            }
            
            for (int i=0; i<n; i++) {
                if (adjM[i][i] < INF && adjM[i][i] > 0)
                    adjM[i][i] = 0L;
            }
            
            sP = new Long[n+1][n][n];
            sP[0] = adjM;
            
            floydWarshall();
            
            for (int i=0; i<q; i++) {
                x = adjM[io.getInt()][io.getInt()];
                if (x == INF) io.println("Impossible");
                else if (x == -INF) io.println("-Infinity");
                else io.println(x);
            }
            
            io.println();
        }
        
        io.close();
        
    }

    private static void floydWarshall() {
        for (int k=1; k<=n; k++) {
            for (int s=0; s<n; s++) {
                for (int t=0; t<n; t++) {
                    if (sP[k-1][s][k-1] == INF || sP[k-1][k-1][t] == INF) sP[k][s][t] = sP[k-1][s][t];
                    else sP[k][s][t] = Math.min(sP[k-1][s][k-1] + sP[k-1][k-1][t], sP[k-1][s][t]);
                }
            }
        }
        
        adjM = sP[n];
        
        for (int y=0; y<n; y++) {
            if (adjM[y][y] < 0) {
                adjM[y][y]= INF*-1;
                for (int s=0; s<n; s++) {
                    for (int t=0; t<n; t++) {
                        if (adjM[s][y] < INF && adjM[y][t] < INF)
                            adjM[s][t] = INF*-1;
                    }
                }
            }
        }
    }
}
