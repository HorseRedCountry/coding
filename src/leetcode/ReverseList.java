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
}
