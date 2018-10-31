import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GrandpaBernie {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        HashMap<String, ArrayList<Integer>> data = new HashMap<>();
        
        int n = io.getInt();
        String country;
        
        for (int i=0; i<n; i++) {
            country = io.getWord();
            if (data.containsKey(country)) {
                data.get(country).add(io.getInt());
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(io.getInt());
                data.put(country, temp);
            }
        }
        
        for (ArrayList<Integer> a : data.values()) {
            Collections.sort(a);
        }
        
        int m = io.getInt();
        
        for (int i=0; i<m; i++) {
            io.println(data.get(io.getWord()).get(io.getInt()-1));
        }
        
        io.close();
    }

}
