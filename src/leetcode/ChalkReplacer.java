package leetcode;

/**
 * <p>
 * LeetCode1894.找到需要补充粉笔的学生编号
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/10 9:56
 */
public class ChalkReplacer {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 5}, 22));
    }

    /**
     * 一个班级里有 n 个学生，编号为 0 到 n - 1 。每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，直到编号为
     * n - 1 的学生，然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
     * <p>
     * 给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。一开始粉笔盒里总共有 k 支粉笔。当编号为 i 的学生回答问题时，他会消耗
     * chalk[i] 支粉笔。如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。
     * <p>
     * 请你返回需要 补充 粉笔的学生 编号 。
     * <p>
     *
     * @param k 粉笔数
     * @return /
     */
    static int solution(int[] chalk, int k) {
        int n = chalk.length;
        long total = 0;
        for (int num : chalk) {
            total += num;
        }
        k %= total;
        int res = -1;
        for (int i = 0; i < n; ++i) {
            if (chalk[i] > k) {
                res = i;
                break;
            }
            k -= chalk[i];
        }
        return res;
    }
}
