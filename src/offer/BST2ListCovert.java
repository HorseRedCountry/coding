package offer;

import java.util.Stack;

/**题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
 *         只能调整树中结点指针的指向。
 *         思路：不能创建任何新的结点，那就需要在遍历到指定结点时直接调整指针指向
 *         Step1 中序遍历BST，遍历的顺序即为从小到大的顺序，入栈
 *         Step2 入栈完毕后弹栈，生成指定链表
 *         PS：这题我本地编码完成后觉得没问题，但是放到网页编辑器上又是报错。我本地又写了测试方法
 *             发现运行很完美，能实现题目要求，一点鸡儿问题也没有。
 *         测试结果：BST的层次遍历为：8  6  10  4  7  9  11
 *                 链表为：4   6   7   8   9   10   11
 * @author Major Tom
 * @date 2020/7/16 9:41
 */
public class BST2ListCovert {
    //创建辅助栈
    static Stack<TreeNode> stack=new Stack<TreeNode>();
    public static TreeNode convert(TreeNode pRootOfTree){
        //中序遍历BST
        inOrderBST(pRootOfTree);
        //先把链表的头给确定
        TreeNode head=stack.pop();
        head.RChild=null;
        //指向弹栈结点的指针
        TreeNode node;
        //弹栈，创建新链表
        while (!stack.isEmpty()){
            node=stack.pop();
            node.RChild=head;
            head.LChild=node;
            head=node;
        }
        //左孩子指针域置空
        head.LChild=null;
        return head;
    }
    //BST的中序遍历
    private static void inOrderBST(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        inOrderBST(pRootOfTree.LChild);
        stack.push(pRootOfTree);
        inOrderBST(pRootOfTree.RChild);
    }

    public static void main(String[] args) {
        TreeNode root=BinaryTree.generateTree(new int[]{8,6,10,4,7,9,11}, 0);
        System.out.print("BST的层次遍历为：");
        BinaryTree.levelOrder(root);
        TreeNode head=BST2ListCovert.convert(root);
        System.out.println();
        System.out.print("链表为：");
        while (head!=null){
            System.out.print(head.val+"   ");
            head=head.RChild;
        }

    }
}
