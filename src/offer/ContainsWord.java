package offer;

import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/9/13 10:06
 * @description 用递归
 */
public class ContainsWord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //矩阵有n行
        int n=sc.nextInt();
        //矩阵有m列
        int m=sc.nextInt();
        //存储矩阵
        int[][] matrix=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j]=sc.nextInt();
            }
        }
        int resultCol=findInitMatrix(matrix,n,m);
        System.out.println(resultCol);
        for (int i = 0; i < resultCol; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int findInitMatrix(int[][] matrix,int n,int m) {
        //若生成的矩阵行数为奇数，则说明没有经过翻转，直接返回即可
        if(n%2!=0){
            return n;
        }
        for (int i = 0; i < m; i++) {
            if(matrix[n/2-1][i]!=matrix[n/2][i]){
                return n;
            }
        }
        return findInitMatrix(matrix,n/2,m);
    }

}
