package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/10/26 21:05
 * @description 有多少小于当前数字的数字
 */
public class SmallerNumberThanCurrent {
    public static void main(String[] args) {
        int[] nums=new int[]{8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumber2(nums)));
    }

    /**
     * 解法一：暴力比较，时间复杂度较高
     * @param nums
     * @return
     */
    private static int[] smallerNumber(int[] nums) {
        int[] result=new int[nums.length];
        //遍历，直接比
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    count++;
                }
            }
            result[i]=count;
            count=0;
        }
        return result;
    }

    /**
     * 解法二：计数排序，时间复杂度较低
     * @param nums
     * @return
     */
    private static int[] smallerNumber2(int[] nums){
        int[] cnt=new int[101];
        int n= nums.length;
        //记录数值个数
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i]+=cnt[i-1];
        }
        int[] result=new int[n];
        for (int i = 0; i < n; i++) {
            result[i]=nums[i]==0?0:cnt[nums[i]-1];
        }
        return result;
    }
}
