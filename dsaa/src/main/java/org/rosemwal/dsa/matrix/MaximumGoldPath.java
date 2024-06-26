package org.rosemwal.dsa.matrix;
// https://leetcode.com/problems/path-with-maximum-gold/description/
public class MaximumGoldPath {

    int r = 0;
    int c = 0;
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] != 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j, int cur) {
        if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == 0) {
            max = Math.max(max, cur);
            return;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        dfs(grid, i + 1, j, cur + val);
        dfs(grid, i - 1, j, cur + val);
        dfs(grid, i, j + 1, cur + val);
        dfs(grid, i, j - 1, cur + val);
        grid[i][j] = val;
    }

    public static void main(String[] args)  {

        MaximumGoldPath path = new MaximumGoldPath();

        int[][] grid = new int[][]{{0,6,0}, {5, 8, 7}, {0,9,0}};
        int sum = path.getMaximumGold(grid);
        System.out.println("Max path Sum is "+ sum);

    }

}
