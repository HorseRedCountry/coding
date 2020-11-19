package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/11/19 15:17
 * @description 移动零
 */
public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes2(new int[]{0,1,0,3,12});
    }

    /**
     * 双指针解法
     * @param arr 待处理数组
     */
    private static void moveZeroes2(int[] arr) {
        int length=arr.length;
        //定义左右指针
        int left=0,right=0,temp=0;
        while (right<length){
            if (arr[right]!=0){
                temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
            }
            right++;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡法
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param arr 待处理数组
     */
    private static void moveZeroes(int[] arr) {
        //用冒泡排序的思想
        int length=arr.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length-1-i; j++) {
                if (arr[j]==0){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
