package offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/8/23 21:51
 * @description
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        int[] arr=new int[count];
        for (int i = 0; i < count; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findMin(arr));
    }
    /**
     * 思路：刷的最少次数是由这批木板中最长的和最短的之间的高度差决定的
     */
    public static int findMin(int[] arr){
        //先对数组进行排序
        Arrays.sort(arr);
        //求出最长木板和最短木板之间的差值
        int min2Max=arr[arr.length-1]-arr[0];
        //如果差值小于最短的木板，那说明这批木板的长度趋于相同，则刷的次数为min2Max+最短木板
        if(min2Max<arr[0]){
            return min2Max+arr[0];
        }else{
            return arr[arr.length];
        }
    }
}
