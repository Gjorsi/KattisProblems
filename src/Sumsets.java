import java.util.Arrays;

public class Sumsets {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int n = io.getInt();
		
		int arr[] = new int[n];
		
		for (int i=0; i<n ; i++) {
			arr[i] = io.getInt();
		}
		
//		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		
		int target = 0;
		
		for (int i=n-1; i>=0 ; i--) {
			for (int j=0; j<n-2 ; j++) {
				if (j==i) continue;
				for (int k=j+1; k<n-1 ; k++) {
					if (k==i) continue;
					target = arr[i] - arr[j] - arr[k];
					if (binarySearch(target, k+1, arr.length-1, arr)) {
						io.println(arr[i]);
						io.close();
						return;
					}
				}
			}
		}
		
		io.println("no solution");
		io.close();
	}

	private static boolean binarySearch(int target, int low, int upp, int[] arr) {
//		System.out.println("target: "+ target + "  arr[low]: " + arr[low]);
		if (low > upp || target<arr[low] || target>arr[upp]) return false;
		
		while (low+1 < upp) {
			int mid = (low + upp) / 2;
			
			if (arr[mid] > target) upp = mid;
			else low = mid;
		}
		
		return arr[low] == target || arr[upp] == target;
	}
	
}
