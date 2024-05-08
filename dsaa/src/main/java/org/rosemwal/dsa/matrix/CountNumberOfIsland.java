package org.rosemwal.dsa.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class CountNumberOfIsland {

    char[][] g;
    public int numIslandsDfs(char[][] grid) {
        int islands = 0;
        g = grid;
        for (int i=0; i<g.length; i++)
            for (int j=0; j<g[i].length; j++)
                islands += sink(i, j);
        return islands;
    }

    int sink(int i, int j) {
        if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0')
            return 0;
        g[i][j] = '0';
        sink(i+1, j);
        sink(i-1, j);
        sink(i, j+1);
        sink(i, j-1);
        return 1;
    }

    public int numIslands(char[][] grid) {

        int rowTotal = grid.length;
        int colTotal = grid[0].length;

        return bfsTraversal(rowTotal, colTotal, grid) ;

    }

    int bfsTraversal(int rowTotal, int colTotal, char[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int cnt=0;

        for(int i=0; i<rowTotal; i++)   {
            for(int j=0; j<colTotal; j++)   {

                if(grid[i][j]=='1') {
                    cnt++;
                }   else    {
                    continue;
                }

                System.out.println("H " + i +" "+ j);

                queue.add(new int[]{i, j});

                while(!queue.isEmpty()) {
                    int[] node = queue.poll();
                    int r = node[0];
                    int c = node[1];
                    grid[r][c]=0;
                    populateConnectingIslands(grid, r, c, rowTotal, colTotal, queue);
                }
            }
        }
        return cnt;
    }

    void populateConnectingIslands(char[][] grid, int r, int c,
                                   int rowTotal, int colTotal, Queue<int[]> queue)    {

        for(int i=-1; i<=1; i++)    {
            for(int j=-1; j<=1; j++)    {

                if(Math.abs(i) == Math.abs(j))  {
                    continue;
                }
                System.out.println(r +" "+ c + " "+ (r+i) + " "+(c+j));
                validateGridPositioning(r+i, c+j, rowTotal, colTotal, grid, queue);
            }
        }
    }

    void validateGridPositioning(int r, int c, int rowTotal, int colTotal, char[][] grid, Queue<int[]> queue)  {

        if (r>=0 && c>=0 && r<rowTotal && c<colTotal && grid[r][c] == '1')   {
            grid[r][c] = '0';
            queue.offer(new int[]{r, c});
        }
    }

    public static void main(String[] args)  {

        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        CountNumberOfIsland countNumberOfIsland = new CountNumberOfIsland();
//        System.out.println("Islands " + countNumberOfIsland.numIslands(grid));
        System.out.println("Islands " + countNumberOfIsland.numIslandsDfs(grid));

    }
}
