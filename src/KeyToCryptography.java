
public class KeyToCryptography {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		char[] line = io.getWord().toCharArray();
		
		char[] key = io.getWord().toCharArray();
		
		char[] r = new char[line.length];
		
		for (int i=0; i<Math.min(key.length, line.length) ; i++) {
			r[i] = shift(key[i], line[i]);
		}
		
		if (key.length < line.length) {
			for (int i=key.length; i<line.length ; i++) {
				r[i] = shift(r[i-key.length], line[i]);
			}
		}
		
		io.print(r);
		
		io.close();
	}
	
	private static char shift (char key, char tar) {
		
		int diff = key-'A';
		
		int r = tar-'A';
		
		if((r-diff)>=0) {
			r -= diff;
		} else {
			r = 26+(r-diff);
		}
		
		return (char)('A'+r);
	}

}
