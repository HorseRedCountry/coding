package offer;

/**题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *         如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *    思路：首先回顾下二叉搜索树（BST）的定义：若它的左子树不空，则左子树上所有
 *         结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点
 *         的值均大于它的根结点的值。简单来讲，就是左<根<右
 *         所以，对于BST的后序遍历序列而言，我们只需要确定根结点，再把序列分为
 *         左子树和右子树，然后对左右子树分别验证，若都满足左<根<右，则正确
 *         Step1 确定序列里面BST的根结点，由于是后序，所以最后一个即为根结点
 *         Step2 确定左子树和右子树，对左右子树分别进行遍历判断
 * @author Major Tom
 * @date 2020/7/13 10:30
 */
public class VerifySequenceOfBST {
    public static boolean verify(int[] sequence){
        if(sequence.length==0)
            return false;
        return verifySequenceOfBST(sequence,0,sequence.length-1);
    }
    public static boolean verifySequenceOfBST(int[] sequence,int start,int end){
        //若遍历完了还没有报错，则证明该序列为后序遍历
        if(start>=end)
            return true;
        //树根
        int root=sequence[end];
        //确定左子树和右子树的界限
        int border=0;
        while (sequence[border]<root&&border<end)
            border++;
        int i=border;
        //对右子树进行遍历，若发现又小于根结点的值，说明不是
        while (i<end){
            if (sequence[i]<root){
                return false;
            }
            i++;
        }
        //对左右子树分别进行递归判断
        boolean left=verifySequenceOfBST(sequence, start, border-1);
        boolean right=verifySequenceOfBST(sequence, border, end-1);
        return left&&right;
    }

    public static void main(String[] args) {
        int[] sequence=new int[]{4,7,6,9,11,10,8};//true
        System.out.println(VerifySequenceOfBST.verify(sequence));
    }
}
