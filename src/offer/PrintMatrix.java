package offer;

import java.util.ArrayList;

/**题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *         例如，如果输入如下4 X 4矩阵：1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *         则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *    思路：这道题的核心，我觉得在于边界问题，即顺时针将数组读入链表时，每一圈都是由两横列
 *         和两竖列组成，关键就在于最后一圈该如何判定，也就是要循环几圈
 *         Step1 计算圈数。通过对矩阵的比较我们可以发现，顺时针打印时运算的圈数取决于矩阵
 *               行数和列数较小的那个。如三行两列矩阵循环的圈数为1，四行三列矩阵循环的圈数为2...
 *               当然，也可以采取当链表长度和数组元素的个数相等时，结束循环
 *         Step2 循环，一依次将元素添加入链表中,中间要注意诸多跳出条件
 *    结果：输入 {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}
 *         输出 1  2  3  4  8  12  16  15  14  13  9  5  6  7  11  10  16
 *         输入 {{1},{2},{3},{4},{5}}
 *         输出 1  2  3  4  5
 *         输入 {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}}
 *         输出 1  2  3  4  5  10  15  14  13  12  11  6  7  8  9
 * @author Major Tom
 * @date 2020/7/7 9:54
 */
public class PrintMatrix {
    public static ArrayList<Integer> print(int[][] matrix){
        //返回的数组
        ArrayList<Integer> matrixList=new ArrayList<Integer>(0);
        //定义行列
        int row=matrix.length;
        int col=matrix[0].length;
        //j,j为行列下标，m为下次循环时的起始坐标
        int i=0,j=0,m=0;
        //(row*col)!=getLength(matrixList)为跳出点
        //当数组的元素个数等于矩阵元素总个数时，跳出
        while ((row*col)!=getLength(matrixList)){
            //遍历添加按照顺时针，即上-->右-->下-->左的顺序
            //最上面的一行
            for (; j < col-m; j++) {
                matrixList.add(matrix[i][j]);
            }
            //这个是为了判断矩阵是否只有一行，只有一行的话下面就不用了
            if(row<=1){
                break;
            }
            //i++是为了下标移位，否则会重复填入元素
            //j--是为了将列下标归位只正常范围，因为for循环跳出时j多加了一次
            j--;
            i++;
            //最右边的一列
            for (; i < row-m; i++) {
                matrixList.add(matrix[i][j]);
            }
            //作用同上面
            i--;
            j--;
            //判断是否已经满足条件，因为奇数行列矩阵会遇到单列读取过多的问题
            if((row*col)==getLength(matrixList)){
                break;
            }
            //判断矩阵是否只有一列
            if (col <= 1) {
                break;
            }
            //最下面的一行填入数组
            for (;j>m;j--){
                matrixList.add(matrix[i][j]);
            }
            //左边一行填入数组
            for (;i>m;i--){
                matrixList.add(matrix[i][j]);
            }
            //确定下次循环的起始坐标
            i++;
            j++;
            m++;
        }
        return matrixList;
    }
    //计算数组长度
    public static int getLength(ArrayList<Integer> list){
        int length=0;
        for (int i:list) {
            length++;
        }
        return length;
    }
    public static void main(String[] args) {
        //int[][] matrix=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //int[][] matrix=new int[][]{{1},{2},{3},{4},{5}};
        int[][] matrix=new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        ArrayList<Integer> matrixList=PrintMatrix.print(matrix);
        for (int i:matrixList) {
            System.out.print(i+"  ");
        }
    }
}
