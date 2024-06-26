package org.rosemwal.dsa.matrix;

public class MS {

    public static void main(String[] args)  {
        int[][] A = {{1, 1, 2}, {2, 0, 0}};
        System.out.println(solution(A));

    }

    static int count = 0;
    public static int solution(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        boolean visited[][] = new boolean[row][col];

        int sum = 0;

        for(int i=0 ;i<row; i++)   {
            for(int j=0; j<col; j++)    {
                sum+=A[i][j];
                visited[i][j] = false;
            }
        }

        for(int i=0 ;i<row; i++)   {
            for(int j=0; j<col; j++)    {

                System.out.println("Start " + i + " "+ j);
                dfs(A, i, j, row, col, visited, sum, 0);
                visited[i][j] = true;
            }
        }
        return count;
    }

    static void dfs(int[][] A, int i, int j, int r, int c, boolean[][] visited, int sum, int cur) {
        System.out.println(i + " "+j +" "+ cur);

        if (cur == sum-cur) {
            System.out.print("h " + i + " "+j +" "+ cur);
            count++;
            return;
        }

        if(i < 0 || i >= r || j < 0 || j >= c || visited[i][j] || cur>(sum-cur)) {
            return;
        }
        int val = A[i][j];
        dfs(A, i + 1, j, r, c, visited, sum, cur+val);
        dfs(A, i, j + 1, r, c, visited, sum, cur+val);

    }
}
