package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/10/28 11:48
 * @description 单词搜索
 *              给定一个二维网格和一个单词，找出该单词是否存在于网格中。单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 *              其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class SearchWords {
    public static void main(String[] args) {
        char[][] board=new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println(exist(board,"SEE"));
    }

    /**
     * 思路：深度优先搜索
     * @param board 目标数组
     * @param word 带搜索单词
     * @return 结果
     */
    private static boolean exist(char[][] board, String word) {
        /**记录数组行数*/
        int h=board.length;
        /**记录数组列数*/
        int w=board[0].length;
        /**记录当前元素是否已经被访过*/
        boolean[][] visited=new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag=check(board,visited,i,j,word,0);
                if (flag){
                    return true;
                }
            }

        }
        return false;
    }

    /**
     *
     * @param board 字符数组
     * @param visited 是否已访问
     * @param row 行
     * @param col 列
     * @param word 目标词
     * @param index 当前字符索引
     * @return 结果
     */
    private static boolean check(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
        //边界条件
        //字符不匹配
        if (board[row][col]!=word.charAt(index)){
            return false;
            //index=word.length()-1：说明所有字符已经遍历完毕
        }else if (index==word.length()-1){
            return true;
        }
        visited[row][col]=true;
        //即上下左右四个方向
        int[][] direction={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result=false;
        for (int[] dir : direction) {
            int newRow=row+dir[0];
            int newCol=col+dir[1];
            if (newRow>=0&&newRow<board.length&&newCol>=0&&newCol<board[0].length){
                if (!visited[newRow][newCol]){
                    boolean flag=check(board,visited,newRow,newCol,word,index+1);
                    if (flag){
                        result=true;
                        break;
                    }
                }
            }
        }
        //不符合上述判断，则状态恢复
        visited[row][col]=false;
        return result;
    }
}
