package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * LeetCode524. 通过删除字母匹配到字典里最长单词
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/14 22:33
 */
public class FindLongestWord {
    public static void main(String[] args) {
        System.out.println(solution("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }

    /**
     * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
     * <p>
     * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
     *
     * @param s 字符串
     * @param dictionary 字符串数组
     * @return 长度最长且字典序最小的字符串
     */
    static String solution(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }
}
