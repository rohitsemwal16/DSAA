package org.rosemwal.code.bits;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PowerSetGenerateSubsets476 {

    static List<String> list = new LinkedList<>();

    public static void main(String[] args)  {

        String str = "abc";
        powerSet(str);

        System.out.println(Arrays.toString(list.toArray()));

    }

    static void powerSet(String str)  {

        int len = str.length();
        int n = 1<<len;

        for (int i=0; i<n; i++) {

            int h = i;
            StringBuilder subStr = new StringBuilder();
            for(int j=0;j<len;j++)  {

                if ((h & (1<<j)) > 0)  {
                    subStr.append(str.charAt(j));
                }
            }
            list.add(subStr.toString());
        }

    }
}
