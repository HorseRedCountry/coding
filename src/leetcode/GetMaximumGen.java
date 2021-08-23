package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2021/8/23 12:29
 * @description 获取生成数组的的最大值
 *
 * <p>
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * </p>
 */
public class GetMaximumGen {
    public static void main(String[] args) {
        System.out.println(getMax(3));
    }

    /**
     * 获取最大值
     *
     * @param n 输入
     * @return 数组最大值
     */
    static int getMax(int n) {
        if (n == 0) {
            return 0;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i <= n; ++i) {
            arr[i] = arr[i / 2] + i % 2 * arr[i / 2 + 1];
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}
