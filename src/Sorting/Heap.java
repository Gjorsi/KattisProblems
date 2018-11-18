package Sorting;
@SuppressWarnings({"rawtypes", "unchecked"})
public class Heap {

    public static void sort(Comparable[] arr) {
        for (int i=arr.length/2; i >= 0; i--) {
            sink(i, arr.length, arr);
        }
        
        int size = arr.length;
        
        while (--size >= 0) {
            swap(0, size, arr);
            sink(0, size, arr);
        }
    }
    
    private static void sink(int k, int size, Comparable[] arr) {
        int child = firstChild(k);

        while (child < size) {

            // Select the stronger child
            if (child + 1 < size && less(child, child+1, arr))
                child++;

            // Swap if needed; continue sink process if swap happened
            if (less(k, child, arr)) {
                swap(k, child, arr);
                k = child;
                child = firstChild(k);
            }
            else
                break;
        }
    }

    private static int firstChild(int k) {
        return (k + 1) * 2 - 1;
    }
    
    private static boolean less(int i, int j, Comparable[] arr) {
        return arr[i].compareTo(arr[j]) < 0;
    }
    
    private static void swap(int i, int j, Comparable[] arr) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
