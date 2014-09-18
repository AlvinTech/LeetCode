/**   Gas Station
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 *
 */
/**
 * 思路：开始下一段路之前，储量必须大于下一段路的开销

 */
public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] dif = new int[gas.length +1];
        for(int i =0;i< gas.length;i++){
            dif[i] = gas[i] - cost[i];
            dif[dif.length-1] += dif[i];
        }
        if(dif[dif.length-1] < 0)
            return -1;

        int length  = gas.length;
        int  tank  = 0;
        for(int i =0;i< gas.length;i++){
            if(dif[i] >= 0 ){
                tank = 0;
                for(int j =0;j< length ;j++){
                    tank+= dif[(j+i)% length];
                    if(tank < 0){
                        // imprtent
                        i=(i+j)%length;
                        break;
                    }
                }
                if(tank >=0)return i;
            }
        }
        return -1;
    }
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        for(int i =0;i< gas.length;i++){
            if(gas[i] >= cost[i]){
                if(canFinish(gas,cost,i))
                    return i;
            }
        }
        return -1;
    }
    public boolean canFinish(int[] gas,int[] cost, int start){
        int length = gas.length;
        int tank =0;
        for(int i =0 ;i< length;i++){
            tank = tank + gas[i%length] -cost[i%length];
            if(tank < 0)
                return false;
        }
        return true;

    }
    public static void main(String[] args) {
        int[] gas={1,2,3,3,1,2,3,3,1,2,3,3,1,2,3,3,1,2,3,3,};
        int[] cost ={2,1,5,1,2,1,5,1,2,1,5,1,2,1,5,1,2,1,5,1,};
        System.out.println(new Gas_Station().canCompleteCircuit(gas, cost));
        System.out.println(12549.0/51529);

    }

}
