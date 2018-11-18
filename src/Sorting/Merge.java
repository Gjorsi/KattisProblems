package Sorting;
@SuppressWarnings({"rawtypes", "unchecked"})
public class Merge {

    
    public static void sort(Comparable[] arr) {
        
        Comparable[] aux= new Comparable[arr.length];
        
        sort(arr, aux, 0, arr.length);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi) {
        if (lo+1 >= hi) {
            return;
        }
        
        int mid = (hi+lo)/2;
        
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid, hi);
        
        merge(arr, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
        int li = lo, ri = mid, ki = lo;
        
        for (int i=lo; i<hi; i++) {
            aux[i] = arr[i];
        }
        
        while (li < mid && ri < hi) {
            arr[ki++] = less(li, ri, aux) ? aux[li++]: aux[ri++];
        }
        
        while (li < mid) {
            arr[ki++] = aux[li++];
        }
        
        while (ri < mid) {
            arr[ki++] = aux[ri++];
        }
    }
    
    private static boolean less(int i, int j, Comparable[] arr) {
        return arr[i].compareTo(arr[j]) < 0;
    }
}