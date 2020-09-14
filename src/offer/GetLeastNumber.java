package offer;

import java.util.ArrayList;

/**题目描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *    思路：先把数组整体按照从小到大的顺序排序，然后输出排序后的前k个数即可
 *         Step1 对数组进行排序，冒泡快排都行
 *         Step2 遍历输出排序后的钱k个元素，构造list
 * @author Major Tom
 * @date 2020/7/22 8:55
 */
public class GetLeastNumber {
    public static ArrayList<Integer> getNums(int[] input,int k){
        ArrayList<Integer> numsList=new ArrayList<Integer>();
        //判断：如果k大于数组的长度，直接把空list返回
        if (k>input.length)
            return numsList;
        //排序
        for (int i = 0; i < input.length; i++) {
            for (int j = i+1; j < input.length; j++) {
                if (input[j]<input[i]){
                    int temp=input[j];
                    input[j]=input[i];
                    input[i]=temp;
                }

            }
        }
        //输出满足要求的元素
        for (int i = 0; i < k; i++) {
            numsList.add(input[i]);
        }

        return numsList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums=GetLeastNumber.getNums(new int[]{4,5,1,6,2,7,3,8},4);
        System.out.println(nums.toString());
        //输出：[1, 2, 3, 4]
    }
}
