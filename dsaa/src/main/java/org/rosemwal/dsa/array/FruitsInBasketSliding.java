package org.rosemwal.dsa.array;

import java.util.LinkedHashMap;
import java.util.Map;

public class FruitsInBasketSliding {

    public static void main(String[] args)  {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("Total fruits " +totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {

        int l=0;
        int r=0;
        int len = fruits.length;
        int max = 0;

        Map<Integer, Integer> map = new LinkedHashMap<>();

        while(r<len)    {

            if(map.size() <= 2)   {
                map.put(fruits[r], map.getOrDefault(fruits[r], 0) +1);
            }
            max = Math.max(max, r-l);
            while(map.size()>2) {
                map.put(fruits[l], map.get(fruits[l])-1);
                if(map.get(fruits[l]) == 0)   {
                    map.remove(fruits[l]);
                    l++;
                    break;
                }

                l++;
            }
            r++;
        }

        return Math.max(max, r-l);
    }
}
