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
    /**
     * 解法思路：用一个一位数组arr[8]来存储单次可行的摆法。其中arr[i]表示第i行上皇后应该摆放的位置
     */
    /**定义行数*/
    int max=8;
    /**记录解法总数*/
    static int count2=0;
    /**记录每次可行的摆法*/
    int[] arr=new int[max];

    public void layout(int n){
        //边界条件：即已经到达了最后一行
        if(n==max){
            System.out.println(Arrays.toString(arr));
            count2++;
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n]=i;
            //若当前行的摆法成立，则继续摆下一行
            if(judge(n)){
                //递归调用
                layout(n+1);
            }
        }
    }

    /**
     * 摆皇后的位置判断
     * @param n 摆放皇后的位置
     * @return
     */
    private boolean judge(int n) {
        //核心是判断部分
        for (int i = 0; i < n; i++) {
            //arr[i]==arr[n]：依次判断当前位置可有与之前已经摆好的皇后处于同一列
            //Math.abs()：取绝对值。第二个判断即判断之前已摆好的皇后是否有和当前将要摆放的皇后处于同一行的情形
            if(arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[i]-arr[n])){
                return false;
            }
        }
        return true;
    }
    /**
     * 输出：
     * [0, 4, 7, 5, 2, 6, 1, 3]
     * [0, 5, 7, 2, 6, 3, 1, 4]
     * [0, 6, 3, 5, 7, 1, 4, 2]
     * [0, 6, 4, 7, 1, 3, 5, 2]
     * [1, 3, 5, 7, 2, 0, 6, 4]
     * [1, 4, 6, 0, 2, 7, 5, 3]
     * ...............
     * [7, 2, 0, 5, 1, 4, 6, 3]
     * [7, 3, 0, 2, 5, 1, 6, 4]
     * 八皇后问题共有92解法
     */
}
