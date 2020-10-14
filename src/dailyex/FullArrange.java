package dailyex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Major Tom
 * @date 2020/10/14 13:24
 * @description 输入指定数组，输出该数组内所有数字的全排列
 */
public class FullArrange {
    LinkedList<Integer> list=new LinkedList<>();
    List<List<Integer>> result=new LinkedList<>();
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3};
        FullArrange fa=new FullArrange();
        fa.fullArrange(arr);
        System.out.println(fa.result.toString());
    }

    private void fullArrange(int[] arr) {
        backTrack(arr,0);
    }

    private void backTrack(int[] arr, int index) {
        if(index>=arr.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])){
                continue;
            }
            list.add(arr[i]);
            backTrack(arr,index+1);
            list.removeLast();
        }
    }
}
