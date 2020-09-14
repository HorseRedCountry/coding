package offer;

/**题目描述：输入两棵二叉树A、B，判断B是不是A的子结构
 *     PS：我们约定空树不是任意一个树的子结构
 *    思路：Step1 前序遍历A
 *         Step2 若是遍历到的结点val和B树根结点val相等，则以该处为A树起点
 *         Step3 前序遍历B，将遍历到的结点一次与A的结点相比较，直至B树为空
 *         Step4 若遍历的过程中处处匹配，返回true；否则，返回false
 * @author Major Tom
 * @date 2020/7/6 13:23
 */
public class Subtree {
    //内层递归，逐个树结点比较
    public static boolean isSubtree(TreeNode root1,TreeNode root2){
        //若满足，说明树A已经遍历完，但是树B还有，即不匹配
        //这里必须得判断root2，否则两树高度一致时会出现明明是子树却返回false的现象
        if (root1==null&&root2!=null)
            return false;
        //root2为空，说明B树已经遍历完
        if(root2==null)
            return true;
        //上面两个if判断才是跳出递归的条件
        if (root1.val==root2.val){
            //逐个结点比较
            return isSubtree(root1.LChild, root2.LChild)&&isSubtree(root1.RChild, root2.RChild);
        }else {
            return false;
        }

    }
    //外层递归，简单来讲就是为了实现树A的遍历
    public static boolean hasSubtree(TreeNode root1,TreeNode root2){
        if (root1==null||root2==null)
            return false;
        //这里用到了逻辑运算的短路特征，即三个条件全为false时，才return false
        //递归过程绕的头晕，就不伸开来讲了
        //PS：递归看多了真的很上头，跟俄罗斯套娃似的
        return isSubtree(root1, root2)||hasSubtree(root1.LChild, root2)||hasSubtree(root1.RChild, root2);
    }
}
