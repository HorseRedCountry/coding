package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * LeetCode575.分糖果
 * </P>
 *
 * @author Major Tom
 * @since 2021/11/1 20:12
 */
public class DistributeCandies {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3}));
    }

    /**
     * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
     * <p>
     * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，
     * 尽可能吃到最多不同种类的糖。
     * <p>
     * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数。
     *
     * @param candiesArr 糖果数组
     * @return 可以吃到糖的最多种类数
     */
    static int solution(int[] candiesArr) {
        int maxCandies = 0;
        for (int k : candiesArr) {
            maxCandies = maxCandies + k;
        }
        maxCandies = maxCandies / 2;
        Arrays.sort(candiesArr);
        int result = 0;
        for (int j : candiesArr) {
            if (result > maxCandies) {
                break;
            }
            result = result + j;
        }
        return result;
    }

    /**
     * 贪心解法（官方）
     *
     * @param candiesArr 糖果数组
     * @return 可以吃到的糖果最多种类数
     */
    static int solution2(int[] candiesArr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int candy : candiesArr) {
            set.add(candy);
        }
        return Math.min(set.size(), candiesArr.length / 2);
    }
}
