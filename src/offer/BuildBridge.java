package offer;

import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/9/13 20:16
 * @description
 */
public class BuildBridge {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
            int[][] matrix=new int[m][3];
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < 3; l++) {
                    matrix[j][l]=sc.nextInt();
                }
            }
            System.out.println(buildBridge(matrix,n,m,k));
        }
    }

    private static String buildBridge(int[][] matrix, int n, int m, int k) {
        String str="";
        if(n-m>1){
            str="No";
            return str;
        }
        str="Yes";
        return str;
    }
}
