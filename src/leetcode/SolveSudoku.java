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
     *          假设数字为[1,2,3]，我们相求出它的全排列，求解过程大致可以用下图来表述
     *                   1              2               3
     *              2         3    1          3     1       2
     *          3               2 3              1 2          1
     *
     *          以上求解过程本质上就是构造了一棵求解树，然后通过BST算法遍历树的每一条路径
     *
     */
    /**存放最终求解的结果*/
    List<List<Integer>> res=new LinkedList<>();
    /**每次遍历出的树的路径*/
    LinkedList<Integer> track=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums){
        backTrack(nums);
        return res;
    }

    /**
     * 求解的核心算法：回溯法
     * @param nums
     */
    public void backTrack(int[] nums) {
        //跳出条件
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
            //这是回溯的关键步骤：状态恢复,即恢复到上一步的状态  
            track.removeLast();
            System.out.println(track.toString());
        }
    }
}
