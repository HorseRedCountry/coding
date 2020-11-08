package leetcode;

/**
 * @author Major Tom
 * @date 2020/11/8 15:00
 * @description 买卖股票的最佳时机II
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润，
     * 你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * @param price 股票的价格走势
     * @return 最大利润
     */
    private static int maxProfit(int[] price) {
        int max=0;
        //扫描一遍，只要后一天的价格比前一天大，就把价格差值相加
        for (int i = 1; i < price.length-1; i++) {
            if (price[i]>price[i-1]){
                max+=price[i]-price[i-1];
            }
        }
        return max;
    }
}
