package offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入
 *         一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 *         超过数组长度的一半，因此输出2。如果不存在则输出0。
 *         思路：可以用HashMap来存，HashMap键不可重复，值可重读，所以就一直update值即可
 *         Step1 遍历数组，如果数值的键存在，则将键对应的值取出后+1，然后再存进去
 *         Step2 遍历并存储完毕后，以数组元素总数的一半+1为界限开始反向查找，以值寻键。若
 *               找到，返回键，否则返回0
 * @author Major Tom
 * @date 2020/7/21 14:15
 */
public class FindMoreThanHalfNum {
    public static int findNum(int[] nums){
        //判断是数组是不是只有一个元素
        if (nums.length == 1) {
            return nums[0];
        }
        //key存元素，value存元素的个数
        Map<Integer,Integer> numsMap=new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(nums[i])){
                numsMap.put(nums[i],numsMap.get(nums[i])+1);
            }else{
                numsMap.put(nums[i],1);
            }
        }
        //数组元素总数的一半+1，即边界条件：若数组中有元素的个数大于此值就返回数组元素的值
        int border=nums.length/2+1;
        while (border<nums.length){
            if (numsMap.containsValue(border)) {
                return getKey(numsMap,border);
            }
            border++;
        }
        return 0;
    }
    //通过value找key
    private static int getKey(Map<Integer, Integer> numsMap, int border) {
        Iterator it=numsMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,Integer> entry= (Map.Entry<Integer, Integer>) it.next();
            if (border == entry.getValue()) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,3,3,3,3,3,2,2,5,4};
        System.out.println(FindMoreThanHalfNum.findNum(nums));
    }
}
