package offer;

import java.util.ArrayList;

/**题目描述：输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数
 *         的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *    思路：这个问题的核心点在于对树的遍历，可以采取递归的做法
 * @author Major Tom
 * @date 2020/7/14 9:53
 */
public class FindPath {
    //记录所有路径
    private ArrayList<ArrayList<Integer>> allPath=new ArrayList<ArrayList<Integer>>();
    //记录一条合法路径
    private ArrayList<Integer> path=new ArrayList<Integer>();
    //递归体
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target){
        //单次递归终止条件
        if (target==0)
            return allPath;
        path.add(root.val);
        target=target-root.val;
        if (target==0&&root.LChild==null&&root.RChild==null)
            //此处是new一个和原序列相同的的list
            allPath.add(new ArrayList<Integer>(path));
        findPath(root.LChild, target);
        findPath(root.RChild, target);
        path.remove(path.size()-1);
        return allPath;
    }
    /**
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     */
}
