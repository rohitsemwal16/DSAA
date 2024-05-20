package org.rosemwal.dsa.misc;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger76 {

    public static void main(String[] args)  {

        System.out.println(romanToInt("MCMXCIV"));
    }

    static Map<Character, Integer> romanValues = new HashMap<>();

    static void initializeMap() {
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
    }

    public static int romanToInt(String s) {

        initializeMap();


        int i=0;
        int len = s.length();

        int ans=0;

        while(i<len)    {

            char first = s.charAt(i);
            char second = (i+1)<len? (s.charAt(i+1)) :'o';

            if ((first==('I') && (second==('V') || second==('X'))) ||
                    (first==('X') && (second==('C') || second==('L'))) ||
                    (first==('C') && (second==('D') || second==('M'))))   {
                ans+= romanValues.get(second)-romanValues.get(first);
                i++;
            }   else    {
                ans += romanValues.get(first);
            }
            i++;

        }
        return ans;
    }


}

