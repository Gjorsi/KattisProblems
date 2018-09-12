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
		String name = "";
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
		int x = 9;
		int multiplier = (int)Math.pow(3, x);
		
		for (int k=1; k<=10; k++) {
			
			if (s.length>=k) {

				switch (s[s.length-k]) {
				case "middle": t += (multiplier);
					break;
				case "lower": t += 2*(multiplier);
					break;
				default: 
					break;
				}
			} else {
				t += (multiplier);
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
		} else if (this.val < that.val) {
			return -1;
		} else {
			return this.name.compareToIgnoreCase(that.name);
		}
	}
	
	
}
