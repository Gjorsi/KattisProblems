
public class RuntimeAnalysis {
	static long counter = 0L;
	public static void main(String[] args) {
		
		int n = 1000;
		
		functionZ(n);
		
		System.out.println(counter);
		
	}

	private static void step() {
		counter++;
	}
	
    // Challenge! Hint: Make reasonable simplifications,
    // and devise an (over-) estimate on how many steps.
    // You might need to do some research
    // on the internet (e. g. Wolfram Alpha).
    static boolean[] functionZ(int n) {
        boolean[] p = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            step();
            p[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            step();
            if (p[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    step();
                    p[j] = false;
                }
            }
        }
        return p;
    }
	
}
