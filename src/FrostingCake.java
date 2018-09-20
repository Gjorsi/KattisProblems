
public class FrostingCake {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int n = io.getInt();
		long yellow = 0L, white = 0L, pink = 0L;
		
		int[] arrA = new int[n];
		int[] arrB = new int[n];
		
		for (int i=0; i<n ; i++) {
			arrA[i] = io.getInt();
		}
		for (int i=0; i<n ; i++) {
			arrB[i] = io.getInt();
		}
		
		for (int i=0; i<n ; i++) {
			for (int j=0; j<n ; j++) {
				switch ((arrA[i]+arrB[j])%3) {
				case 0:
					yellow += arrA[i]*arrB[j];
					break;
				case 1:
					pink += arrA[i]*arrB[j];
					break;
				case 2:
					white += arrA[i]*arrB[j];
					break;
				default:;
				}
			}
		}
		
		io.print(yellow + " ");
		io.print(pink + " ");
		io.print(white);
		
		io.close();
	}

}
