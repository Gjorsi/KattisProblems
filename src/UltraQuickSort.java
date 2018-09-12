import java.util.Arrays;

public class UltraQuickSort {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int n = io.getInt();
		
		int[] in = new int[n];
		
		for (int i=0; i<n ; i++) {
			in[i] = io.getInt();
		}
		
		int[] sorted = in;
		Arrays.sort(sorted);
		
		
		
		io.close();
	}

}
