package leetcode;


/**
 * <p>
 * LeetCode725. 分隔链表
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/22 10:47
 */
public class SplitListToParts {
    public static void main(String[] args) {

    }

    /**
     * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
     * <p>
     * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
     * <p>
     * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
     * <p>
     * 返回一个由上述 k 部分组成的数组。
     *
     * @param head 链表头
     * @param k 整数
     * @return 分成 K 份后的链表
     */
    static ListNode[] solution(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int quotient = n / k, remainder = n % k;

        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }
}
