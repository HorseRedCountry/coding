package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>
 *  重构字符串
 * </P>
 *
 * @author Major Tom
 * @since 2020/11/30 18:10
 */
public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString2("aab"));
    }

    /**
     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     * 若可行，输出任意可行的结果。若不可行，返回空字符串。
     * @param S 源字符串
     * @return 结果
     */
    private static String reorganizeString(String S) {
        //字符串变为字符数组
        char[] chs=S.toCharArray();
        int[] baseChar=new int[26];
        for (char ch : chs) {
            baseChar[ch-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        while (sb.length()!=S.length()){
            for (int i = 0; i < 26; i++) {
                if (baseChar[i]==0){
                    continue;
                }
                if(sb.length()>0&&sb.charAt((sb.length()-1))==((char)(i+'a'))){
                    return null;
                }
                sb.append((char)(i+'a'));
                baseChar[i]--;
            }
        }
        return sb.toString();
    }

    /**
     * 运用大顶堆的思想
     * @param S 待处理字符串
     * @return 结果
     */
    private static String reorganizeString2(String S){
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
