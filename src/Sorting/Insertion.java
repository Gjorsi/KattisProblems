package Sorting;

import java.util.LinkedList;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Insertion {
    
    static LinkedList<Comparable> list;

    public static void sort(Comparable[] arr) {
        list = new LinkedList<>();
        list.add(arr[0]);
        A:for (int i=1; i<arr.length; i++) {
            for (int j=0; j<list.size(); j++) {
                if (list.get(j).compareTo(arr[i]) > 0) {
                    list.add(j, arr[i]);
                    continue A;
                }
            }
            list.add(arr[i]);
        }
        
        list.toArray(arr);
    }

}
