package leetcode;

/**
 * @author Major Tom
 * @date 2021/8/24 13:06
 * @description 字符串中第一个唯一字符
 */
public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(getFirst("majortom"));
    }

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * @param s 字符串
     * @return 字符位置，即数组下标
     */
    static int getFirst(String s){
        int[] nums=new int[26];
        int n=s.length();
        for (int i = 0; i < n; i++) {
            nums[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (nums[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
