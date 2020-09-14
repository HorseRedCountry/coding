package offer;

import java.util.Stack;

/**题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列
 *         是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序
 *         列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应
 *         的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *         PS：这两个序列的长度是相等的
 *         思路：刚开始想的方法是穷举法，思考了很久感觉步骤异常繁琐。后面
 *              看了下讨论，发现自己把事情给想复杂了。既然是判断一个序列
 *              是否为正确的出栈序列，那只需把入栈序列按照出栈序列的顺序
 *              再依次压入栈中，然后再出栈，看最后辅助栈是否为空即可。
 *              Step1 创建一个辅助栈，遍历入栈序列，将入栈序列依次压入栈中
 *              Step2 压入后，判断栈顶元素和弹栈序列第一个元素是否相等
 *                    相等，则弹出栈顶；不相等，则继续压入
 *              Step3 入栈序列遍历完毕后，若辅助栈为空，则说明弹出序列合法
 *                    否则，不合法
 * @author Major Tom
 * @date 2020/7/9 14:13
 */
public class IsPopOrder {
    public static boolean isPopOrder(int[] pushA,int[] popA){
        //创建辅助栈，用来压栈、弹栈，验证序列合法性
        Stack<Integer> verifyStack=new Stack<Integer>();
        //弹出序列下标
        int index=0;
        //遍历入栈序列
        for (int i = 0; i < pushA.length; i++) {
            //入栈
            verifyStack.push(pushA[i]);
            //若栈顶元素值=出栈序列首值，则弹栈
            //如pushA为12345，popA为43512，当遍历到4时，出栈
            //此时辅助栈内为321，popA剩余3512，继续出栈
            //此时辅助栈内为21，popA身故512，入栈
            //此时辅助栈内为521，popA身故512，出栈
            //此时辅助栈内为21，popA身故12，遍历结束
            //此时辅助栈不为空，说明popA序列不合法
            while (!verifyStack.isEmpty()&&verifyStack.peek()==popA[index]){
                verifyStack.pop();
                index++;
            }
        }
        return verifyStack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA=new int[]{1,2,3,4,5};
        int[] pushB=new int[]{4,3,5,1,2};
        System.out.println(IsPopOrder.isPopOrder(pushA, pushB));//false
    }
}
