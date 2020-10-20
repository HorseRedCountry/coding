package leetcode;
/**
 * @author Major Tom
 * @date 2020/10/16 22:27
 * @description 带头结点尾结点链表的定义及其相关操作
 */
public class List {
    /**头结点*/
    Node head=null;
    Node tail=null;
    /**
     * 从数组生成链表（生成的链表为正序）
     * @param arr 数组
     * @return 链表的头结点
     */
    void generateList(int[] arr){
        //头结点
        head=new Node(arr[0]);
        tail=head;
        for (int i = 1; i< arr.length;i++) {
            Node node=new Node(arr[i]);
            tail.next=node;
            tail=node;
        }
    }

    /**
     * 添加结点（添加至链表尾）
     * @param val
     */
    void addTail(int val){
        Node node=new Node(val);
        if(head==null||tail==null){
            head=node;
            tail=node;
        }
        tail.next=node;
        tail=node;
    }

    /**
     * 添加结点（添加至链表头）
     * @param val
     */
    void addHead(int val){
        Node node=new Node(val);
        if(head==null||tail==null){
            head=node;
            tail=node;
        }
        node.next=head;
        head=node;
    }
    void removeTail(){
        Node flag=head;
        while (flag.next!=tail){
            flag=flag.next;
        }
        flag.next=null;
        tail=flag;
    }

    void removeHead(){
        head=head.next;
    }
    /**
     * 打印链表
     */
    void printList(){
        Node node=head;
        System.out.print("链表序列为：");
        while (node.next!=null){
            System.out.print(node.val+"---->");
            node=node.next;
        }
        System.out.print(node.val);
        System.out.println();
    }

    private static class Node {
        /**数据域*/
        int val;
        /**next指针域*/
        Node next=null;

        public Node(int val) {
            this.val = val;
        }
    }
}
