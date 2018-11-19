package KSum;

public class SumTest {

    public static void main(String[] args) {
        
        Integer[] arr = {0, 2, -4, 5, 1, 7, -9, 4};
        
        int n = ThreeSum.find(arr, 8);
        System.out.println("number of possible combinations: " + n);
        
    }

}
