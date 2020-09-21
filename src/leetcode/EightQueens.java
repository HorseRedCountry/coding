package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/9/20 14:18
 * @description 八皇后问题
 */
public class EightQueens {
    public static void main(String[] args) {
        EightQueens eq=new EightQueens();
        //eq.eightQueens();
        //System.out.println(eq.eightBeautifulQueens());
        eq.layout(0);
        System.out.println("八皇后问题共有"+count2+"解法");
    }

    /**
     * 结果:o o o o o o o *
     *     o o o o o * o o
     *     o o o * o o o o
     *     o o o o o o * o
     *     o o * o o o o o
     *     * o o o o o o o
     *     o o o o * o o o
     *     o * o o o o o o
     */
    public void eightQueens() {
        //记录是否已被放置皇后
        boolean[][] flag=new boolean[10][10];
        //记录某一行是否已经放置了一个皇后
        boolean[] row=new boolean[10];
        //几楼某一列是否已经放置了一个皇后
        boolean[] col=new boolean[10];
        //存储最后皇后放置的位置
        char[][] result=new char[10][10];
        backTrack(flag,1,row,col,result);
        for (int i = 1; i < result.length-1; i++) {
            for (int j = 1; j < result[0].length-1; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void backTrack(boolean[][] flag, int index,boolean[] row,boolean[] col,char[][] result) {
        //单次搜寻终止条件，即已经扫描了八行
        if(index>=flag.length-1){
            for (int i = 1; i < result.length; i++) {
                for (int j = 1; j < result[0].length; j++) {
                    if(flag[i][j]){
                        result[i][j]='*';
                    }else{
                        result[i][j]='o';
                    }
                }
            }
            return;
        }
        //本质上是按行扫描，逐个填充。即一行为单位，每次从左往右逐格填充皇后，同时判断皇后的放置是否与之前冲突。若冲突，则回溯，反之继续
        for (int i = 1; i < flag[0].length-1; i++) {
            if(flag[index-1][i-1]||flag[index+1][index+1]||flag[index-1][i+1]||flag[index+1][i-1]||row[index]||col[i]){
                continue;
            }
            //标记已经放置皇后
            flag[index][i]=true;
            row[index]=true;
            col[i]=true;
            backTrack(flag,index+1,row,col,result);
            //状态恢复
            flag[index][i]=false;
            row[index]=false;
            col[i]=false;
        }
    }
    //记录解法的总数
    int count=0;
    public int eightBeautifulQueens(){

        //皇后的放置状态
        boolean flag[][]=new boolean[10][10];
        //行
        boolean row[]=new boolean[10];
        //列
        boolean col[]=new boolean[10];
        backTrackNew(flag,row,col,1);
        return count;
    }

    public void backTrackNew(boolean[][] flag, boolean[] row, boolean[] col, int index) {
        if(index>=row.length-1){
            System.out.println("_______________________");
            for (int i = 1; i < row.length-1; i++) {
                for (int j = 1; j < row.length-1; j++) {
                    if(flag[i][j]){
                        System.out.print("*"+"  ");
                    }else {
                        System.out.print("o"+"  ");
                    }
                }
                System.out.println();
            }
            count++;
            System.out.println("_______________________");
            return;
        }
        for (int i = 1; i < col.length - 1; i++) {
            if(flag[index-1][i-1]||flag[index+1][index+1]||flag[index-1][i+1]||flag[index+1][i-1]||row[index]||col[i]){
                continue;
            }
            //标记已经放置皇后
            flag[index][i]=true;
            row[index]=true;
            col[i]=true;
            backTrackNew(flag,row,col,index+1);
            //状态恢复
            flag[index][i]=false;
            row[index]=false;
            col[i]=false;
        }
    }

    int max=8;
    static int count2=0;
    int[] arr=new int[max];

    public void layout(int n){
        if(n==max){
            System.out.println(Arrays.toString(arr));
            count2++;
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n]=i;
            if(judge(n)){
                layout(n+1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if(arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[i]-arr[n])){
                return false;
            }
        }
        return true;
    }
}
