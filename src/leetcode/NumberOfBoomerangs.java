package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * LeetCode447. 回旋镖的数量
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/13 12:27
 */
public class NumberOfBoomerangs {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0},{1,0},{2,0}}));
    }

    /**
     * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离
     * 和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     * <p>
     * 返回平面上所有回旋镖的数量。
     *
     * @param points 点集合
     * @return 所有回旋镖的数量
     */
    static int solution(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }
}
