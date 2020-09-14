package offer;
/*
    题目描述：给定一个double类型的浮点数base和int类型的整数exponet，求base的exponet次方
    思路：此题分三种情况，exponet>0,exponet=0和exponet<0。
            同时，还需要考虑一种异常情况：base为0且exponet为负值。此时无意义
 */
public class ProwerProblem {
    public static double power(double base,int exponet){
        //首先，判断异常情况
        if(base==0&&exponet<0)
            throw new RuntimeException("运算无意义！");
        //判断exponet为0的情形
        if(exponet==0)
            return 1;
        double result=1;
        for (int i = 1; i <=Math.abs(exponet); i++) {
            result =result*base;
        }
        //判断exponet>0的情形
        if (exponet>0)
            return result;
        //exponet<0
        else
            return 1/result;
    }

    public static void main(String[] args) {
        System.out.println(ProwerProblem.power(1.3,-2));
    }

}
