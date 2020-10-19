package leetcode;
/**
 * @author Major Tom
 * @date 2020/10/16 22:27
 * @description 不带头结点链表的定义及其相关操作
 */
public class List {

    public static void main(String[] args) {
        List list=new List();
        Node head=list.generateList(new int[]{1,2,3,4,5});
        list.printList(head);
    }
    /**
     * 从数组生成链表（生成的链表为正序）
     * @param arr 数组
     * @return 链表的头结点
     */
    Node generateList(int[] arr){
        //头结点
        Node head=new Node(arr[0]);
        for (int i = arr.length-1; i> 0; i--) {
            Node node=new Node(arr[i]);
            node.next=head.next;
            head.next=node;
        }
        return head;
    }

    /**
     * 添加结点（默认至尾部）
     * @param val 结点数据值
     */
    void addNode(int val){
        Node node=new Node(val);

    }

    /**
     * 打印链表
     * @param head 链表头结点
     */
    void printList(Node head){
        Node node=head;
        while (node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
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
