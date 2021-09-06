package leetcode;

/**
 * <p>
 * Leetcode 704 二分查找
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/6 13:51
 */
public class TwoPartitionSearch {
    public static void main(String[] args) {
        System.out.println(searchOfficial(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    /**
     * 我的解法，会数组下标溢出
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
     * 如果目标值存在返回下标，否则返回 -1。
     *
     * @param nums   升序数组
     * @param target 目标
     * @return 结果
     */
    static int search(int[] nums, int target) {
        return searching(nums, target, 0, nums.length - 1);
    }

    /**
     * 二分查找
     *
     * @param nums   数组
     * @param target 目标值
     * @param begin  开始下标
     * @param end    终止下标
     */
    static int searching(int[] nums, int target, int begin, int end) {
        if (begin == end) {
            return -1;
        }
        if (nums[begin] == target) {
            return begin;
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[end / 2] == target) {
            return end / 2;
        }
        if (nums[end / 2] > target) {
            return searching(nums, target, begin, end / 2);
        } else {
            return searching(nums, target, end / 2 + 1, end);
        }
    }

    /**
     * 官方解法
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值在数组中的下标
     */
    static int searchOfficial(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
