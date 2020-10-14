package leetcode;

/**
 * @author Major Tom
 * @date 2020/9/22 19:05
 * @description 八皇后问题
 */
public class MyEightQueens {
    /**定义皇后的个数*/
    int max=8;
    /**定义棋盘*/
    boolean[][] flag=new boolean[max][max];
    /**标识行*/
    boolean[] row=new boolean[max];
    /**标识列*/
    boolean[] col=new boolean[max];
    /**解法总数*/
    static int count=0;

    public static void main(String[] args) {
        MyEightQueens meq=new MyEightQueens();
        meq.eightQueensProblem(0);
    }

    private void eightQueensProblem(int index) {
        if(index>=max){
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            if(judge()){
                eightQueensProblem(index+1);
            }
        }
    }

    /**
     * 判断当前位置是否可以摆放皇后
     * @return
     */
    private boolean judge() {

        return true;
    }
}
