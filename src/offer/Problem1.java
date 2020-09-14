package offer;

import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/7/17 19:04
 */
public class Problem1 {
    public static void main(String[] args) {
        //读取用户输入
        Scanner in=new Scanner(System.in);
        //共有t行
        int t=in.nextInt();
        int x;
        for (int i = 0; i < t; i++) {
            //每行的整数
            x=in.nextInt();
            //处理完毕
            System.out.println(solution(x));
        }
    }

    /**
     *思路：x^a^b要想取得最大值，那么x^(a^b)=11111111,这就要求a^b的值为x的二进制值的按位取反
     *     Step1 以其能取得的最大值^x,int最大值为255，则用255^x,求得a^b的值
     *     Step2 |a-b|最小，理想情况下a=b,但是a=b时,a^b=0,不可取
     *     a,b之间的
     * @param x 待处理的数据
     * @return
     */
    private static int solution(int x) {

        //num为a^b的值
        int num=255^x;
        //count为个数
        int count=0;



        return count;
    }
}
