package offer;


import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/8/23 20:03
 * @description
 */
public class DelNode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();
        int index=sc.nextInt();
        int[] arr=new int[length];

        List list=new List();
        //用数组记录初始链表节结点的值，用于生成链表
        for (int i = 0; i < length; i++) {
            list.addTail(list,sc.nextInt());
        }
        list.removeNode(list,index);
        list.showList(list);
    }

}
