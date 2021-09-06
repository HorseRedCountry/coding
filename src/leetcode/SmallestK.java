package leetcode;

import java.util.Arrays;

/**
 * <p>
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/3 14:53
 */
public class SmallestK {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smalleatOptimized(new int[]{0, 5, 8, 6, 4, 5, 5, 9, 7, 2, 3}, 6)));
    }

    /**
     * 找出数组中最小的k个数
     * 思路：选择排序，但是时间复杂度过高
     *
     * @param arr 数组
     * @param k   最小数个数
     * @return 最小的K个数
     */
    static int[] smallest(int[] arr, int k) {
        int[] result = new int[k];
        int temp = 0;
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            result[i] = arr[i];
        }
        return result;
    }

    static int[] smalleatOptimized(int[] arr,int k){
        int[] result = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }
}
