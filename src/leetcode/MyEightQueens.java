package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/9/22 19:05
 * @description n皇后问题
 */
public class MyEightQueens {
    /**定义皇后的个数*/
    private int queens;
    /**定义棋盘*/
    private int[] arr;
    /**记录解法总数*/
    static int count=0;

    public MyEightQueens(int queens) {
        this.queens = queens;
        this.arr = new int[queens];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入皇后个数：");
        //读取皇后的个数
        int n=sc.nextInt();
        MyEightQueens meq=new MyEightQueens(n);
        meq.nQueensProblem(0);
        System.out.println(n+"个皇后共有"+count+"种摆法");
    }

    private void nQueensProblem(int index) {
        if (index==queens){
            System.out.println(Arrays.toString(arr));
            count++;
            return;
        }
        for (int i = 0; i < queens; i++) {
            arr[index]=i;
            if(judge(index)){
                nQueensProblem(index+1);
            }
        }
    }

    /**
     * 判断当前位置是否可以摆放皇后
     * @return
     */
    private boolean judge(int index) {
        for (int i = 0; i < index; i++) {
            if (arr[index]==arr[i]||Math.abs(index-i)==Math.abs(arr[index]-arr[i])){
                return false;
            }
        }
        return true;
    }
}
