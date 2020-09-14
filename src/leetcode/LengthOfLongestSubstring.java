package leetcode;

import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/9/14 16:55
 * @description 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(s);
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        char[] chars=s.toCharArray();
        String str="";
        int longest=0;
        for (int i = 0; i < chars.length; i++) {
            str=str+chars[i];
            for (int j = i+1; j < chars.length; j++) {
                if(str.contains(chars[j]+"")){
                    break;
                }
                str=str+chars[j];
            }
            if(str.length()>=longest){
                longest=str.length();
            }
            str="";
        }
        return longest;
    }
}
