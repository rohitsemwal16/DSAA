package org.rosemwal.code.array;

public class KokoEatingBananas37 {

    public int minEatingSpeedBinarySearch(int[] piles, int h) {

        int minBananas = Integer.MAX_VALUE;
        int maxBananas = Integer.MIN_VALUE;

        for(int i=0;i<piles.length; i++)    {
            if(piles[i]>=maxBananas) {
                maxBananas = piles[i];
            }

            if(piles[i]<minBananas) {
                minBananas = piles[i];
            }
        }

        int min = 1;
        int max = maxBananas;
        int result = 0;

        while(min<=max)    {
            int mid = min + (max-min)/2;

            int timeMid = findTime(piles, mid);
            int timeMin = findTime(piles, min);

            if(timeMid>h) {
                min = mid+1;
            }   else    {
                result = mid;
                max = mid-1;
            }
        }
        return result;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int minBananas = Integer.MAX_VALUE;
        int maxBananas = Integer.MIN_VALUE;

        for(int i=0;i<piles.length; i++)    {
            if(piles[i]>=maxBananas) {
                maxBananas = piles[i];
            }

            if(piles[i]<minBananas) {
                minBananas = piles[i];
            }
        }

        for(int j = 1; j<=maxBananas; j++)    {
            int timeRequired = findTime(piles, j);
            System.out.println(maxBananas +" "+j + " "+timeRequired);

            if(timeRequired<=h) {
                return j ;
            }
        }
        return -1;
    }

    int findTime(int[] piles, int k) {

        int result = 0;
        for(int i=0; i<piles.length; i++)   {
            result+=Math.ceil((double)piles[i]/k);
        }
        return result;
    }

    public static void main(String[] args)  {

        int[] piles = {30,11,23,4,20};
        KokoEatingBananas37 obj = new KokoEatingBananas37();
        System.out.println(obj.minEatingSpeedBinarySearch(piles, 5));
    }
}
