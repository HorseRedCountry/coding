package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Major Tom
 * @date 2020/9/14 17:23
 * @description 二叉树的中序遍历（递归版）
 */
public class InorderTraversal {
    public static void main(String[] args) {

    }

    private static List<Integer> inorderTraversal(TreeNode tree) {
        List<Integer> nodeList=new ArrayList<>();
        return inOrder(tree,nodeList);
    }
    /**
     * 中序遍历：左根右
     */
    private static List<Integer> inOrder(TreeNode tree, List<Integer> nodeList) {
        if (tree==null){
            return nodeList;
        }
        inOrder(tree.left,nodeList);
        nodeList.add(tree.val);
        inOrder(tree.right,nodeList);
        return nodeList;
    }
}

/**
 * 定义二叉树
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
