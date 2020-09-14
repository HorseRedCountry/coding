package offer;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020-07-31 10:13
 *
 * 题目描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *         例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *    思路：仔细思考一下，这个问题的解法其实就是依次比较相邻两个元素按照不同的先后顺序组合后形成的值的
 *         大小，把形成的值较小的组合次寻添加入string中
 *         Step1 对array进行排序，按照从小到大的顺序
 *         Step2 依次比较各种不同的组合形式，将较小的加入String
 */
public class PrintMinNumber {
    public static String printMinNumber(long[] arr){
        //排序，必须按照从小到大的顺序
        Arrays.sort(arr);
        //首元素转为字符串，便于比较
        String str= String.valueOf(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            //比较按照不同的先后顺序形成的值的大小
            if (Long.valueOf(str+arr[i])>Long.valueOf(arr[i]+str)){
                str=arr[i]+str;
            }else {
                str=str+arr[i];
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(printMinNumber(new long[]{3334,3,3333332}));
        //Output:333333233334
    }
}
