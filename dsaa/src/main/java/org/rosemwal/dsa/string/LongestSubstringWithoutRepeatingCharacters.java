package org.rosemwal.dsa.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args)  {
        System.out.println("Longest Non repeating Substring " +lengthOfLongestSubstring("cadbzabcd"));
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> mapIndex = new HashMap<>();

        int l=0; int r=0;
        char[] charArray = s.toCharArray();
        int maxLen = 0;

        while(r<charArray.length)   {

            if(mapIndex.containsKey(charArray[r]) && mapIndex.get(charArray[r]) >=l)  {
                maxLen = Math.max(maxLen, r-l);
                l= mapIndex.get(charArray[r])+1;
            }
            mapIndex.put(charArray[r], r);
            r++;
        }
        return Math.max(maxLen, r-l);
    }
}
