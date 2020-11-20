package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/11/20 14:08
 * @description 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{6,5,3,1,8,7,0,4})));
    }

    /**
     * 插入排序
     * @param nums 待排序数组
     * @return 已完成的排序
     */
    private static int[] insertionSort(int[] nums) {
        int length=nums.length;
        int[] result=new int[length];
        result[0]=nums[0];
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]<result[j]){
                    move(result,nums[i],i,j);
                    break;
                }
                if (j==i-1){
                    result[i]=nums[i];
                }
            }
        }

        return result;
    }

    /**
     * 数组元素往后移动
     * @param result
     * @param num
     * @param i
     * @param j
     */
    private static void move(int[] result, int num, int i,int j) {
        for (int k = i; k > j; k--) {
            result[k]=result[k-1];
        }
        result[j]=num;
    }
}
