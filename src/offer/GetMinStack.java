package offer;

import java.util.ArrayList;

/**题目描述：定义栈的数据结构，在该类中实现一个能够得到栈中所含最小元素
 *         的min函数（时间复杂度为O(1)）
 *         PS：保证测试中不会当栈为空的时候，对栈调用pop()或者min()
 *             或者top()方法
 *    思路：可以采取一个数组，用来存放每次入栈时的最小值
 *         Step1 定义基本栈结点。结点包含数据域和next指针域
 *               定义栈结构，包括栈的first指针，该指针始终指向栈顶
 *               定义存放最小值的数组以及数组的下标
 *         Step2 入栈时，将入栈的数值与数组的最小值进行比较，若该值
 *               小于数组最小值，则将该值加入数组中，否则不做处理；
 *               出栈时，若出栈的值匹配到了数组最后一位元素的值，则
 *               将数组最后一位元素移除
 *        Step3  min函数只返回数组最后一位元素的值即可
 *运行结果：  数组为：  [6, 2, 1]
 *          栈中最小元素为： 1
 *          栈顶元素为： 5
 *          数组为：  [6]
 *          栈中最小元素为： 6
 *          栈顶元素为： 6
 * @author Major Tom
 * @date 2020/7/9 9:45
 */
public class GetMinStack {
    //定义栈的结点
    class Node{
        //数据域
        private int val;
        //指针域
        private Node next;
        //构造方法
        public Node(int val){
            this.val=val;
        }
    }
    //指向栈顶元素
    private Node first=null;
    //存储栈中最小的元素
    ArrayList<Integer> minList=new ArrayList<>(0);
    //数组下标，为了定位到数组尾
    private int index=0;
    /**
     * 判断栈是否为空栈
     * @return
     */
    public boolean isEmpty(){
        return first==null;
    }
    /**
     * 压栈
     * @param node
     */
    public void push(int node){
        //如果数组为空，则将入栈的第一个值直接存入数组
        if (minList.isEmpty()){
            minList.add(node);
        //将即将入栈的值与数组末尾的值进行比较
        //数组末尾的值存储的即为目前入栈的所有结点的最小值
        }else if(node<=minList.get(index)){
            minList.add(node);
            //数组多了一个结点，保证index始终指向数组尾
            index++;
        }
        //元素入栈
        Node newNode=new Node(node);
        newNode.next=first;
        first=newNode;
    }

    /**
     * 弹栈
     */
    public void pop(){
        Node head=first;
        //判断出栈的元素是否为最小值。若为，则数组也需把尾节点移除
        if(head.val==minList.get(index)){
            minList.remove(index);
            //移除尾节点，数组长度-1
            index--;
        }
        first=first.next;
    }

    /**
     * 返回栈顶元素的值
     * @return 栈顶元素值
     */
    public int top(){
        return first.val;
    }

    /**
     * 获取栈中最小的元素
     * @return 最小元素值
     */
    public int min(){
        //返回数组尾节点的值即为栈内元素的最小值
       return minList.get(index);
    }

    public static void main(String[] args) {
        GetMinStack myStack=new GetMinStack();
        myStack.push(6);
        myStack.push(2);
        myStack.push(1);
        myStack.push(4);
        myStack.push(5);
        System.out.println("数组为：  "+myStack.minList);
        System.out.println("栈中最小元素为： "+myStack.min());
        System.out.println("栈顶元素为： "+myStack.top());
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println("数组为：  "+myStack.minList);
        System.out.println("栈中最小元素为： "+myStack.min());
        System.out.println("栈顶元素为： "+myStack.top());
    }
}
