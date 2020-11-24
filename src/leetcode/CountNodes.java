package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Major Tom
 * @date 2020/11/24 11:19
 * @description 完全二叉树的节点数
 */
public class CountNodes {
    public static void main(String[] args) {
        TreeNode root=generateTree(new int[]{1,2,3,4,5,6},0);
        levelOrder(root);
        System.out.println(countNodes(root));
    }

    /**
     * 二叉树的层次遍历
     * @param root 树根
     */
    private static void levelOrder(TreeNode root) {
        //借助辅助队列完成遍历
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return;
        }
        TreeNode node=root;
        queue.add(node);
        while (!queue.isEmpty()){
            node=queue.peek();
            System.out.print(node.val+" ");
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
            queue.poll();
        }
    }

    /**
     * 从数组生成二叉树（数组为二叉树的层次遍历序列）
     * @param nums 节点值数组
     * @return 二叉树树根
     */
    private static TreeNode generateTree(int[] nums,int index) {
        TreeNode root=null;
        if (index<nums.length){
            root=new TreeNode(nums[index]);
            root.left=generateTree(nums,2*index+1);
            root.right=generateTree(nums,2*index+2);
        }
        return root;
    }

    /**
     * 给出一个完全二叉树，求出该树的节点个数
     * @param root 二叉树的树根
     * @return 所有节点的个数
     */
    private static int countNodes(TreeNode root) {
        int count=0;
        //借助辅助队列完成遍历
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return count;
        }
        TreeNode node=root;
        queue.add(node);
        while (!queue.isEmpty()){
            node=queue.peek();
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
            queue.poll();
            count++;
        }

        return count;
    }
}
