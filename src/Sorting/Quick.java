package Sorting;

import java.util.SplittableRandom;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class Quick {

    public static void sort(Comparable[] arr) {
//        shuffle(arr);
        sort(arr, 0, arr.length);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            
            sort(arr, lo, pivot);
            sort(arr, pivot+1, hi);
        }
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        
        Comparable pivot = arr[lo];
        int i = lo, j = hi;
        
        while (true) {
            while (++i < hi && pivot.compareTo(arr[i]) > 0);
            while (pivot.compareTo(arr[--j]) < 0);
            
            if (i >= j) break;
            swap(i, j, arr);
        }
        
        swap(lo, j, arr);
        return j;
    }
    
    private static void swap(int i, int j, Comparable[] arr) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Simple shuffling procedure (Fisher-Yates/Durstenfeld/Knuth)
     * Resulting permutation is chosen uniformly at random
     *
     * @param arr array to be shuffled
     */
    private static void shuffle(Comparable[] arr) {
        SplittableRandom r = new SplittableRandom();
        for (int i = 0; i < arr.length; i++) {
            int j = r.nextInt(arr.length-i) + i;
            swap(i, j, arr);
        }
    }
    
}
