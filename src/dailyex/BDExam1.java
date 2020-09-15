package dailyex;

import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/9/14 19:45
 * @description
 */
public class BDExam1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //测试数据组数
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            //小伙伴数量
            int n=sc.nextInt();
            //剧中角色数量
            int m=sc.nextInt();
            int[] nNums=new int[n];
            for (int j = 0; j < n; j++) {
                nNums[j]=sc.nextInt();
            }
            int[] mNums=new int[m];
            for (int k = 0; k < m; k++) {
                mNums[k]=sc.nextInt();
            }
            int[] result=find(n,m,nNums,mNums);
            for (int y = 0; y < result.length; y++) {
                System.out.print(result[y]+" ");
            }
        }

    }

    private static int[] find(int n, int m, int[] nNums, int[] mNums) {
        int[] result=new int[n];
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(nNums[i]<=mNums[j]){
                    count++;
                }
            }
            result[i]=count;
            count=0;
        }
        return result;
    }
}
