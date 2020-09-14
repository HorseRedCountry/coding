package offer;

import java.util.ArrayList;

/**
 * @author Major Tom
 * @date 2020/8/10 12:11
 * @description 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他
 *              在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,
 *              20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *      输出描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *         思路：思考了蛮久，但是总是想不出一个优雅的解决方案。没办法，只好去看下别人的思路。果然，跟大神一比，我简直连菜鸡都算不上......
 *              这道题可以用双指针技术来解决，即左右两边各定义两个指针，两个指针指向的数值一小一大，就像一个窗口一样，圈住指针内的数据域。
 *              符合要求的list就是窗口内的数据域，同时，若是窗口内的数据域不符合要求，就移动两个指针，直至符合要求为止。
 */
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){
        //储存结果
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        //low，high就相当于是两个指针，通过移动它们形成不同的数据域，以供判断
        int low=1,high=2;
        //结束条件，即窗口内一定得有值，而且不能越界
        while (high>low){
            //数据域为一个差值为1的等差序列，所以数据域的和就可以用等差数列求和公式取得：(a0+an)*n/2
            int cur=(high+low)*(high-low+1)/2;
            //如果符合要求，则依次将数据域中的值存入list中，并将list存入result
            if(cur==sum){
                ArrayList<Integer> list=new ArrayList<>();
                for(int i=low;i<=high;i++){
                    list.add(i);
                }
                result.add(list);
                low++;
                //如果当前数据域的和小于sum，则右指针右移
            }else if(cur<sum){
                high++;
                //若当前数据域的和大于sum，则左指针右移
            }else{
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findContinuousSequence(3));
    }
}
