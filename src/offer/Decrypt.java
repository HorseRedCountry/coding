package offer;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Major Tom
 * @date 2020/9/13 19:42
 * @description 美团笔试题：解密
 */
public class Decrypt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int length=Integer.parseInt(sc.nextLine());
        String str=sc.nextLine();
        System.out.println(decrypt(str,length));
    }

    private static String decrypt(String str, int length) {
        Stack stack=new Stack();
        int tail=str.length()%length;
        char[] ch=str.toCharArray();
        String result="";
        int i=0,j=0;
        while (i<str.length()-tail){
            for (; j < length; j++) {
                stack.push(ch[i]);
                i++;
            }
            while (!stack.isEmpty()){
                result=result+stack.pop();
            }
            j=0;
        }
        while (i<str.length()){
            stack.push(ch[i]);
            i++;
        }
        while (!stack.isEmpty()){
            result=result+stack.pop();
        }
        return result;
    }
}
