package org.rosemwal.dsa.matrix;

// https://leetcode.com/problems/flood-fill/description/
public class FloodFillAlgorithm358 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) return image;

        int rowTotal = image.length;
        int colTotal = image[0].length;
        int currentColor = image[sr][sc];

        colorChange(sr, sc, image, color, currentColor, rowTotal, colTotal);
        return image;
    }

    public void colorChange(int sr, int sc,int[][] image, int color, int curColor, int rowTotal, int colTotal)    {

        if(sr<0 || sc<0 || sr>=rowTotal || sc>=colTotal || image[sr][sc]!=curColor)    {
            return;
        }
        image[sr][sc] = color;

        System.out.println(sr +" "+ sc);

        colorChange(sr+1, sc, image, color, curColor, rowTotal, colTotal);
        colorChange(sr-1, sc, image, color, curColor, rowTotal, colTotal);
        colorChange(sr, sc+1, image, color, curColor, rowTotal, colTotal);
        colorChange(sr, sc-1, image, color, curColor, rowTotal, colTotal);

        return;
    }

    public static void main(String[] args)  {

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};

        FloodFillAlgorithm358 floodFillAlgorithm358 = new FloodFillAlgorithm358();
        System.out.println("Flood Fill algo " + floodFillAlgorithm358.floodFill(image, 1,1, 2));

        int r = image.length;
        int c = image[0].length;

        for(int i=0;i<r;i++)    {
            for(int j=0;j<c;j++)    {
                System.out.print(image[i][j] +" ");
            }
            System.out.println();
        }

    }
}
