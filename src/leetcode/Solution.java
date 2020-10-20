package leetcode;

/**
 * @author Major Tom
 * @date 2020/10/20 10:47
 * @description 测试用
 */
public class Solution {
    public static void main(String[] args) {
        List list=new List();
        list.generateList(new int[]{1,2,3,4,5});
        list.printList();
        list.addTail(6);
        list.printList();
        list.addHead(0);
        list.printList();
        list.removeTail();
        list.printList();
        list.removeHead();
        list.printList();
    }
}
