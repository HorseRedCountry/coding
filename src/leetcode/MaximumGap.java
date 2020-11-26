package leetcode;

import java.util.Arrays;

/**
 * <p>
 *  最大间距
 * </P>
 *
 * @author Major Tom
 * @since 2020/11/26 15:57
 */
public class MaximumGap {
    public static void main(String[] args) {
        System.out.println(maxiMumGap(new int[]{3,6,9,1}));
    }

    /**
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     * 如果数组元素个数小于 2，则返回 0。
     * @param nums 待处理数组
     * @return 相邻元素的最大差值
     */
    private static int maxiMumGap(int[] nums) {
        int max=0;
        if (nums.length<2){
            return max;
        }
        //排序
        Arrays.sort(nums);
        max=nums[1]-nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i+1]-nums[i]>max){
                max=nums[i+1]-nums[i];
            }
        }
        return max;
    }
}
