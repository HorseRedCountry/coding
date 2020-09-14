package offer;

import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/9/13 11:25
 * @description
 */
public class FindLineNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j]= sc.nextInt();
            }
            //记录事情编号
            matrix[i][2]=i+1;
        }
        matrix=findBest(matrix,n);
        for (int j=0;j<n;j++){
            System.out.print(matrix[j][2]+" ");
        }
    }

    private static int[][] findBest(int[][] matrix,int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (matrix[i][0]<matrix[j][0]) {
                    swap(matrix,i,j);
                }else if(matrix[i][0]==matrix[j][0]){
                    if(matrix[i][1]<matrix[j][1]){
                        swap(matrix,i,j);
                    }
                }
            }
        }
        return matrix;
    }

    private static void swap(int[][] matrix, int i, int j) {
        int temp=matrix[i][2];
        matrix[i][2]=matrix[j][2];
        matrix[j][2]=temp;
    }
}
