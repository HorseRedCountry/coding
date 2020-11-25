package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/11/25 13:18
 * @description 上升下降字符串
 */
public class SortString {
    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
    }

    /**
     * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
     *
     *     从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
     *     从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
     *     重复步骤 2 ，直到你没法从 s 中选择字符。
     *     从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
     *     从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
     *     重复步骤 5 ，直到你没法从 s 中选择字符。
     *     重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
     *
     * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
     *
     * 请你返回将 s 中字符重新排序后的 结果字符串
     * @param s 待处理字符串
     * @return 结果字符串
     */
    private static String sortString(String s) {
        if (s==null||s.length()<=1){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        char[] chs=s.toCharArray();
        //桶排序的思想，存储26个字母出现的次数
        int[] baseChar=new int[26];
        for (char ch : chs) {
            baseChar[ch-'a']++;
        }
        while (sb.length()!=s.length()){
            //第一轮正序
            for (int i = 0; i < baseChar.length; i++) {
                if (baseChar[i]==0){
                    continue;
                }
                sb.append((char)('a'+i));
                baseChar[i]--;
            }
            //第二轮倒序
            for (int i = baseChar.length-1; i >= 0; i--) {
                if (baseChar[i]==0){
                    continue;
                }
                sb.append((char) ('a'+i));
                baseChar[i]--;
            }
        }
        return sb.toString();
    }
}
