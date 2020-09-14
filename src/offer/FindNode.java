package offer;
/*
    题目描述：输入一个链表，输出该链表中倒数第K个结点
       思路：输出倒数第k个结点其实就是输出链表第length-k个结点
            Step1 遍历该链表，得出链表的长度length
            Step2 判断k的合法性，即k不能大于length
            Step3 遍历链表，输出链表第length-k个结点
 */
public class FindNode {
    public ListNode findKthToTail(ListNode node,int k){
        //备份链表
        ListNode ln=node;
        int length=0;
        //计算链表的长度
        while (ln!=null){
            ln=ln.next;
            length++;
        }
        if (k>length) {
            System.out.println("输入的值非法！值应该小于链表的长度，链表长度为 "+length);
            return null;
        }
        ListNode listNode=node;
        for (int i = 0; i <=length-k; i++) {
            listNode=listNode.next;
        }
        return listNode;
    }
}

