package org.rosemwal.dsa.matrix;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
public class ShortestPathAllOOr1 {

    public static void main(String[] args)  {
        
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int row = grid.length;
        int col= grid[0].length;

        boolean[][] visited = new boolean[row][col];

        if (grid[0][0] != 0 || grid[row-1][col-1] != 0) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();

        int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] c = {-1, 0, 1, -1, 1, -1, 0, 1};

        queue.offer(new int[] {0, 0, 1});

        while(!queue.isEmpty()) {

            int[] poll = queue.poll();
            int rPoll = poll[0];
            int cPoll = poll[1];
            int dis = poll[2];

            if(rPoll == row-1 && cPoll == col-1)    {
                return dis;
            }

            for (int i=0; i<8; i++)    {
                int newR = rPoll+ r[i];
                int newC = cPoll + c[i];

                if (isBound(newR, newC, row, col) &&
                        !visited[newR][newC] && (grid[newR][newC] == 0))    {
                    queue.offer(new int[] {newR, newC, dis+1});

                    System.out.println(newR +" "+ newC + " "+ (dis+1));
                    visited[newR][newC] = true;
                }

            }
        }
        return -1;

    }

    private static boolean isBound(int newR, int newC, int row, int col)    {
        return newR>=0 && newR<row && newC>=0 && newC<col;
    }
}
