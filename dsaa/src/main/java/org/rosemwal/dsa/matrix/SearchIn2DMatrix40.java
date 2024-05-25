package org.rosemwal.dsa.matrix;

public class SearchIn2DMatrix40 {

    public static void main(String[] args)  {
        
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println("Target is present" + searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int end = matrix.length*matrix[0].length-1;
        int column = matrix[0].length;

        while(start<=end)    {

            int mid = start + (end-start)/2;

            int row = mid/column;
            int col = mid%column;

            if (target == matrix[row][col])
                return true;

            if(target < matrix[row][col])  {
                end = mid-1;
            }   else    {
                start = mid+1;
            }
        }
        return false;

        // int row = matrix.length;
        // int col = matrix[0].length;

        // for(int i=0; i<row; i++)    {
        //     for (int j=0; j<col; j++)   {
        //         if (matrix[i][j] == target) {
        //             return true;
        //         }
        //     }
        // }

        // return false;
    }
}
