package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <p>
 * LeetCode502 IPO
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/8 10:51
 */
public class FindMaximizedCapital {
    public static void main(String[] args) {
        System.out.println(find(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }

    /**
     * <p>
     * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源
     * 有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
     * </p>
     * <p>
     * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
     * </p>
     * <p>
     * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
     * </p>
     * <p>
     * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
     * 答案保证在 32 位有符号整数范围内。
     * <p>
     *
     * @param k       项目总数
     * @param w       初始资本
     * @param profits 纯利润
     * @param capital 最小资本
     * @return 最大化的最终资本
     */
    static int find(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }
}
