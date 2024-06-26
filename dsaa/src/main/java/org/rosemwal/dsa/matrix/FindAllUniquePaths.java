package org.rosemwal.dsa.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllUniquePaths {

    public static void main(String[] args)  {

        System.out.println(uniquePaths(3, 3));
    }
    static int totalPath=0;

    public static  int uniquePaths(int m, int n) {
        totalPath = 0;
        int[][] visited = new int[m][n];
        int[][] arr = {{0, 1}, {1, 0}};
        List<String> list = new LinkedList<>();
        findUniquePaths(0, 0, m, n, visited, arr, list);
        return totalPath;

    }

    static void findUniquePaths(int i, int j, int r, int c, int[][] visited, int[][] arr, List<String> list)    {

        if (i == r-1 && j == c-1 )   {
            totalPath++;

            System.out.println(Arrays.toString(list.toArray()));
            return;
        }

        for (int k=0; k<2; k++) {
            int rf = i+arr[k][0];
            int cf = j+arr[k][1];

            if (rf>=0 && cf>=0 && rf<r && cf <c && visited[rf][cf] == 0)  {
                visited[rf][cf] = 1;
                list.add(String.valueOf(i).concat(String.valueOf(j)));
                findUniquePaths(rf, cf , r, c, visited, arr, list);
                list.remove(list.size()-1);
                visited[rf][cf] = 0;
            }
        }
    }
}

