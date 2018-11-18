
public class DistinctiveCharacter {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(), k = io.getInt();
        StringBuilder sb = new StringBuilder();
        int t = 0;
        
        char[][] grid = new char[n][k];
        
        for (int i=0; i<n; i++) {
            grid[i] = io.getWord().toCharArray();
        }
        
        for (int j=0; j<k; j++) {
            t = 0;
            for (int i=0; i<n; i++) {
                t+=Character.getNumericValue(grid[i][j]);
            }
            double x = (double)t/n;
            if (x < 0.5) sb.append("1");
            else sb.append("0");
        }
        
        io.println(sb.toString());
        
        io.close();
    }

}
