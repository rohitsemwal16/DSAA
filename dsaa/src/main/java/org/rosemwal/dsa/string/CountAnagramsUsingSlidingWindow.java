package org.rosemwal.dsa.string;

import java.util.HashMap;
import java.util.Map;

public class CountAnagramsUsingSlidingWindow {

    private static int findNumberOfAnagramsUsingSlidingWindowConcept(String word, String text) {

        Map<Character, Integer> map = new HashMap<>();

        int k=word.length();

        char[] wordChars = word.toCharArray();
        char[] textChars = text.toCharArray();

        int res = 0;

        for (int i=0; i<wordChars.length; i++)   {
            map.put(wordChars[i], map.getOrDefault(wordChars[i], 0)+1);
        }

        int count = map.size();

        int i=0;

        for (int j=0; j<textChars.length; j++)  {

            if(map.containsKey(textChars[j]))   {
                map.put(textChars[j], map.get(textChars[j])-1);

                if(map.get(textChars[j])==0)    {
                    count--;
                }
            }

            if (j-i+1==k) {
                if (count == 0) {
                    res += 1;
                }
                if(map.containsKey(textChars[i]))   {
                    map.put(textChars[i], map.get(textChars[i])+1);
                    if(map.get(textChars[i])==1){
                        count++;
                    }
                }
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args)  {

        String text = "forxxorfxdofr";
        String word = "for";

        System.out.println(findNumberOfAnagramsUsingSlidingWindowConcept(word, text));
    }
}
