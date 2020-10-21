package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Major Tom
 * @date 2020/10/21 19:30
 * @description 消除重复数字 给定一个正整数，给出消除重复数字以后最大的整数
 */
public class DuplicationMax {
    public static void main(String[] args) {
        System.out.println(duplicationMax(423234));
    }

    private static long duplicationMax(long i) {
        //用来计数，如果前面出现了0-9所有数，则提前结束循环
        List<Integer> list=new ArrayList<>();
        //利用桶计数的方法判断那个值出现过
        int[] count=new int[10];
        while (i!=0){
            int temp= (int) (i%10);
            count[temp]++;
            //list里面存放没有出现的值
            if (list.contains(temp)){
                list.add(temp);
            }
            //判断是否提前结束循坏
            if (list.size()==10){
                break;
            }
            i=i/10;
        }
        //生成结果
        long res=0;
        for (int j = count.length-1; j >= 0; j--) {
            if (count[j]!=0){
                res=res*10+j;
            }
        }
        return res;
    }
}
