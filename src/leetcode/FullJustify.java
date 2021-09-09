package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * LeetCode68.文本左右对齐
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/9 13:07
 */
public class FullJustify {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
    }

    /**
     * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
     * <p>
     * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
     * <p>
     * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
     * <p>
     * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
     * <p>
     * 说明:
     * <p>
     * 单词是指由非空格字符组成的字符序列。
     * <p>
     * 每个单词的长度大于 0，小于等于 maxWidth。
     * <p>
     * 输入单词数组 words 至少包含一个单词。
     * <p>
     *
     * @param words 单词数组
     * @param maxWidth 单词
     * @return 两端对齐的文本
     */
    static List<String> solution(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        int right = 0, n = words.length;
        while (true) {
            // 当前行的第一个单词在 words 的位置
            int left = right;
            // 统计这一行单词长度之和
            int sumLen = 0;
            // 循环确定当前行可以放多少单词，注意单词之间应至少有一个空格
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            // 当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
            if (right == n) {
                StringBuffer sb = join(words, left, n, " ");
                sb.append(blank(maxWidth - sb.length()));
                ans.add(sb.toString());
                return ans;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            // 当前行只有一个单词：该单词左对齐，在行末填充剩余空格
            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                ans.add(sb.toString());
                continue;
            }

            // 当前行不只一个单词
            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            // 拼接额外加一个空格的单词
            sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1)));
            sb.append(blank(avgSpaces));
            // 拼接其余单词
            sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces)));
            ans.add(sb.toString());
        }
    }

    /**
     * blank 返回长度为 n 的由空格组成的字符串
     * @param n /
     * @return /
     */
    static String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }

    /**
     * join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
     * @param words /
     * @param left /
     * @param right /
     * @param sep /
     * @return /
     */
    static StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; ++i) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }
}
