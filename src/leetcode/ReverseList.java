package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Major Tom
 * @date 2020/10/16 22:21
 * @description 反转链表
 */
public class ReverseList {
    public static void main(String[] args) {
        List list=new List();
        list.generateList(new int[]{1,2,3,4,5});
        list.printList();
        list.reverse();
        list.printList();
    }

    /**
     * 反转链表
     */
    void reverse() {
        List.Node second=head.next;
        List.Node third=second.next;
        head.next=null;
        while (second.next!=null){
            second.next=head;
            head=second;
            second=third;
            third=second.next;
        }
        second.next=head;
        head=second;
    }
}
