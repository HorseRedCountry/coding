package offer;

import java.util.ArrayList;
import java.util.Collections;

/**题目描述：输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 *         则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *         PS：输入的字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *    思路：本质上是对字符的排列组合，重点在于排列组合的过程。而且，还需要考虑字符的重复情况
 *         如果没有重复字符，则将第一个字符固定，然后把后面的字符递归算出所有可能的组合。存
 *         储到数组中；然后，将第一个字符依次与后面的字符调换位置，每次调换后都递归算出所有
 *         可能的组合，存入数组中。运算完毕后，对数组进行排序。
 *         如果有重复的元素，可以在生成string后，判断list里面是否已经有了，有的话就不添加
 *         Step1 将输入的字符串分隔成单个字符
 *         Step2 固定首字母，将后面的依次调换；每次调换过后都把调换后的串存入list中，存入
 *               前，判断list中是否已经有该串，有的话就不存（为了处理掉重复字符）
 *         Step3 将首字母依次与后面的进行调换，再进行Step2
 *         Step4 首字母依次调换完毕后，把list中的串进行排序
 * @author Major Tom
 * @date 2020/7/17 11:21
 */
public class Permutation {
    public static ArrayList<String> permutation(String str){
        //存储排列组合后待打印的字符串
        ArrayList<String> result=new ArrayList<String>();
        //判断字符串是否为空串
        if (str == null||str.length()==0) {
            return result;
        }
        //将待处理的字符串转为字符数组
        char[] chars=str.toCharArray();
        //递归处理
        doPermutation(chars,0,result);
        //进行排序
        Collections.sort(result);
        return result;
    }

    /**回溯法求出所有的可能性
     * 计算出字符串的所有排列组合可能
     * @param chars 待处理的字符数组
     * @param i 数组下标从第几个开始
     * @param result
     */
    private static void doPermutation(char[] chars, int i, ArrayList<String> result) {
        if (i == chars.length-1) {
            String str=String.valueOf(chars);
            //判断list中是否已经有了当前str（处理字符重复的情况）
            if (!result.contains(str)) {
                result.add(str);
            }
        }else{
            for (int j = i; j < chars.length; j++) {
                //调换
                swap(chars,i,j);
                //递归，求出所有的可能性
                doPermutation(chars, i+1, result);
                //恢复调换前的状态，不然就乱套了
                swap(chars,i,j);
            }
        }
    }

    /**
     * 交换字符
     * @param chars
     * @param i
     * @param j
     */
    private static void swap(char[] chars, int i, int j) {
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }

    public static void main(String[] args) {
        ArrayList<String> perString=Permutation.permutation("abc");
        System.out.println(perString.toString());
        //输出：[abc, acb, bac, bca, cab, cba]
    }
}
