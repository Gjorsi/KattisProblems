import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GuessDataStructure {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int n, cmd, val;
		Stack<Integer> stack;
		Queue<Integer> queue;
		PriorityQueue<Integer> pQueue;
		boolean spos = true, qpos = true, ppos = true;
		final String impossible = "impossible";
		final String s = "stack";
		final String p = "priority queue";
		final String q = "queue";
		final String notsure = "not sure";
		
		while (io.hasMoreTokens()) {
			
			n = io.getInt();
			
			stack = new Stack<>();
			queue = new ArrayDeque<>(n);
			pQueue = new PriorityQueue<>(n, Collections.reverseOrder());
			
			for (int i=0; i<n; i++) {
				cmd = io.getInt();
				val = io.getInt();
				
				if (cmd == 1) {
					stack.push(val);
					queue.offer(val);
					pQueue.offer(val);
				} else {
					if (queue.size() < 1) {
						spos = ppos = qpos = false;
						continue;
					};
					if (spos && stack.pop() != val) spos = false;
					if (qpos && queue.poll() != val) qpos = false;
					if (ppos && pQueue.poll() != val) ppos = false;
				}
			}
			
			if (!(spos || qpos || ppos)) io.println(impossible);
			else if ((spos && qpos) || (spos && ppos) || (ppos && qpos)) io.println(notsure);
			else if (spos) io.println(s);
			else if (ppos) io.println(p);
			else if (qpos) io.println(q);
			
			spos = ppos = qpos = true;
		}
		
		io.close();
	}

}
