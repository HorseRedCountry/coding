package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Major Tom
 * @date 2020/11/16 13:19
 * @description 根据身高重建队列
 */
public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] queue=new int[][]{
                {1,0},
                {2,0},
                {3,0},
                {4,0},
                {5,0},
                {6,0}
        };
        int[][] result=reconstructQueue(queue);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排
     * 在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
     * @param queue 初始队列
     * @return
     */
    private static int[][] reconstructQueue(int[][] queue) {
        //队列长度
        int length=queue.length;
        //临时变量，用于换位置
        int temp;
        //先对队列按身高的升序进行冒泡排序冒泡排序
        for (int i = 1; i < length ;i++) {
            for (int j = 0; j < length-i; j++) {
                if (queue[j][0]<queue[j+1][0]){
                    temp=queue[j][0];
                    queue[j][0]=queue[j+1][0];
                    queue[j+1][0]=temp;
                    temp=queue[j][1];
                    queue[j][1]=queue[j+1][1];
                    queue[j+1][1]=temp;
                }
                if (queue[j][0]==queue[j+1][0]){
                    if (queue[j][1]>queue[j+1][1]){
                        temp=queue[j][0];
                        queue[j][0]=queue[j+1][0];
                        queue[j+1][0]=temp;
                        temp=queue[j][1];
                        queue[j][1]=queue[j+1][1];
                        queue[j+1][1]=temp;
                    }
                }
            }
        }
        LinkedList<int[]> list=new LinkedList<>();
        for (int[] arr : queue) {
            list.add(arr[1],arr);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
