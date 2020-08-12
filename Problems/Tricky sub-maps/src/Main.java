import java.util.*;

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        // Write your code here
        Object[] keys = map.keySet().toArray();

        Map<Integer, String> mapToRet = new LinkedHashMap<>();

        if ((int)keys[0] % 2 != 0) {
            for (int i = 4; i >= 0; i--) {
                mapToRet.put((int)keys[i], map.get(keys[i]));
            }
        } else {
            for (int i = keys.length - 1; (int)keys[i] >= (int)keys[keys.length - 1] - 4; i--) {
                mapToRet.put((int)keys[i], map.get(keys[i]));
            }
        }

        return mapToRet;
    }
}