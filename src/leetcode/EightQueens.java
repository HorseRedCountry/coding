package leetcode;

/**
 * @author Major Tom
 * @date 2020/9/20 14:18
 * @description 八皇后问题
 */
public class EightQueens {
    public static void main(String[] args) {
        EightQueens eq=new EightQueens();
        eq.eightQueens();
    }

    public void eightQueens() {
        boolean[][] flag=new boolean[9][9];
        boolean[] row=new boolean[9];
        boolean[] col=new boolean[9];
        int index=1;
        backTrack(flag,index,row,col);
        for (int i = 1; i < flag.length; i++) {
            for (int j = 1; j < flag[0].length; j++) {
                System.out.print(flag[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void backTrack(boolean[][] flag, int index,boolean[] row,boolean[] col) {
        if(index>=flag.length){
            return;
        }
        for (int i = 1; i < flag[0].length; i++) {
            if(flag[index-1][i-1]||row[i]||col[index]){
                continue;
            }
            flag[index][i]=true;
            row[i]=true;
            col[index]=true;
            backTrack(flag,index+1,row,col);
            flag[index][i]=false;
            row[i]=false;
            col[index]=false;
        }
    }
}
