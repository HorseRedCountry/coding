package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Major Tom
 * @date 2020/9/18 13:10
 * @description 全排列 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class PermuteUnique {
    LinkedList<Integer> track=new LinkedList<>();
    List<List<Integer>> result=new LinkedList<>();
    /**借助一个数组，来确定当前元素是否已被访问过*/
    boolean[] flag=new boolean[4];
    public static void main(String[] args) {
        PermuteUnique pu=new PermuteUnique();
        //pu.permute(new int[]{1,1,2},0);
        int[] nums=new int[]{3,3,0,3};
        //需要先对数组进行一次排序
        Arrays.sort(nums);
        pu.trackBack(nums,0);
        System.out.println(pu.result.toString());
    }
    public void trackBack(int[] nums,int index){
        if(index>=nums.length){
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //在遍历时就确定是否重复
            if(flag[i]||(i>0&&nums[i]==nums[i-1]&&!flag[i-1])){
                continue;
            }
            flag[i]=true;
            track.add(nums[i]);
            System.out.println(track.toString());
            trackBack(nums, index+1);
            flag[i]=false;
            track.remove(index);
            System.out.println(track.toString());
        }
    }

    /**方法一：使用 contains导致时间复杂度过高*/
    public void permute(int[] nums,int index) {
        if (index>=nums.length){
            //判断结果中是否已经包含已生成的序列
            if(!result.contains(track)){
                result.add(new LinkedList<>(track));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(flag[i]){
                continue;
            }
            flag[i]=true;
            track.add(nums[i]);
            permute(nums,index+1);
            flag[i]=false;
            track.remove(index);
        }
    }
}
