package dailyex;

/**
 * @author Major Tom
 * @date 2020/11/11 19:43
 * @description 求最大公约数和最小公倍数
 */
public class Solution {
    public static void main(String[] args) {
        solution(8,45);
    }

    private static void solution(int m, int n) {
        //最大公约数
        int max=0;
        //最小公倍数
        int min=0;
        //m永远为最小值
        if(m>n){
            int temp=m;
            m=n;
            n=temp;
        }
        for (int i = 1; i < m; i++) {
            //求得最大公约数
            if (m%i==0&&n%i==0){
                max=i;
            }
        }
        //公式：两个数的乘积等于最大公约数乘以最小公倍数
        min=m*n/max;
        System.out.println("最大公约数为："+max);
        System.out.println("最小公倍数为："+min);
    }
}
