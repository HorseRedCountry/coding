package offer;

import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/9/8 18:19
 * @description 思路：可以用ASCII码值的大小来判断
 *              PS：ASCII码表我一时记不起来了，就百度了一下
 */
public class SafeCode {
    public static void main(String[] args) {
        System.out.println("请输入需要验证的密码，多个密码以空格符间隔：");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        //切割为字符串数组
        String[] strArr=str.split(" ");
        //遍历数组，处理并输出
        for (String s : strArr) {
            showCharCount(s);
        }
    }

    private static void showCharCount(String str) {
        //将字符串转化为字符数组
        char[] chars=str.toCharArray();
        //判断长度是否符合要求
        if(chars.length<8||chars.length>120){
            System.out.println(1);
            return;
        }
        //记录字符值
        int[] intArr=new int[4];
        //判断类型
        for (int i = 0; i < chars.length; i++) {
            if(((int)chars[i]>=33&&(int)chars[i]<=47)||((int)chars[i]>=58&&(int)chars[i]<=64)||((int)chars[i]>=91&&(int)chars[i]<=96)||((int)chars[i]>=123&&(int)chars[i]<=126)){
                intArr[0]=1;
            }else if((int)chars[i]>=48&&(int)chars[i]<=57){
                intArr[1]=1;
            }else if((int)chars[i]>=65&&(int)chars[i]<=90){
                intArr[2]=1;
            }else if((int)chars[i]>=97&&(int)chars[i]<=122){
                intArr[3]=1;
            }
        }
        int count=intArr[0]+intArr[1]+intArr[2]+intArr[3];
        if (count==4){
            System.out.println(0);
            return;
        }
        System.out.println(2);
        return;
    }
}
