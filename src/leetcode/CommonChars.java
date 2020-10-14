package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Major Tom
 * @date 2020/10/14 17:11
 * @description 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 *              例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 */
public class CommonChars {
    public static void main(String[] args) {
        String[] strs=new String[]{"bella","label","roller"};
        System.out.println(commonChars(strs).toString());
    }
    public static List<String> commonChars(String[] A){
        //定义个数组，记录各个子串中字符出现的频率
        //charCount将作为对比的基准
        int[] charCount=new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            //A[0].charAt(i)得出子串中第i个元素的值，减去‘a’得出该字符距‘a’的步长，故charCount后
            //便定位至第几个字母
            charCount[A[0].charAt(i)-'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            //从第二个子串开始遍历，再次记录各个字符出现的次数
            int[] curChar=new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                curChar[A[i].charAt(j)-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                charCount[j]=Math.min(charCount[j],curChar[j]);
            }
        }
        List<String> result=new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (charCount[i]!=0){
                result.add(String.valueOf((char)(i+'a')));
                charCount[i]--;
            }
        }
        return result;
    }
}
