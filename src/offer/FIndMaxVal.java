package offer;

import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/8/23 21:29
 * @description
 */
public class FIndMaxVal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //总共的组数
        int rows=sc.nextInt();
        for (int i = 0; i < rows; i++) {
            System.out.println(findMaxVal(sc.nextInt()));
        }
    }
    /**
     * 价值最大，则拆分后的两个数应分布在平均值附近
     */
    public static int findMaxVal(int num){
        int right=num/2-1;
        int left=num-right;
        //记录价值
        int val=0;
        String rightStr= String.valueOf(right);
        char[] rightChar=rightStr.toCharArray();
        for (int i = 0; i < rightStr.length(); i++) {
            String s=rightChar[i]+"";
            val=val+Integer.valueOf(s);
        }
        String leftStr=String.valueOf(left);
        char[] leftChar=leftStr.toCharArray();
        for (int j = 0; j < leftChar.length; j++) {
            String s=leftChar[j]+"";
            val=val+Integer.valueOf(s);
        }
        return val;
    }
}
