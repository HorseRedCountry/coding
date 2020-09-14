package offer;

/**
 * @Author Major Tom
 * @Date 2020-08-06 11:51
 * @Description 统计一个数字在排序数组中出现的次数。
 *          思路：定义统计次数的变量count，遍历排序数组，若遍历到的元素大于k，跳出循环；
 *               当遍历到与k相等的元素后，count++。循环结束，返回count
 */
public class GetNumberOfK {
    public static int getNumberOfK(int[] arr,int k){
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            //减小时间复杂度
            if(arr[i]>k)
                break;
            if(arr[i]==k){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfK(new int[]{1,2,3,3,3,4},3));
    }
    /*
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    * 凑字数哇凑字数，凑字数哇凑字数。
    *
    * */
}
