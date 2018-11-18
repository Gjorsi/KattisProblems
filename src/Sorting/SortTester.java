package Sorting;

import java.util.Arrays;
import java.util.Random;
import static Sorting.Verify.verifyEquals;
@SuppressWarnings({"rawtypes"})
public class SortTester {
    static Random random = new Random();
    static final int N = 10;
    
    public static void main(String[] args) {
        
        sanityTest("Insertion");
        sanityTest("Merge");
        sanityTest("Quick");
        sanityTest("Shell");
        sanityTest("Heap");
    }

    private static void sanityTest(String alg) {
        System.out.println("Sanity Test of " + alg + "...");
        
     // Check that Integer objects are sorted correctly
        Integer[] arri = new Integer[] {5, 3, 4, 9, 1};
        sort(alg, arri);
        verifyEquals(Arrays.toString(arri), "[1, 3, 4, 5, 9]");

        // Check that String objects are sorted correctly
        String[] arrs = new String[] {"abc", "yxz", "ijk"};
        sort(alg, arrs);
        verifyEquals(Arrays.toString(arrs), "[abc, ijk, yxz]");

        System.out.println("success!");
    }
    
    private static void sort(String alg, Comparable[] a) {
        switch (alg) {
            case "Insertion":
                Insertion.sort(a);
                break;
            case "Merge":
                Merge.sort(a);
                break;
            case "Quick":
                Quick.sort(a);
                break;
            case "Shell":
                Shell.sort(a);
                break;
            case "Heap":
                Heap.sort(a);
                break;
            default:
                throw new IllegalArgumentException(String.format("I don't know algorithm \"%s\"", alg));
        }
}

}
