import java.util.HashSet;

public class Blinkenlights {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int p = io.getInt();
		int q = io.getInt();
		int s = io.getInt();
		
		boolean res = false;
		
		HashSet<Integer> pSet = new HashSet<>();
		
		int n = 1;
		while (p*n<=s) {
			pSet.add(p*n++);
		}
		n = 1;
		while (q*n<=s) {
			if (pSet.contains(q*n++)) res = true;
		}
		
		if (res) io.println("yes");
		else io.println("no");
		
		io.close();
	}

}
