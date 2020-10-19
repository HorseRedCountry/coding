package leetcode;

/**
 * @author Major Tom
 * @date 2020/10/19 22:07
 * @description 0-n以内质数的和
 */
public class CountPrimeNumber {
    public static void main(String[] args) {
        System.out.println(count(9));
    }

    private static int count(int num) {
        /**从2开始*/
        int sum=2;
        //外层循环，从2一直轮询到m
        for (int i = 2; i <= num; i++) {
            for (int j = 2; j < i; j++) {
                if(i%j==0){
                    break;
                }
                if(j==(i-1)){
                    sum+=i;
                }
            }
        }
        return sum;
    }
}
