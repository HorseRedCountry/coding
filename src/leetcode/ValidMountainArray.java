package leetcode;

/**
 * @author Major Tom
 * @date 2020/11/3 19:54
 * @description 有效的山脉数组
 */
public class ValidMountainArray {
    public static void main(String[] args) {
        int[] arr1=new int[]{3,5,5};
        int[] arr2=new int[]{1,2,3,2,1};
        System.out.println(validMountainArray(arr1));
        System.out.println(validMountainArray(arr2));
    }

    private static boolean validMountainArray(int[] arr) {
        //数组长度小于3，则不可能是山脉数组
        if (arr.length<3){
            return false;
        }
        //开始时就递减，则不会为山脉数组
        if (arr[1]<=arr[0]){
            return false;
        }
        //记录
        int flag=0;
        //遍历数组
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]>arr[i+1]){
                flag=i;
                break;
            }
        }
        for (int i = flag+1; i < arr.length-1; i++) {
            if (arr[i]<=arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
