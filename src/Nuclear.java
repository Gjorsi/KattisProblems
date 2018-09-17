
public class Nuclear {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int n = io.getInt();
		
		if (io.getInt() != 0) {
			io.println("false");
			io.close();
			return;
		}
		
		int[] arr = new int[n+1];
		
		for (int i=1; i<n ; i++) {
			arr[i] = io.getInt();
		}
		
		for (int i=1; 2*i+1<n ; i++) {
//			System.out.println(i);
			if (arr[i] > arr[2*i] || arr[i] > arr[2*i+1] ) {
				io.println("false");
				io.close();
				return;
			}
		}
		
		if ((n)%2 == 0 && n > 1) {
			if (arr[n/2] > arr[n-1]) {
				io.println("false");
				io.close();
				return;
			}
		}
		
		io.println("true");
		io.close();
	}

}
