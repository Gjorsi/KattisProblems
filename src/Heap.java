import java.lang.reflect.Array;

public class Heap<E extends Comparable<E>> {

    private int maxSize;
    private int size = 0;
    E[] arr;
    
    @SuppressWarnings("unchecked")
    public Heap(int n) {
        this.maxSize = n;
        arr = (E[])new Object[n+1];
    }
    
    public int size() {
        return size;
    }
    
    public void add(E elem) {
        arr[++size] = elem;
        swim(size);
    }
    
    public E poll() {
        return null;
    }

    /**
     * Swap value at pos k with its parent while parent is greater
     * 
     * @param k position of value to move
     */
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            swap(k, k/2);
            k = k/2;
        }
    }
    
    /**
     * Swap value at pos k with the lesser of its children while it has children of lesser value
     * 
     * @param k position of value to move
     */
    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            swap(k, j);
            k = j;
        }
    }
    
    /**
     * Check if if key at position i in heap is greater than key at position j in heap
     * 
     * @param i
     * @param j
     * @return true if key at position i in heap > key at position j in heap
     */
    private boolean greater(int i, int j) {
        return arr[i].compareTo(arr[j]) > 0;
    }
    
    private void swap(int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
