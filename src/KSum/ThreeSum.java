package KSum;

public class ThreeSum {

    public static int find(Integer[] arr, int sum) {
        int l, r, n = 0;
        
        Sorting.Quick.sort(arr);
        
        for (int i=0; i<arr.length; i++) {
            l = i+1;
            r = arr.length-1;
            while (l<r ) {
                if (arr[i] + arr[l] + arr[r] == sum) {
                    System.out.println("Found 3 values:\n" + arr[i] + " + " + arr[l] + " + " + arr[r] + " = " + sum);
                    n++;
                    l++;
                } else if (arr[i] + arr[l] + arr[r] < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        
        return n;
    }

}
