package leetcode;

/**
 * @author Major Tom
 * @date 2020/9/17 11:20
 * @description 优美的排列
 * 可以采取暴力算法：求出全排列，逐个判断
 */
public class CountArrangement {
    public int count=0;

    public static void main(String[] args){
        CountArrangement ca=new CountArrangement();
        System.out.println(ca.countArrangement(2));
    }

    private int countArrangement(int N) {
        //构造供全排列的数组
        permute(N,new boolean[N+1],1);
        return count;
    }
    /**回溯法求出数组的全排列，逐个判断*/
    private void permute(int N, boolean[] access, int index) {
            if(index>N){
                count++;
            }
        for (int i = 1; i <= N; i++) {
            if(access[i]||(i%index!=0&&index%i!=0)){
                continue;
            }
            access[i]=true;
            permute(N,access,index+1);
            access[i]=false;
        }
    }
}
