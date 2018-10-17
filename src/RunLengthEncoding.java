
public class RunLengthEncoding {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		String c = io.getWord();
		String word = io.getWord();
		
		if (c.equals("E")) {
			io.println(encode(word));
		} else {
			io.println(decode(word));
		}
		
		io.close();
	}

	private static String decode(String word) {
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<word.length() ; i+=2) {
			for (int j=0; j<Character.getNumericValue(word.charAt(i)) ; j++) {
				sb.append(word.charAt(i-1));
			}
		}
		
		return sb.toString();
	}

	private static String encode(String word) {
		StringBuilder sb = new StringBuilder();
		
		char c = word.charAt(0);
		int n = 1;
		sb.append(c);
		
		for (int i=1; i<word.length() ; i++) {
			if (word.charAt(i) == c) n++;
			else {
				c = word.charAt(i);
				sb.append(n);
				sb.append(word.charAt(i));
				n = 1;
			}
		}
		
		sb.append(n);
		return sb.toString();
	}

}
