package dailyex;

public class FibDPDemo {
    //用普通递归的方式求斐波那契数列
    //缺点：时间复杂度过高，成指数级增长。以f(5)为例，计算它时要计算f(3)和f(4),计算f(4)时又需要计算
    //     f(3)和f(2),这样就导致了f(3)的重复计算，因此时间复杂度过高。
    public static int fib(int n){
        if (n<2) {
            return n;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }
    //用DP解，以空间换时间
    public static int fibUseDP(int n){
        if (n<1) {
            return n;
        }
        //f(n-1)的值
        int last=1;
        //f(n-2)的值
        int second=1;
        //f(n)的值
        int answer=1;
        for (int i = 3; i <= n; i++) {
            //f(n)=f(n-1)+f(n-2)
            answer=last+second;
            //f(n-1)和f(n-2)依次往后移一位
            second=last;
            last=answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));//5
        System.out.println(fibUseDP(5));//5
    }
}
