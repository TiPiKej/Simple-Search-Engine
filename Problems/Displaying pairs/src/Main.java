import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("Gamma",  3);
        map.put("Omega", 24);
        map.put("Alpha",  1);

        // write your code here
        for (String val : map.keySet()) {
            System.out.printf("%s=%d\n", val, map.get(val));
        }
    }
}