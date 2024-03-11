package org.rosemwal.code.string;

import java.util.HashMap;
import java.util.Map;

public class StringCustomSortLeetCode791 {

    public String customSortString(String S, String T) {

        Map<Character, Integer> targetStringMap = new HashMap<>();

        char[] targetCharacter = T.toCharArray();

        for (char ch :  targetCharacter)  {
            targetStringMap.put(ch, targetStringMap.getOrDefault(ch, 0)+1 );
        }

        String resultingString = "";
        for (char chS : S.toCharArray())    {

            if(targetStringMap.containsKey(chS))    {
                int count = targetStringMap.get(chS);
                while (count > 0)  {
                    resultingString = resultingString + chS;
                    count--;
                }
                targetStringMap.put(chS, 0);
            }
        }

        for ( char ch: targetStringMap.keySet()) {

            int count = targetStringMap.get(ch);
            while (count > 0) {
                resultingString = resultingString + ch;
                count--;
            }
        }
        return resultingString;
    }

    public static void main(String[] args)    {
        String S = "ecolt";
        String T = "leetcoded";

        StringCustomSortLeetCode791 obj = new StringCustomSortLeetCode791();
        System.out.println(obj.customSortString(S, T));
    }
}
