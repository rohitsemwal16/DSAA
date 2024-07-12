package org.rosemwal.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestSumContiguousSubarray1318 {

    public static void main(String[] args)  {

        int a = solution("ABBBCCDDCCC", 3);
        System.out.println(a);

//        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
//
//        System.out.println("Maximum sum sub array brute force " + findMaxSumBruteForce(arr)); // O(n^2)
//        System.out.println("Maximum sum sub array Kadane Algorithm" + findMaxSumKadane(arr)); // O(n)
    }

    public static int solution(String S, int K) {
        // Implement your solution here
        int len = S.length();
        int[][] dp = new int[len][K+1];

        for (int[] row : dp)    {
            Arrays.fill(row, -1);
        }

        return dfs(0, len, dp, S, K);
    }

    private static int dfs(int i, int len, int[][] dp, String S, int K) {

        if (K<0)  {
            return len;
        }

        if ((i + K) >= len)
            return 0;

        int result = dp[i][K];
        if (result!=-1) {
            return result;
        }

        result = dfs(i+1, len, dp, S, K-1);

        int difference =0;
        int size = 0;
        int similar = 0;

        for (int a=i; a<len && difference<=K; a++) {
            System.out.print("f");

            if(S.charAt(i) == S.charAt(a))  {
                similar++;
                if (similar<=2 || similar ==10 || similar == 100)
                    size++;
            }   else{
                difference++;
            }
            result = Math.min(result, size+ dfs(a+1, len, dp, S, K-difference));
        }
        dp[i][K] = result;
        return result;
    }

//    public static String[] solution(int N, int K) {
//        if (N == 0) {
//            return new String[] {""};
//        }
//        ArrayList<String> result = new ArrayList<String>();
//        for (String p : solution(N - 1, K)) {
//            for (char l : new char[] {'a', 'b', 'c'}) {
//                int pLen = p.length();
//                if (pLen == 0 || p.charAt(pLen - 1) != l) {
//                    result.add(p + l);
//                }
//            }
//        }
//        int prefSize = Math.min(result.size(), K);
//        return result.subList(0, prefSize).toArray(new String[prefSize]);
//    }

    private static int findMaxSumBruteForce(int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {
            sum = arr[i];
            for (int j=i+1; j<arr.length; j++)  {
                sum +=arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private static int findMaxSumKadane(int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {

            sum += arr[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
