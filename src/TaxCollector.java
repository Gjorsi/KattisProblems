import java.util.Comparator;
import java.util.TreeSet;

public class TaxCollector {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		Comparator<Integer> MyComparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer i0, Integer i1) {

                int r = i0.compareTo(i1);
                if (r == 0) return -1;
                return r;
            }
		    
		};
		
		TreeSet<Integer> tree = new TreeSet<>(MyComparator);
		
		int n = io.getInt();
		int p = io.getInt();
		
		for (int i=0; i<p ; i++) {
			tree.add(io.getInt());
		}
		
		for (int i=0; i<n ; i++) {
			switch (io.getWord()){
			case "C": 
			    tree.add(io.getInt());
				break;
			case "S":
				io.println(tree.pollLast());
				break;
			case "P":
				io.println(tree.pollFirst());
				break;
			default:;
			}
		}
		
		io.close();
	}

}
