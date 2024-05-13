package org.rosemwal.dsa.array;

public class StockBuySell17 {

    public int maxProfit(int[] prices) {

        int intermediateMax = prices[prices.length-1];
        int maxValue = 0;

        for (int i=prices.length-2; i>=0; i--)    {
            if(maxValue<(intermediateMax -prices[i]))   {
                maxValue =  intermediateMax - prices[i];
            }
            intermediateMax=Math.max(intermediateMax,prices[i]);
        }
        return maxValue;
    }

    public static void main(String[] args)  {
        int[] arr = {7,1,5,3,6,4};

        StockBuySell17 stockBuySell17 = new StockBuySell17();
        System.out.println("Max stock buy " + stockBuySell17.maxProfit(arr));
    }
}
