
public class JustAMinute {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int n = io.getInt();
		
		double lag = 0, min = 0;
		
		double avg = 0;
		
		for (int i=0; i<n ; i++) {
			min += io.getDouble()*60;
			lag += io.getDouble();
		}
		
		avg = lag/min;
		
		if (avg <= 1.0) {
			io.println("measurement error");
		} else {
			io.println(avg);
		}
		
		io.close();
	}

}
