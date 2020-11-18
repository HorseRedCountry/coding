package leetcode;

/**
 * @author Major Tom
 * @date 2020/11/18 15:07
 * @description 加油站问题
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas=new int[]{1,2,3,4,5};
        int[] cost=new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    /**
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油
     *  cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * @param gas
     * @param cost
     * @return
     */
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
