package offer;
/*
    题目描述：输入一个整数，输出其二进制中1的个数
       思路：Step1,将此数转化为二进制数
            Step2,再讲转化后的二进制数转换成一个字符数组
            Step3，遍历此数组，匹配到1时将标识字段+1
            Step4，输出标识字段
 */
public class BinaryFindOne {
    public int numberOf1(int n){
        int count=0;
        char[] ch=Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                count++;
            }
        }

        return count;
    }
}
