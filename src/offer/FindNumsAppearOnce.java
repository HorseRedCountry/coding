package offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author Major Tom
 * @Date 2020-08-07 12:14
 * @Description 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *              PS:num1,num2分别为长度为1的数组。传出参数
 *                 将num1[0],num2[0]设置为返回结果
 *              思路：方法1:遍历数组，用HashMap存储每一个数字，以数字的值为key，出现的次数为value
 *                   存储完毕后，再把HashMap中value为1的数输出。
 *                   方法2：遍历数组，用HashMap存储每一个数字，以数字的值为key，遍历过程中若出现containskey
 *                         的情况，就把结点移除。遍历完毕后，HashMap中便只存在两个只出现一次的键值对。遍历完毕
 *                         后，把HashMap转成数组。
 */
public class FindNumsAppearOnce {
    //方法2
    public static void findNumsAppearOnce(int[] array,int[] num1,int[] num2){
        HashMap<Integer,Integer> arrMap=new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            //遍历存储数组中的数字入表
            if (arrMap.containsKey(array[i])){
                arrMap.put(array[i],arrMap.get(array[i])+1);
            }else{
                arrMap.put(array[i],1);
            }
        }
        int flag=0;
        //存储只出现一次的数字
        int[] nums=new int[2];
        Iterator arrIterator=arrMap.entrySet().iterator();
        //遍历HashMap，flag是为了降低时间复杂度
        while (arrIterator.hasNext()&&flag<2){
            Map.Entry<Integer,Integer> entry= (Map.Entry<Integer, Integer>) arrIterator.next();
            if(entry.getValue()==1){
                nums[flag]=entry.getKey();
                flag++;
            }
        }
        num1[0]=nums[0];
        num2[0]=nums[1];
        System.out.println(num1[0]+"....."+num2[0]);
    }
    //方法2
    public static void findNumsAppearOnceLowTimes(int[] array,int[] num1,int[] num2){
        HashMap<Integer,Integer> arrayMap=new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            //移除重复的元素
            if (arrayMap.containsKey(array[i])){
                arrayMap.remove(array[i]);
            }else{
                arrayMap.put(array[i],1);
            }
        }
        Object[] arr=arrayMap.keySet().toArray();
        num1[0]=Integer.parseInt(arr[0].toString());
        num2[0]=Integer.parseInt(arr[1].toString());
        System.out.println(num1[0]+"....."+num2[0]);
    }
    public static void main(String[] args) {
        findNumsAppearOnceLowTimes(new int[]{1,2,2,3,3,4},new int[1],new int[1]);
        //output:1.....4
    }
}
