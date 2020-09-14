package offer;


/**
 * @author Major Tom
 * @date 2020-08-03 11:38
 *
 * 题目描述：把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 *         习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *    思路：由丑数的定义可知，一个丑数的因子只有2,3,5.也就是说，任意一个丑数都可以由另一个丑数乘以2或者乘以3或者
 *         乘以5获得。所以，可以从1开始，乘以2,3,5，然后把乘得的数和之前的1一起放入数组中，然后再把数组中的每个
 *         数分别乘以2,3,5，剔除重复的元素，然后把第n个返回。
 */
public class UglyNumber {
    public static int getUglyNumber(int index){
        if(index<=0)
            return 0;
        int[] result = new int[index];
        int count = 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        result[0] = 1;
        int tmp = 0;
        while (count < index-1) {
            tmp = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
            if(tmp==result[i2] * 2) i2++;
            if(tmp==result[i3] * 3) i3++;
            if(tmp==result[i5]*5) i5++;
            result[++count]=tmp;
        }
        return result[index - 1];
    }
    private static int min(int a, int b) {
        return (a > b) ? b : a;
    }
}
