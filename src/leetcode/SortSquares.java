package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/10/16 11:14
 * @description 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *              思路：对各个元素求绝对值
 */
public class SortSquares {
    public static void main(String[] args) {
        int[] arr=new int[]{-7,-2,0,1,5};
        //int[] arr=new int[]{-7};
        SortSquares sort=new SortSquares();
        //sort.sortSquares(arr);
        System.out.println(Arrays.toString(sort.sortSquares(arr)));
    }

    public int[] sortSquares(int[] A){
//        if (A.length==1){
//            A[0]=A[0]*A[0];
//            return A;
//        }
        if (A[0]>=0){
            for (int i = 0; i < A.length; i++) {
                A[i]=A[i]*A[i];
            }
            return A;
        }
        if (A[A.length-1]<=0){
            int[] result=new int[A.length];
            int j=0;
            for (int i = A.length-1; i >= 0 ; i--) {
                result[j]=A[i]*A[i];
                j++;
            }
            return result;
        }
        for (int i = 0; i < A.length; i++) {
            A[i]=Math.abs(A[i]);
        }
        for (int i = 0; i <A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {
                if(A[j]<A[i]){
                    swap(A,i,j);
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i]=A[i]*A[i];
        }
        return A;
    }

    private void swap(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
