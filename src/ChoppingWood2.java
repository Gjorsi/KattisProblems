import java.util.PriorityQueue;

public class ChoppingWood2 {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int n = io.getInt();
		
		PriorityQueue<Integer> leaf = new PriorityQueue<>(n);
		int[] nLeaves = new int[n+2];
		int[] boundNodes = new int[n+1];
		int in = 0;
		
		for (int i=1; i<n+1; i++) {
			in = io.getInt();
			nLeaves[in]++;
			boundNodes[i] = in;
		}
		
//		for (int x: node) {
//			io.print(x);
//			io.print(" ");
//		}
		
		boolean err = false;
		if (in != n+1) {
			err = true;
			io.println("Error");
		}
		
		if (!err) {
			for (int i=1; i<n+1; i++) {
				if (nLeaves[i] == 0) leaf.offer(i);
			}
			
			int x = 1;
			StringBuilder sb = new StringBuilder();
			while (leaf.size() > 0 && x<boundNodes.length) {
				sb.append(leaf.poll()).append("\n");
				if (--nLeaves[boundNodes[x++]] == 0) leaf.offer(boundNodes[x-1]);
			}

			io.print(sb.toString());
		}
		io.close();
	}
}