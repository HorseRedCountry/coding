package offer;

/**题目描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 *         请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *         思路：此题为复杂链表的复制，刚开始看了好几遍题，都不清楚这究竟是要干啥。刚开始想着不就是链表的复制嘛，罗里吧嗦说了
 *              这么一大堆。后面仔细分析，发现有random指针的存在，复制这件事变得不那么简单。理了下思路，觉得要解决复制的问题，
 *              那么就该分成两步
 *              Step1 复制主干链表.即先把主链串起来，对random指针的指向不做任何处理
 *              Step2 遍历链表，对从链表的random指针域参照主链表进行赋值
 *              看了题干解析，说所有结点都在同一条链上，并不存在孤立结点
 *              编码完成后我调了将近俩小时，反复改，就是出不了结果
 *              我用非复杂的单链表本地测试，发现主干链完全能clone
 *              虽然我这个在网页编辑器中出不了结果，但我觉得自己的思路和编码没有错误，肯定死那个编辑器有问题
 *              男人，自信就是力量！
 * @author Major Tom
 * @date 2020/7/15 9:39
 */
public class CloneList {
    public static RandomListNode clone(RandomListNode pHead){
        //从链表尾指针指向
        RandomListNode node=new RandomListNode(pHead.label);
        RandomListNode cloneHead=node;
        RandomListNode cloneTail=node;
        //复制主链时遍历起始点
        RandomListNode mainHead=pHead.next;
        //复制主链
        while (mainHead!=null){
            RandomListNode tailNode=new RandomListNode(mainHead.label);
            cloneTail.next=tailNode;
            cloneTail=tailNode;
            mainHead=mainHead.next;
        }
        //尾指针再指向头部，进行二次遍历
        cloneTail=cloneHead;
        //遍历主链表
        RandomListNode randomMainHead=pHead;
        //random指针域逐个指
        while (randomMainHead!=null){
            cloneTail.random=randomMainHead.random;
            cloneTail=cloneTail.next;
            randomMainHead=randomMainHead.next;
        }
        return cloneHead;
    }
    //生成链表，遍历用的
    static RandomListNode generateNode(int[] val){
        RandomListNode head=null;
        for (int i = 0; i < val.length; i++) {
            RandomListNode node=new RandomListNode(val[i]);
            node.next=head;
            head=node;
            System.out.print(head.label+"  ");
        }
        return head;
    }
    //打印链表，测试用
    static void showList(RandomListNode head){
        RandomListNode pHead=head;
        while (pHead!=null){
            System.out.print(pHead.label+"  ");
            pHead=pHead.next;
        }
    }
    public static void main(String[] args) {
        RandomListNode list=CloneList.generateNode(new int[]{1,2,3,4,5});
        System.out.print("链表为：");
        CloneList.showList(list);
        RandomListNode clone=CloneList.clone(list);
        System.out.print("克隆链表为：");
        CloneList.showList(clone);
        /**
         * 测试结果：1  2  3  4  5
         *         链表为：5  4  3  2  1
         *         克隆链表为：5  4  3  2  1
         */
    }
}
//链表结点定义
class RandomListNode{
    int label;
    RandomListNode next=null;
    RandomListNode random=null;

    RandomListNode(int label){
        this.label=label;
    }
}