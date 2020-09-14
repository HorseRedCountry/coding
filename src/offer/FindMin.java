package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/8/23 20:50
 * @description
 */
public class FindMin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //记录输入的字符串
        String str=sc.nextLine();
        int index=sc.nextInt();
        System.out.println(findMin(str,index));
    }
    public static String findMin(String str,int index){
        //存储排序后的所有子串
        ArrayList<String> result = new ArrayList<String>();
        //判断输入的字符串是否为空
        if (str==null||str.length()==0){
            return "";
        }
        //将待处理的字符串转为字符数组
        char[] chars=str.toCharArray();
        //遍历，求出所有可能额子串组合
        for (int i = 0; i < chars.length; i++) {
            //如果当前字符和前一个一样，直接跳过
            if(i!=0&&chars[i]==chars[i-1]){
                break;
            }
            String s= String.valueOf(chars[i]);
            result.add(s);
            int j=i+1;
            while (j<chars.length){
                s=s+chars[j];
                result.add(s);
                j++;
            }
        }
        //对所有的子串进行排序
        Collections.sort(result);
        //输出字典序第index小的子串
        return result.get(index-1);
    }
}
