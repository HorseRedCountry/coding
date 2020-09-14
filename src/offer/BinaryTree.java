package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的定义及相关操作
 * @author Major Tom
 * @date 2020/7/3 17:20
 */
public class BinaryTree {
    /**
     * 生成一棵二叉树
     * @param nums 用于生成二叉树的数组（数组为二叉树的层次遍历）
     * @param index 数组下标
     * @return 生成的树
     */
    public static TreeNode generateTree(int[] nums,int index){
        TreeNode root=null;
        if (index<nums.length) {
            root=new TreeNode(nums[index]);
            root.LChild=generateTree(nums, 2*index+1);
            root.RChild=generateTree(nums, 2*index+2);
        }
        return root;
    }

    //遍历二叉树（递归）
    /**
     * 层次遍历
     * @param root
     */
    public static void levelOrder(TreeNode root){
        //借助队列
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if (root == null) {
            return;
        }
        TreeNode node=root;
        //树根入队列
        queue.add(root);
        //一层入队终止条件
        while (!queue.isEmpty()){
            //peak()只会返回队首元素，并不出队
            node=queue.peek();
            System.out.print(node.val+"  ");
            if (node.LChild != null) {
                queue.add(node.LChild);
            }
            if (node.RChild != null) {
                queue.add(node.RChild);
            }
            queue.poll();

        }
    }
    /**
     * 先序遍历 根左右
     * @param root
     */
    public static void preOrder(TreeNode root){
        if (root==null)
            return;
        System.out.print(root.val+"  ");
        preOrder(root.LChild);
        preOrder(root.RChild);
    }
    /**
     * 中序遍历 左根右
     * @param root
     */
    public static void inOrder(TreeNode root){
        if (root == null)
            return;
        inOrder(root.LChild);
        System.out.print(root.val+"  ");
        inOrder(root.RChild);
    }
    /**
     * 后序遍历 左右根
     * @param root
     */
    public  static void postOrder(TreeNode root){
        if (root == null)
            return;
        postOrder(root.LChild);
        postOrder(root.RChild);
        System.out.print(root.val+"  ");
    }
}


/**
 * 二叉树结点定义
 */
class TreeNode{
    //数据域
    int val;
    //左孩子
    TreeNode LChild;
    //右孩子
    TreeNode RChild;

    public TreeNode(int val) {
        this.val = val;
        this.LChild = null;
        this.RChild = null;
    }
}