package leetcode;

/**
 * @author Major Tom
 * @date 2020/10/20 14:29
 * @description 将两个数子反转后相加，如123+456变为321+654
 */
public class ReverseAndCount {
    public static void main(String[] args) {
        System.out.println(reverseAndCount(100,400));
    }
    private static int reverseAndCount(int num1,int num2){
        //先将数字转化为字符串，然后直接reverse
        String str1=new StringBuilder(num1+"").reverse().toString();
        String str2=new StringBuilder(num2+"").reverse().toString();
        //转为int星直接相加
        return Integer.parseInt(str1)+Integer.parseInt(str2);
    }
}
