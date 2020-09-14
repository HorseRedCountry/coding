package offer;

/**
 * @author Major Tom
 * @date 2020/8/17 12:39
 * @description 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的
 *              字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 *              是不是很简单？OK，搞定它！
 *              思路：可以先把字符串前k位给切割，然后拼接到剩下部分的尾部
 */
public class LeftRotateString {
    public static String leftRotateString(String str,int n){
        if(n>=str.length()||str==null)
            return str;
        return str.substring(n)+str.substring(0,n);
    }

    public static void main(String[] args) {
        System.out.println(leftRotateString("abcXYZdef",3));//XYZdefabc
    }
}
