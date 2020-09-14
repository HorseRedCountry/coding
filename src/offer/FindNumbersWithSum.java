package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Major Tom
 * @date 2020/8/14 12:26
 * @description 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，
 *              输出两个数的乘积最小的。
 *              输出描述：对应每个测试案例，输出两个数，小的先输出。
 *              思路：用的穷举法，硬遍历，找到适合的然后存入HashMap中，然后再对HashMap中每一对的成绩进行比较，挑出
 *                   乘积最小的存入list中
 */
public class FindNumbersWithSum {
    public static ArrayList<Integer> findNumbersWithSum(int[] array,int sum){
        //用于存储和为sum的每一对数字
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        //用于存储成绩最小的那一对数字
        ArrayList<Integer> list=new ArrayList<Integer>();
        //由于数组是递增的，所以第一个就不小于sum的话就没必要往后处理了
        if (array.length==0||array[0] >= sum) {
            return list;
        }
        //遍历array，把每一对和为sum的元素都给挑出来
        for (int i = 0; i < array.length&&array[i]<sum; i++) {
            for (int j = i+1; j < array.length&&array[j]<sum; j++) {
                if(array[i]+array[j]==sum){
                    map.put(array[i],array[j]);
                }
            }
        }
        if (map==null)
            return null;
        //遍历map，挑出乘积最小的那一对
        Iterator iterator=map.entrySet().iterator();
        int m=0;
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry= (Map.Entry<Integer, Integer>) iterator.next();
            //m赋初始值
            m=m==0?entry.getKey()*entry.getValue():m;
            //遍历的第一组，必须存入list中，以此为基准
            if(list.isEmpty()){
                list.add(entry.getKey());
                list.add(entry.getValue());
            }
            //若找到乘积更小的，就把之前list中的元素统统移除，m也重新赋值
            if (m>entry.getKey()*entry.getValue()){
                list.remove(0);
                list.remove(0);
                list.add(entry.getKey());
                list.add(entry.getValue());
                m=entry.getKey()*entry.getValue();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findNumbersWithSum(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},21));//[1, 20]
        System.out.println(findNumbersWithSum(new int[]{},0));//[]
    }
}
