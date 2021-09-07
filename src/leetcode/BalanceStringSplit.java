package leetcode;

/**
 * <p>
 * LeetCode1221 分割平衡字符串
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/7 11:42
 */
public class BalanceStringSplit {
    public static void main(String[] args) {
        System.out.println(split("RLRRLLRLRL"));
    }

    /**
     * <p>
     * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
     * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * 注意：分割得到的每个字符串都必须是平衡字符串。
     * 返回可以通过分割得到的平衡字符串的 最大数量 。
     * </p>
     *
     * @param s 平衡字符串
     * @return 最大数量
     */
    static int split(String s) {
        int result = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                ++d;
            } else {
                --d;
            }
            if (d == 0) {
                ++result;
            }
        }
        return result;
    }
}
