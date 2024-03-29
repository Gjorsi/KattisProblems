import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class ChoppingWood {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int n = io.getInt();
		
		PriorityQueue<Integer> leaf = new PriorityQueue<>(n);
		Queue<Integer> node = new ArrayDeque<>(n);
		HashSet<Integer> found = new HashSet<>();
		int[] all = new int[n+2];
		int in;
		
		for (int i=0; i<n-1; i++) {
			in = io.getInt();
			all[in]++;
			if (!found.contains(in)){
				node.offer(in);
				found.add(in);
			}
		}
		
//		for (int x: node) {
//			io.print(x);
//			io.print(" ");
//		}
		
		boolean err = false;
		if (io.getInt() != n+1) {
			err = true;
			io.println("Error");
		}
		
		if (!err) {
			for (int i=1; i<n+1; i++) {
				if (all[i] == 0) leaf.offer(i);
			}
			
			StringBuilder sb = new StringBuilder();
			while (leaf.size() > 0) {
				sb.append(leaf.poll()).append("\n");
				if (node.size() > 0 && --all[node.peek()] == 0) leaf.offer(node.poll());
			}
			
//			if (node.size() > 0) {
//				io.println("Error");
//			} else {
				io.print(sb.toString());
//			}
		}
		io.close();
	}
}
