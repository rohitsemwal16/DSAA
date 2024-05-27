package org.rosemwal.dsa.array;

public class PetrolPump320 {

    public static void main(String[] args)  {

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuitSingleLoop(gas, cost));
        System.out.println(canCompleteCircuitDoubleLoop(gas, cost));
    }

    public static int canCompleteCircuitSingleLoop(int[] gas, int[] cost) {

        int len = gas.length;
        int gasTank = 0;
        int start = 0;

        int sum = 0;

        for (int i=0; i<len; i++)   {
            sum+= gas[i]-cost[i];
        }

        if(sum<0)
            return -1;

        for (int i=0; i<len; i++)   {

            gasTank += gas[i] - cost[i];

            if(gasTank < 0) {
                gasTank = 0;
                start = i+1;
            }
        }
        return gasTank>=0 ? start : -1;
    }

    public static int canCompleteCircuitDoubleLoop(int[] gas, int[] cost) {

        int len = gas.length;

        for(int i=0; i<len; i++)    {
            if (checkIfSufficientGas(i, len, gas, cost)) {
                return i;
            }
        }
        return -1;
    }

     static boolean checkIfSufficientGas(int index, int n, int[] gas, int[] cost)   {
         int count = 0;
         int rem = 0;

         while(count<n)    {
             rem += gas[index%n] -cost[index%n] + gas[(index+1)%n];
             if(rem>=gas[(index+1)%n])   {
                 rem = rem-gas[(index+1)%n];
             }   else    {
                 return false;
             }
             index++;
             count++;
         }
         return true;
     }
}
