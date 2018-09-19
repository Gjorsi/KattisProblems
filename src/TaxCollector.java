import java.util.TreeSet;

public class TaxCollector {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		TreeSet<Integer> arr = new TreeSet<>();
		
		int n = io.getInt();
		int p = io.getInt();
		
		for (int i=0; i<p ; i++) {
			arr.add(io.getInt());
		}
		
		for (int i=0; i<n ; i++) {
			switch (io.getWord()){
			case "C": 
				arr.add(io.getInt());
				break;
			case "S":
				io.println(arr.pollLast());
				break;
			case "P":
				io.println(arr.pollFirst());
				break;
			default:;
			}
		}
		
		io.close();
	}

}
