import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class ClassyProblem {

	public ClassyProblem() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		final String caseSeparator = "==============================";
		String name;
		String[] s;
		
		int nCases = io.getInt();
		
		//case
		for (int i=0; i<nCases; i++) {
			
			//set
			int n = io.getInt();
			int count = 0;
			node[] a = new node[n];
			
			for (int j=0; j<n; j++) {
				
				name = io.getWord();
				name = name.substring(0, name.length()-1);
				
				s = io.getWord().split("-");
				io.getWord();
				
//				System.out.println(Arrays.toString(s));
				
				a[count] = new node(name, getClassVal(s));
				count++;
			}
			
			Arrays.sort(a);
			for (int k=0; k<n; k++) {
				io.println(a[k].name);
			}
			
			io.println(caseSeparator);
		}
		
		io.close();
		
	}
	
	public static int getClassVal(String[] s) {
		int t = 0;
		int x = 10;
		int multiplier = (int)Math.pow(3, x);
		
		for (int k=1; k<=10; k++) {
			
			if (s.length>=k) {

				switch (s[s.length-k]) {
				case "middle": t += (multiplier/3);
					break;
				case "lower": t += 2*(multiplier/3);
					break;
				default: 
					break;
				}
			} else {
				t += multiplier/3;
			}
			multiplier = (int)Math.pow(3, --x);
		}
		
		return t;
		
	}

}

class node implements Comparable<node> {
	int val;
	String name;
	public node(String name, int val) {
		this.val = val;
		this.name = name;
	}
	
	@Override
	public int compareTo(node that) {
		
		if (this.val>that.val) {
			return 1;
		} else if (this.val == that.val) {
			return 0;
		} else if (this.val<that.val) {
			return -1;
		} else {
			return this.name.compareTo(that.name);
		}
	}
	
	
}

class Kattio extends PrintWriter {
   public Kattio(InputStream i) {
       super(new BufferedOutputStream(System.out));
       r = new BufferedReader(new InputStreamReader(i));
   }
   public Kattio(InputStream i, OutputStream o) {
       super(new BufferedOutputStream(o));
       r = new BufferedReader(new InputStreamReader(i));
   }

   public boolean hasMoreTokens() {
       return peekToken() != null;
   }

   public int getInt() {
       return Integer.parseInt(nextToken());
   }

   public double getDouble() {
       return Double.parseDouble(nextToken());
   }

   public long getLong() {
       return Long.parseLong(nextToken());
   }

   public String getWord() {
       return nextToken();
   }



   private BufferedReader r;
   private String line;
   private StringTokenizer st;
   private String token;

   private String peekToken() {
       if (token == null)
           try {
               while (st == null || !st.hasMoreTokens()) {
                   line = r.readLine();
                   if (line == null) return null;
                   st = new StringTokenizer(line);
               }
               token = st.nextToken();
           } catch (IOException e) { }
       return token;
   }

   private String nextToken() {
       String ans = peekToken();
       token = null;
       return ans;
   }
}