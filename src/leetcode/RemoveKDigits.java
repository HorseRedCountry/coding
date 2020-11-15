package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Major Tom
 * @date 2020/11/15 13:39
 * @description 移掉K位数字
 */
public class RemoveKDigits {
   public static void main(String[] args) {
        System.out.println(removeKDigits("10200",1));
        System.out.println(removeKDigits("1432219",3));
       System.out.println(removeKDigits("10",1));
    }

    /**
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小
     * @param nums 以字符串表示的数字
     * @param k 移除的位数
     * @return 最小的数字
     */
    private static String removeKDigits(String nums, int k) {
        //若要移除的位数大于数字的长度，直接返回
        if (nums.length()<=k){
            return 0+"";
        }
        char[] chars=nums.toCharArray();
        //用栈辅助计算
        Deque<Character> stack=new ArrayDeque<>(nums.length());
        for (char c : chars) {
            while (k>0&&!stack.isEmpty()&&c<stack.peek()){
                stack.pop();
                k--;
            }
            if (c!='0'||stack.isEmpty()){
                stack.push(c);
            }
            if (c=='0'&&!stack.isEmpty()){
                stack.push(c);
            }
        }
        while (k>0&&!stack.isEmpty()){
            stack.pop();
            k--;
        }
        StringBuilder builder=new StringBuilder();
        while (stack.peekLast()=='0'&&stack.size()>1){
            stack.pollLast();
        }
        while (!stack.isEmpty()){
            builder.append(stack.pollLast());
        }
        return builder.length()==0?"0":builder.toString();
    }
}
