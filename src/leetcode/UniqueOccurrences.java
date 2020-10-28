package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Major Tom
 * @date 2020/10/28 10:30
 * @description 独一无二出现的次数
 *              给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *              如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false
 */
public class UniqueOccurrences {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(unique2(new int[]{1,2,2,1,1,3}));
    }

    /**
     * 解法一：暴力法，记录下每个数字的出现次数，然后存入HashMap中，以出现次数为key，数值为value
     * @param arr
     * @return
     */
    private static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map=new HashMap<Integer, Integer>(0);
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i]==arr[j]){
                    count++;
                }
            }
            System.out.println(count);
            if (map.containsKey(count)&&map.get(count)!=arr[i]){
                return false;
            }
            map.put(count,arr[i]);
            count=0;
        }
        return true;
    }

    /**
     * 解法二：首先使用哈希表记录每个数字的出现次数；随后再利用新的哈希表，统计不同的出现次数的数目。如果不同的出现次数的数目等于不同数字的数目，
     *        则返回 true，否则返回 false
     * @param arr
     * @return
     */
    private static boolean unique2(int[] arr){
        Map<Integer, Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            //map.getOrDefault(key,defaultValue):如果指定key值的从value不存在，则使用defaultValue
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> set=new HashSet<>(map.values());
        return map.size()==set.size();
    }
}
