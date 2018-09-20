import java.util.ArrayList;
import java.util.PriorityQueue;

public class Minions {

	static ArrayList<minion> minions;
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int n = io.getInt();
		
		minions = new ArrayList<>(n);
		
		for (int i=0; i<n ; i++) {
			minions.add(new minion(io.getInt(), io.getInt()));
		}
		
		int nRooms = 1;
		
		while (minions.size() > 0) {
			minion t = findBestMinion();
			minions.remove(t);
			for (int j=0; j<minions.size() ; j++) {
				
			}
		}
		
		io.println(nRooms);
		
		io.close();
	}
	
	public static minion findBestMinion() {
		minion best = minions.get(0);
		for (int i=1; i<minions.size() ; i++) {
			if (minions.get(i).max-minions.get(i).min > best.max-best.min) {
				best = minions.get(i);
			}
		}
		
		return best;
	}
	
	

}

class minion implements Comparable<minion> {
	public int min;
	public int max;
	
	public minion(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public int compareTo(minion other) {
		// TODO Auto-generated method stub
		if (Integer.compare(this.min, other.min) != 0) {
			return Integer.compare(this.min, other.min);
		} else {
			return Integer.compare(this.max, other.max);
		}
	}
}
