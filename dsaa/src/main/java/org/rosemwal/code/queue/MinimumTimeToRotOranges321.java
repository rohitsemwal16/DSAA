package org.rosemwal.code.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeToRotOranges321 {

    public int orangesRotting(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<row;i++) {
            for(int j=0; j<col; j++)    {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int timeFrame=0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++)   {
                int[] poll = queue.poll();
                checkAndUpdateIfGridAdjacentHasRottenOranges(poll, row, col, grid, queue);
            }
            timeFrame++;
        }

        for(int i=0; i<row;i++) {
            for(int j=0; j<col; j++)    {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return timeFrame == 0? 0: timeFrame-1;
    }

    void checkAndUpdateIfGridAdjacentHasRottenOranges(int[] loc, int rowTotal, int colTotal,
                                                      int[][] grid, Queue<int[]> queue)   {
        int row = loc[0];
        int col = loc[1];

        if (row-1>=0  && grid[row-1][col] == 1) {
            grid[row-1][col] = 2;
            queue.offer(new int[]{row-1, col});
        }

        if ((col-1)>=0 && grid[row][col-1] == 1)  {
            grid[row][col-1] = 2;
            queue.offer(new int[]{row, col-1});
        }

        if ((row+1)<rowTotal  && grid[row+1][col] == 1) {
            grid[row+1][col] = 2;
            queue.offer(new int[]{row+1, col});
        }

        if ((col+1)<colTotal && grid[row][col+1] == 1)  {
            grid[row][col+1] = 2;
            queue.offer(new int[]{row, col+1});
        }
    }

    public static void main(String[] args)  {

        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        MinimumTimeToRotOranges321 minimumTimeToRotOranges321 = new MinimumTimeToRotOranges321();
        int timeFrame = minimumTimeToRotOranges321.orangesRotting(arr);
        System.out.println("TimeFrame is " + timeFrame);
    }
}
