package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Major Tom
 * @date 2020/10/29 10:39
 * @description 求根到叶子节点数字之和
 */
public class SumNumbers {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        TreeNode root=generateTree(arr,0);
        printTree(root);
        System.out.println("");
        preOrder(root);
        System.out.println("");
        System.out.println(sumNumbers(root));
        System.out.println("");
        dfsSearch(root);
        System.out.println("");
        System.out.println(sumNumbersBfs(root));
    }

    /**
     * 计算从根到叶子节点生成的所有数字之和,本质上是dfs
     * @param root 二叉树树根
     * @return 所有数字之和
     */
    private static int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    /**
     * 深度优先求解
     * @param root 树根节点
     * @param preSum 之前节点的数字之和
     * @return 总和
     */
    private static int dfs(TreeNode root, int preSum) {
        if (root==null){
            return 0;
        }
        int sum=preSum*10+root.val;
        if (root.left==null&&root.right==null){
            return sum;
        }else {
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }

    /**
     * 广度优先求解
     * @param root 树根节点
     * @return 总和
     */
    private static int sumNumbersBfs(TreeNode root){
        if (root==null){
            return 0;
        }
        int sum=0;
        Queue<TreeNode> nodeQueue=new LinkedList<>();
        Queue<Integer> numsQueue=new LinkedList<>();
        nodeQueue.offer(root);
        numsQueue.offer(root.val);
        while (!nodeQueue.isEmpty()){
            TreeNode node=nodeQueue.poll();
            int num=numsQueue.poll();
            TreeNode left=node.left;
            TreeNode right=node.right;
            if (left==null&&right==null){
                sum+=num;
            }else {
                if (left!=null){
                    nodeQueue.offer(left);
                    numsQueue.offer(num*10+ left.val);
                }
                if (right!=null){
                    nodeQueue.offer(right);
                    numsQueue.offer(num*10+right.val);
                }
            }
        }
        return sum;
    }
    /**
     * 深度优先搜索
     * @param root 树根
     */
    private static void dfsSearch(TreeNode root){
        if (root==null){
            return;
        }
        System.out.print(root.val+" ");
        if (root.left!=null){
            dfsSearch(root.left);
        }else {
            dfsSearch(root.right);
        }
    }

    /**
     * 从数组生成一棵二叉树
     * @param arr 二叉树的层次遍历序列
     * @param index 索引
     * @return 生成的二叉树的树根
     */
    private static TreeNode generateTree(int[] arr,int index){
        TreeNode root=null;
        if (index<arr.length){
            root=new TreeNode(arr[index]);
            root.left=generateTree(arr,index*2+1);
            root.right=generateTree(arr,index*2+2);
        }
        return root;
    }

    /**
     * 打印二叉树(借助队列)  层次遍历
     * @param root 二叉树树根
     */
    private static void printTree(TreeNode root){
        if (root==null){
            return;
        }
        TreeNode node;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        //终止条件：队列为空
        while (!queue.isEmpty()){
            //并不出队
            node=queue.peek();
            System.out.print(node.val+" ");
            //一层入队
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
            //根节点出队
            queue.poll();
        }
    }

    /**
     * 先序遍历二叉树：根左右
     * @param root
     */
    private static void preOrder(TreeNode root){
        if (root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    /**
     * 定义二叉树节点
     */
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val=x;
        }
    }
}
