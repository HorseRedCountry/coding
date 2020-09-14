package offer;

/**
 * 无头结点链表的相关操作
 * @author Major Tom
 * @date 2020/6/30 15:33
 */
public class List {
    //链表的头指针
    private Node head=null;
    //链表长度
    private int count=0;

    public int getCount(){
        return count;
    }

    public Node getHead() {
        return head;
    }

    //头插法插入，生成的链表为倒序
    void addHead(List list,int val){
        Node node=new Node(val);
        node.next=list.head;
        list.head=node;
        count++;
    }
    //尾插法插入，生成的链表为正序
    //需要一个尾指针，来记录链表的尾节点
    void addTail(List list,int val){
        //首先要判断链表是否为空
        if (list.head == null) {
            Node node=new Node(val);
            list.head=node;
            node.next=null;
            count++;
            return;
        }
        //tail记录链表的尾结点
        Node tail=list.head;
        while (tail.next!=null){
            tail=tail.next;
        }
        //插入
        Node node=new Node(val);
        node.next=null;
        //tail始终指向链表最后一个结点
        tail.next=node;
        tail=node;
        count++;
    }
    /**
     * 在指定位置插入新结点
     * @param list 要操作的链表
     * @param val  插入结点的数值
     * @param position  要插入的位置
     */
    void addNode(List list,int val,int position){
        Node posiNode=list.head;
        Node node=new Node(val);
        if(position>count||position<0){
            System.out.println("插入位置非法！插入位置应该在1和"+count+"之间，包含边界");
            return;
        }else if(position==1){//链表首部插入，涉及到head的更改，得单独处理
            node.next=posiNode;
            list.head=node;
        }else {
            Node preNode=null;
            for (int i = 1; i < position; i++) {
                //记录前驱结点，不然链表就断了
                preNode=posiNode;
                posiNode=posiNode.next;
            }
            node.next=posiNode;
            preNode.next=node;
        }
        count++;
    }
    /**
     * 移除指定位置的结点
     * @param list 要操作的链表
     * @param position 要移除结点的位置
     */
    void removeNode(List list,int position){
        Node posiNode=list.head;//记录要移除的结点
        Node preNode=null;//记录结点前驱
        if(position>count||position<0){
            System.out.println("移除位置非法！移除位置应该在1和"+count+"之间，包含边界");
            return;
        }else if(position==1){//移除首结点，得单独处理
            list.head=posiNode.next;
            System.out.println("第"+position+"个结点已移除，值为："+posiNode.val);
        }else{
            for (int i = 1; i < position; i++) {
                preNode=posiNode;
                posiNode=posiNode.next;
            }
            preNode.next=posiNode.next;
            System.out.println("第"+position+"个结点已移除，值为："+posiNode.val);
        }
       count--;
    }

    /**
     * 反转链表
     * 解法1：遍历旧链表，按头插法动态生成新链表，然后返回
     * @param list
     */
    List reverseList(List list){
        //判断链表是否为空
        if (list.head == null) {
            return null;
        }
        //返回的反转链表
        List reList=new List();
        Node node=list.head;
        while (node!=null){
            //新建结点，把当前结点的值传入
            Node next=new Node(node.val);
            //挂载结点
            next.next=reList.head;
            reList.head=next;
            node=node.next;
        }
        return reList;
    }

    /**
     * 反转链表解法2(空间复杂度低，较优解)
     * 思路：初始状态：1-->2-->3-->4-->5  list.head和reList.head均指向结点1
     *      第一次循环过后:1   2-->3-->4-->5 list.head指向结点2，
     *                      reList.head指向结点1(结点1的next指针域已置空)
     *      第二次循环过后:1<--2   3-->4-->5 list.head指向结点3，
     *                      reList.head指向结点2
     *      ........
     * @param list 要反转的链表
     * @return
     */
    List reverseList2(List list){
        //判断链表是否为空
        if (list.head == null) {
            return null;
        }
        Node node=list.head;
        List reList=new List();
        //存储下一结点
        Node next=null;
        while (node!=null){
            //持有下一个结点的引用
            next=node.next;
            //将后一个结点和反转链表首结点连起来
            node.next=reList.head;
            //反转链表首结点后移，其实类似于头插法
            reList.head=node;
            node=next;
        }
        return reList;
    }

    /**
     * 合并两个排序链表,合并后的链表依然有序(非递归版)
     * @param list1
     * @param list2
     * @return
     */
    public List merge(List list1,List list2){
        //存储合并后的链表
        List mergeList=new List();
        mergeList.head=list1.head;
        //做中转用
        Node next=null;
        //list2往list1里面插入，list2应置于外层循环
        while (list2.head!=null){
            //如果此处为null，则说明list1已经到头
            //只需把list2往list1屁股上面接上去就行
            if (list1.head.next!=null){
                //不能写成对list1.head的判断，必须判断当前结点的next结点是否为null，否则就断了
                while (list1.head.next!=null){
                    //若条件成立，则需把list2结点接到list1首结点上面
                    if(list2.head.val<=list1.head.val){
                        next=list2.head.next;
                        list2.head.next=list1.head;
                        list1.head=list2.head;
                        //mergeList指向，否则链表将缺失结点
                        mergeList.head=list1.head;
                        //list2next结点重新确定为list2头结点
                        list2.head=next;
                        //跳出内层循环，跳出后仍然为对list2的遍历
                        break;
                        //list2结点的数值域list1和list1.next结点范围内的值进行比较
                        //这里必须采取区间比较，若满足，将list2结点插入
                    }else if (list2.head.val>list1.head.val&&list2.head.val<=list1.head.next.val){
                        next=list2.head.next;
                        list2.head.next=list1.head.next;
                        list1.head.next=list2.head;
                        list2.head=next;
                        //此处不对list1头指针进行后移操作，因为做了的话将会满足上面判断条件
                        //同时，进入上个判断条件后会对mergeList进行赋值，导致第一次插入的结点缺失
                        break;
                    }else{
                        //都不满足，遍历list1
                        list1.head=list1.head.next;
                    }
                }
            }else{
                //进入此处说明list1已经遍历完，只需将list2与list1的屁股串起来就行
                list1.head.next=list2.head;
                //跳出外层循环，直接return
                break;
            }
        }
        return mergeList;
    }
    //遍历链表
    void showList(List list){
        Node node=list.head;
        while (node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
    }
}
//定义链表结点
class Node{
    //数据域
    int val;
    //指针域，指向链表的下一个结点
    Node next=null;

    Node(int val){
        this.val=val;
    }
}
