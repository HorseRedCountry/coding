package offer;

import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/9/13 11:01
 * @description 感觉像是字符串匹配算法
 */
public class BuyGift {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int[] beautifulVal=new int[n];
        for (int i = 0; i < n; i++) {
            beautifulVal[i]=sc.nextInt();
        }
        System.out.println(buyGift(beautifulVal,m,k));
    }

    private static int buyGift(int[] beautifulVal, int m, int k) {
        int count=0;
        String str=k+"";
        for (int i = 0; i <m; i++) {
            str=str+k;
        }
        String intString="";
        for (int j = 0; j < beautifulVal.length; j++) {
            intString=intString+beautifulVal[j];
        }
        while (intString.contains(str)){
            int index=intString.indexOf(str);
            intString=intString.substring(index);
            count++;
        }
        return count;
    }
}
