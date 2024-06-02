package org.rosemwal.dsa.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapFunctionalities {

    public static void main(String[] args)  {

        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("d", 50);
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        // Sorting map based on values in reverse order
        Map<String, Integer> map2 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> map1 : map2.entrySet())  {
            System.out.println(map1.getKey() + map1.getValue());

        }


        Map<Integer, Integer> map1 = new LinkedHashMap<>();

        map1.put(50, 20);
        map1.put(10, 90);
        map1.put(20, 100);
        map1.put(30, 150);

        Map<Integer, Integer> map3 = map1.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Collections.reverseOrder())).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<Integer, Integer> map4 : map3.entrySet())  {
            System.out.println(map4.getKey() +" "+ map4.getValue());
        }
    }
}
