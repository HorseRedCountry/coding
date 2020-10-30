package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/10/30 9:58
 * @description 岛屿的周长
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid=new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(islandPerimeter(grid));
        System.out.println(isLandPerimeterDfs(grid));
    }

    /**
     * 遍历整个数组，当遇到小岛时判断岛屿的边是否为边界或者水域，若是，则边长加一，反之则不变。
     * @param grid 数组
     * @return 边长总和
     */
    private static int islandPerimeter(int[][] grid) {
        //边长总和
        int count=0;
        //行数
        int row= grid.length-1;
        //列数
        int col=grid[0].length-1;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                //判断是否为小岛
                if (grid[i][j]==1){
                    //分别判断四条边是否为水域
                    //上边
                    if (i==0||grid[i-1][j]==0){
                        count++;
                    }
                    //右边
                    if (j == col||grid[i][j+1]==0){
                        count++;
                    }
                    //下边
                    if (i ==row||grid[i+1][j]==0){
                        count++;
                    }
                    //左边
                    if (j==0||grid[i][j-1]==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static int isLandPerimeterDfs(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    return dfs(grid,i,j);
                }
            }
        }
        return 0;
    }


    /**
     * dfs求解
     * @param grid 目标网格
     * @param dx 横坐标
     * @param dy 纵坐标
     * @return 边长总和
     */
    private static int dfs(int[][] grid,int dx,int dy){
        //边界判断。即满足判断这说明格子是边界上的
        if (!(0<=dx&&dx<grid.length&&0<=dy&&dy<=grid[0].length)){
            return 1;
        }
        //判断四周是否为水
        if (grid[dx][dy]==0){
            return 1;
        }
        //防止死循环
        if (grid[dx][dy]!=1){
            return 0;
        }
        //标记已访问过的格子
        grid[dx][dy]=2;
                //上边
        return  dfs(grid,dx-1,dy)
                //右边
                +dfs(grid,dx,dy+1)
                //下边
                +dfs(grid,dx+1,dy)
                //左边
                +dfs(grid,dx,dy-1);
    }
}
