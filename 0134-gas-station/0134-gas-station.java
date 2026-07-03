// If a solution to exists, total(gas) >= total(cost) else you can't travel to destination
// If i can't start from a station, i expect to start from next station (cause a sol will exist due to above condition)
// what if two or more continuous stations has positive difference [gas[i]-cost[i] >= 0] ?, still i will hope last+1'th station to be the starting point
// If that last+1'th station fails, 0 <--> last-1'th station can't be the starting point, since even though 0 <--> last-2'th station brought a positive tank (remaining gas), i can't move forward (brougth gas + mine gas)

// so, the last beleived station will be the starting point

// previous accepted submission combined this into one loop

// tc: O(n)
// sc: O(1)

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, start = 0, fuelTank = 0;

        for(int i=0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas < totalCost)return -1; // can't 

        for(int i=0;i<gas.length;i++){
            int balance = gas[i]-cost[i];
            fuelTank += balance;

            if(fuelTank < 0){
                start = i+1; // hope
                fuelTank = 0; // start from i+1'th station
            }
        }

        return start;
    }
}