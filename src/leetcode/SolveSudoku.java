package leetcode;


/**
 * @author Major Tom
 * @date 2020/9/15 14:08
 * @description 解数独问题
 */
public class SolveSudoku {

    /**
     * 解数独
     * @param board
     */
    public void solveSudoku(char[][] board) {
        /**判断某行里面某位数字是否已被摆放,是用格子的下标直接代表当前数字*/
        boolean[][] rows=new boolean[9][9];
        /**判断某列里面某位数字是否已被摆放*/
        boolean[][] cols=new boolean[9][9];
        /**判断某个3x3小块里面某数字是否已被摆放*/
        boolean[][] blocks=new boolean[9][9];
        //对字符出租进行初步处理
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.'){
                    //对所有已经有数字的格子进行标识，即把格子内的数字对应位置标为true
                    //比如此刻i=3,j=2,board[3][2]='4',则num=board[3][2]-‘1’=3
                    int num=board[i][j]-'1';
                    //表示第i+1列数字num-1已存在（由于数组是从0开始的，所以本质上其实是计算的0-8）
                    rows[i][num]=true;
                    cols[i][num]=true;
                    //取整（5/3 * 3 + 5/3=5）。9x9的数独，3x3的block一共有9个，所以这样做其实是一个切分
                    blocks[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board,rows,cols,blocks,0,0);
    }

    private boolean dfs(char[][] board,boolean[][] rows,boolean[][] cols,boolean[][] blocks,int row, int col) {
        //寻找每一个未被填上数字的空位置
        while (board[row][col]!='.'){
            //row和col的最大值均为8,这里是先行后列的扫描法
            if (++col>=9){
                row++;
                col=0;
            }
            //满足此条件，说明已全部扫描完毕
            if (row>=9){
                return true;
            }
        }
        for (int i = 0; i < 9; i++) {
            //定位到分割为3x3的小块后的第几个块
            int blockIndex=row/3*3+col/3;
            //判断，即同一行&同一列&同一小块内都不能出现相同数字
            //把0-8依次往格子里丢，看究竟哪个满足条件
            if (!rows[row][i]&&!cols[col][i]&&!blocks[blockIndex][i]){
                //+1是因为数组下标是从0开始的
                board[row][col]=(char)('1'+i);
                //行、列、块依次标记
                rows[row][i]=true;
                cols[col][i]=true;
                blocks[blockIndex][i]=true;
                //递归
                if (dfs(board,rows,cols,blocks,row,col)){
                    return true;
                }else {
                    //不满足条件，回溯
                    rows[row][i]=false;
                    cols[col][i]=false;
                    blocks[blockIndex][i]=false;
                    board[row][col]='.';
                }
            }
        }
        return false;
    }

    private void printSudoku(char[][] chars){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(chars[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        SolveSudoku sudoku=new SolveSudoku( );
        System.out.println(board);
        sudoku.solveSudoku(board);
        sudoku.printSudoku(board);
    }
    /**
     * 输出：
     * 5 3 . . 7 . . . .
     * 6 . . 1 9 5 . . .
     * . 9 8 . . . . 6 .
     * 8 . . . 6 . . . 3
     * 4 . . 8 . 3 . . 1
     * 7 . . . 2 . . . 6
     * . 6 . . . . 2 8 .
     * . . . 4 1 9 . . 5
     * . . . . 8 . . 7 9
     * 5 3 4 6 7 8 9 1 2
     * 6 7 2 1 9 5 3 4 8
     * 1 9 8 3 4 2 5 6 7
     * 8 5 9 7 6 1 4 2 3
     * 4 2 6 8 5 3 7 9 1
     * 7 1 3 9 2 4 8 5 6
     * 9 6 1 5 3 7 2 8 4
     * 2 8 7 4 1 9 6 3 5
     * 3 4 5 2 8 6 1 7 9
     */
}
