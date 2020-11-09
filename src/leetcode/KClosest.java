package leetcode;

import java.util.Arrays;

/**
 * @author Major Tom
 * @date 2020/11/9 14:29
 * @description 最接近原点的K个点
 */
public class KClosest {
    public static void main(String[] args) {
        int[][] result=kClosest(new int[][]{{6,10},{-3,-3},{-2,5},{0,2}},3);
        for (int[] ints : result) {
            System.out.print(Arrays.toString(ints));
        }
    }

    /**
     * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点
     * @param points 点集
     * @param k 距离原点最近的点的个数
     * @return 距离原点最近的点的集合
     */
    private static int[][] kClosest(int[][] points, int k) {
        int length=points.length;
        //记录结果
        int[][] result=new int[k][2];
        //记录对应点距离原点的欧氏距离
        double[][] distance=new double[points.length][2];
        //双层循环，遍历并求出当前点距离原点的欧氏距离
        for (int i = 0; i < length; i++) {
            distance[i][0]=i;
            distance[i][1]=Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1]);
        }
        //临时变量，用于换行列值
        double col=0;
        double row=0;
        //对distance数组进行冒泡排序，根据欧式距离
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                //换位置
                if (distance[i][1]>distance[j][1]){
                    //换列值
                    row=distance[i][1];
                    distance[i][1]=distance[j][1];
                    distance[j][1]=row;
                    //换行值
                    col=distance[i][0];
                    distance[i][0]=distance[j][0];
                    distance[j][0]=col;
                }
            }
        }
        int temp=0;
        for (int i = 0; i < k; i++) {
            temp= (int) distance[i][0];
            result[i][0]=points[temp][0];
            result[i][1]=points[temp][1];
        }
        return result;
    }

}
