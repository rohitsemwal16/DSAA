package org.rosemwal.dsa.matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInAMaze270 {

    public static void main(String[] args)  {

        int[][] arr = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(Arrays.toString(findPath(arr, 4).toArray()));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {

        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, 1, -1};
        String str = "UDRL";

        int[][] visited = new int[n][n];
        ArrayList<String> list = new ArrayList<>();

        if (m[0][0] == 0)   {
            return list;
        }

        findPath(0, 0, n, x, y, m, visited, list, "", str);
        return list;
    }

    static void findPath(int i, int j, int n, int[] x, int[] y, int[][]m,
                         int[][] visited, ArrayList<String> list, String move, String str)   {

        if (i == n-1 && j == n-1)   {
            list.add(move);
            return;
        }


        for (int k=0; k<4; k++) {

            int r=i+x[k];
            int s=j+y[k];

            if (r>=0 && s>=0 && r<n && s <n && visited[r][s] != 1 && m[r][s] ==1)   {
                visited[i][j] = 1;
                findPath(r, s, n, x, y, m, visited, list,  move+str.charAt(k), str);
                visited[i][j] = 0;
            }
        }
    }
}
