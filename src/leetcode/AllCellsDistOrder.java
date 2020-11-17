package leetcode;

import java.util.*;
import java.util.List;

/**
 * @author Major Tom
 * @date 2020/11/17 14:47
 * @description 距离顺序排列矩阵单元格
 */
public class AllCellsDistOrder {
    public static void main(String[] args) {
        int[][] result=allCellsDistOrder(2,3,1,2);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
     * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
     * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1)
     * 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。
     * @param R 矩阵行数
     * @param C 矩阵列数
     * @param r0 单元格横坐标
     * @param c0 单元格纵坐标
     * @return 矩阵中所有的单元格坐标（按曼哈顿距离从大到小排序）
     */
    private static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        /*//记录坐标顺序
        List<int[]> list=new LinkedList<>();
        //判断当前单元格是否已被访问
        //boolean[][] matrix=new boolean[R][C];
        //matrix[r0][c0]=true;
        //借助一个辅助队列
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{r0,c0});
        int i=1;
        while (!queue.isEmpty()){
            //判断四周相邻的单元格
            if (r0-i>=0){
                queue.offer(new int[]{r0-i,c0});
                //matrix[r0-i][c0]=true;
            }
            if (c0+i<C){
                queue.offer(new int[]{r0,c0+i});
                //matrix[r0][c0+i]=true;
            }
            if (r0+i<R){
                queue.offer(new int[]{r0+i,c0});
                //matrix[r0+i][c0]=true;
            }
            if (c0-i>=0){
                queue.offer(new int[]{r0,c0-i});
                //matrix[r0][c0-i]=true;
            }

            if (r0-i>=0&&c0-i>=0){
                queue.offer(new int[]{r0-i,c0-1});
                //matrix[r0-i][c0]=true;
            }
            if (r0-i>=0&&c0+i<C){
                queue.offer(new int[]{r0-i,c0+i});
                //matrix[r0][c0+i]=true;
            }
            if (r0+i<R&&c0-i>=0){
                queue.offer(new int[]{r0+i,c0-i});
                //matrix[r0+i][c0]=true;
            }
            if (r0+i<C&&c0+i<C){
                queue.offer(new int[]{r0+i,c0+i});
                //matrix[r0][c0-i]=true;
            }
            int[] point=queue.poll();
            list.add(point);
            i++;
        }
        return list.toArray(new int[list.size()][2]);*/
        int[][] re = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int t = i*C+j;
                re[t][0] = i;
                re[t][1] = j;
            }
        }
        Arrays.sort(re, (arr1, arr2) -> {
            int d1 = dist(arr1[0], arr1[1], r0, c0);
            int d2 = dist(arr2[0], arr2[1], r0, c0);
            return Integer.compare(d1, d2);
        });

        return re;
    }
    private static int dist(int r1,int c1,int r2,int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
