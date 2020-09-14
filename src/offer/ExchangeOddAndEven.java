package offer;
/*
    题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数
            位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶
            树和偶数之间的相对位置不变
       思路：Step1 遍历该数组，获取到该数组中偶数元素的个数
            Step2 新建两个数组，一个用来存储偶数元素，长度为count；
                  一个用来存储奇数元素，长度为array.length-count
            Step3 再次遍历该数组，将偶数元素加入到偶数数组
                  奇数元素存储到奇数数组
            Step4 合并两个数组，奇数数组在前，偶数数组在后

 */
public class ExchangeOddAndEven {
    public static void reOrderArray(int[] array){
        int count=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2 == 0) {
                count++;
            }
        }
        int[] evenArr=new int[count];
        int m=0,n=0;
        int[] oddArr=new int[array.length-count];
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2 == 0) {
                evenArr[m]=array[i];
                m++;
            }else{
                oddArr[n]=array[i];
                n++;
            }
        }
        System.arraycopy(oddArr,0, array, 0, oddArr.length);
        System.arraycopy(evenArr,0, array, oddArr.length, evenArr.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr={1,4,8,3,7,9,6,10,5};
        ExchangeOddAndEven.reOrderArray(arr);
    }
}
