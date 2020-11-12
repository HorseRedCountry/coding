package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/11/12 11:30
 * @description 按奇偶排序数组II
 */
public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] arr=new int[]{4,2,5,7};
        System.out.println(Arrays.toString(arr));
        sortArrayByParityII(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     * @param arr 待排序数组
     */
    private static void sortArrayByParityII(int[] arr) {
        //临时变量，用于交换位置
        int temp=0;
        //遍历数组
        for (int i = 0; i < arr.length-1; i++) {
            if (i%2==0){
                if (arr[i]%2==0){
                    continue;
                }
                for (int j = i; j < arr.length; j++) {
                    if (arr[j]%2==0){
                        temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                        break;
                    }
                }
            }else{
                if (arr[i]%2!=0){
                    continue;
                }
                for (int j = i; j < arr.length; j++) {
                    if (arr[j]%2!=0){
                        temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                        break;
                    }
                }
            }
        }
    }
}
