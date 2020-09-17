package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Major Tom
 * @date 2020/9/15 14:08
 * @description 解数独问题
 */
public class SolveSudoku {

    public static void main(String[] args) {
        /*char[][] chars=null;
        solveSudoku(chars);*/
        SolveSudoku ss=new SolveSudoku();
        System.out.println(ss.permute(new int[]{1,2,3}).toString());
    }

    /**
     * 解数独
     * @param chars
     */
    public void solveSudoku(char[][] chars) {

    }

    /**
     * 全排列问题：给出一串不重复的数字，求出此串数字的所有全排列组合
     * @param nums 给定的数字
     * @return 所有可能的全排列组合
     */
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> track=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums){
        backTrack(nums);
        return res;
    }

    public void backTrack(int[] nums) {
        if(track.size()== nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums);
            System.out.println(track.toString());
            track.removeLast();
            System.out.println(track.toString());
        }
    }
}
