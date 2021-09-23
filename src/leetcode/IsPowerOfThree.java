package leetcode;

/**
 * <p>
 * LeetCode326. 3的幂
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/23 11:30
 */
public class IsPowerOfThree {
    public static void main(String[] args) {

    }

    /**
     * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3的x次幂
     *
     * @param n 待判定证整数
     * @return 是否为3的幂
     */
    static boolean solution(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
