package offer;

/**题目描述：操作给定的二叉树，将其变换为原二叉树的镜像
 *              1                          1
 *           2      3        ---->     3        2
 *        4     5 6     7           7     6  5      4
 *    思路：本质上来讲，就是把二叉树的左孩子和右孩子进行调换
 *         Step1 遍历二叉树
 *         Step2 将子树左右孩子调位
 * @author Major Tom
 * @date 2020/7/7 9:20
 */
public class BinaryMirror {
    public static void mirror(TreeNode root){
        //递归跳出条件
        //root为空判别不可省略，否则会遇到遍历左右孩子结点为空时报无输入异常
        if (root==null)
            return;
        //左右孩子都为空，说明已经到了叶子结点，跳出
        if(root.LChild==null&&root.RChild==null)
            return;
        //交换左右孩子结点
        exchangeNode(root,root.LChild,root.RChild);
        mirror(root.LChild);
        mirror(root.RChild);
    }

    /**
     * 左右孩子进行换位
     * @param root 树根（必须要传入）
     * @param lChild
     * @param rChild
     */
    private static void exchangeNode(TreeNode root,TreeNode lChild, TreeNode rChild) {
        root.LChild=rChild;
        root.RChild=lChild;
    }
    /**
     * 占字数哇占字数，占字数哇占字数
     * 占字数哇占字数，占字数哇占字数
     * 占字数哇占字数，占字数哇占字数
     * 占字数哇占字数，占字数哇占字数
     * 占字数哇占字数，占字数哇占字数
     * 占字数哇占字数，占字数哇占字数
     * 占字数哇占字数，占字数哇占字数
     * 占字数哇占字数，占字数哇占字数
     * 占字数哇占字数，占字数哇占字数
     * 占字数哇占字数，占字数哇占字数
     */
}
