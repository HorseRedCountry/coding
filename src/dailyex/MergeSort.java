package dailyex;

import java.util.Arrays;

/*
    归并排序：建立在归并操作上的一种排序方法，该算法采用分治法的思想，排序稳定
     时空度：平均时间复杂度O(nlogn)  最好O(nlogn)  最坏O(nlogn) 空间复杂度O(n)
   算法描述：把原序列分成若干个子序列，然后对子序列进行排序。子序列排序完成后，将有序的
          子序列合并，得到完全有序的序列
          Step1 将长度为n的输入序列分成两个长度为n/2的子序列
          Step2 对这两个子序列分别进行归并排序
          Step3 将两个排序好的子序列合并
 */
public class MergeSort {
    public static int[] mergeSort(int[] arr){
        //判断数组长度
        if (arr.length<2) {
            return arr;
        }
        //拆分的中间点
        int mid=arr.length/2;
        int[] left= Arrays.copyOfRange(arr,0,mid);
        int[] right=Arrays.copyOfRange(arr,mid,arr.length);
        return merge(mergeSort(left),mergeSort(right));
    }
    //二路归并排序
    public static int[] merge(int[] left, int[] right) {
        //存储排序后的结果
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{2,3,1,5,6,4};
        int[] newArr=mergeSort(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]+"  ");//1  2  3  4  5  6
        }
    }
}
