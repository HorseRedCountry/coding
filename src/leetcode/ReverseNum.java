package leetcode;

/**
 * @author Major Tom
 * @date 2021/8/25 12:53
 * @description 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 ，就返回 0。
 */
public class ReverseNum {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    /**
     * 输入为1534236469会报错
     *
     * @param num 输入
     * @return 结果
     */
    static int reverse(int num) {
        String numStr = Integer.toString(num);
        char[] chars = numStr.toCharArray();
        String result = "";
        int n = 0;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] == '0') {
                continue;
            } else {
                n = i;
                break;
            }
        }
        if (chars[0] == '-') {
            result += "-";
            for (int i = n; i > 0; i--) {
                result += chars[i];
            }
        } else {
            for (int i = n; i >= 0; i--) {
                result += chars[i];
            }
        }
        if (null == result || "".equals(result)) {
            return 0;
        } else {
            return Integer.parseInt(result);
        }
    }

    /**
     * LeetCode解法
     *
     * @param x 输入
     * @return 结果
     */
    static int leetReverse(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
}
