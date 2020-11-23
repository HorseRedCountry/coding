package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/11/23 13:38
 * @description 用最少数量的箭引爆气球
 */
public class FindMinArrowShots {
    public static void main(String[] args) {
        int[][] points=new int[][]{
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };
        System.out.println(findMinArrowShots(points));
    }

    /**
     * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，
     * 所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
     * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为
     * xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦
     * 被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
     * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
     *
     * 思路：贪心算法
     *
     * @param points 气球分布
     * @return 最少射击次数
     */
    private static int findMinArrowShots(int[][] points) {
        if (points.length<1){
            return 0;
        }
        //先对气球的分布进行排序
        Arrays.sort(points,(a,b)->(a[1]-b[1]));
        int shots=1;
        //第一个气球的右边界
        int axis=points[0][1];
        for (int i = 1; i < points.length; i++) {
            //最右边的气球的左边界一定要位于第一个气球的右边界内
            //如果越界，则说明一支弓箭搞不定
            if (axis<points[i][0]){
                shots++;
                axis=points[i][0];
            }
        }
        return shots;
    }
}
