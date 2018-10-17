import java.util.Arrays;

public class GlitchBot {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int x = io.getInt();
		int y = io.getInt();
		
		int n = io.getInt();
		
		String[] ins = new String[n];
		
		for (int i=0; i<n ; i++) {
			ins[i] = io.getWord();
		}
		
		for (int i=0; i<n ; i++) {
			String res = check(x,y,ins,i);
			if (res.length() > 1) {
				io.println(i + res);
			}
		}
		
		io.close();
	}

	private static String check(int x, int y, String[] ins, int i) {
		String[] testIns = new String[ins.length];
		
		for (int j=0; j<ins.length ; j++) {
			testIns[j] = ins[j];
		}
		
		if (ins[i] == "Forward") {
			testIns[i] = "Left";
			if (checkCorrect(x,y,testIns)) return testIns[i];
			testIns[i] = "Right";
			if (checkCorrect(x,y,testIns)) return testIns[i];
		} else if (ins[i] == "Left") {
			testIns[i] = "Forward";
			if (checkCorrect(x,y,testIns)) return testIns[i];
			testIns[i] = "Right";
			if (checkCorrect(x,y,testIns)) return testIns[i];
		} else {
			testIns[i] = "Left";
			if (checkCorrect(x,y,testIns)) return testIns[i];
			testIns[i] = "Forward";
			if (checkCorrect(x,y,testIns)) return testIns[i];
		}
		
		return "";
	}

	private static boolean checkCorrect(int x, int y, String[] testIns) {
		int dir = 0;
		
		int cX = 0, cY = 0;
		
		for (int i=0; i<testIns.length ; i++) {
			System.out.println(testIns[i]);
			switch (testIns[i]) {
			case "Forward":
				switch (dir) {
				case 0:
					cY++;
					break;
				case 2:
					cY--;
					break;
				case 1:
					cX++;
					break;
				case 3:
					cX--;
					break;
				default:;
				}
			case "Left":
				if (dir == 0) dir = 3;
				else dir--;
				break;
			case "Right":
				if (dir == 3) dir = 0;
				else dir++;
				break;
			default:;
				}
			}
		
		System.out.println("cX/cY: " + cX + "/" + cY + " " + x + " " + y);
		
		return (cX == x && cY == y);
		}
	}
