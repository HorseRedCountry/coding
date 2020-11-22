package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/11/22 20:22
 * @description 有效的字母异位词
 */
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        char[] charS=s.toCharArray();
        char[] charT=t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return Arrays.toString(charS).equals(Arrays.toString(charT));
    }
}
