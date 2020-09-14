package leetcode;

/**
 * @author Major Tom
 * @date 2020/9/14 14:55
 * @description 两数相加
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode list1=generateList(new int[]{0});
        ListNode list2=generateList(new int[]{7,3});
        ListNode result=addTwoNumbers(list1,list2);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //生成的链表
        ListNode result=null;
        //指向链表尾结点的指针
        ListNode tail=null;
        //是否进位
        boolean carry=false;
        //表示每一位相加后的数字
        int val=0;
        while (l1!=null&&l2!=null){
            if(carry){
                val=l1.val+l2.val+1;
                carry=false;
            }else{
                val=l1.val+l2.val;
            }
            if(val>=10){
                val=val-10;
                carry=true;
            }
            ListNode node=new ListNode(val);
            if(result==null){
                result=node;
                tail=node;
            }else{
                tail.next=node;
                tail=node;
            }
            l1=l1.next;
            l2=l2.next;
        }
        ListNode list=l1==null?l2:l1;
        while (list!=null){
            if (carry){
                val=list.val+1;
                carry=false;
            }else{
                val= list.val;
            }
            if(val>=10){
                val=val-10;
                carry=true;
            }
            ListNode node=new ListNode(val);
            tail.next=node;
            tail=node;
            list=list.next;
        }
        if (carry){
            ListNode node=new ListNode(1);
            tail.next=node;
            tail=node;
        }
        return result;
    }

    /**
     * 从数组构建链表
     * @param nums 数组
     * @return 生成的链表
     */
    private static ListNode generateList(int[] nums) {
        //指向链表头结点的指针
        ListNode head=new ListNode(nums[0]);
        head.next=null;
        //指向链表尾结点的指针
        ListNode tail=head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node=new ListNode(nums[i]);
            node.next=null;
            tail.next=node;
            tail=node;
        }
        return head;
    }
}

/**
 * 定义链表
 */
class ListNode{
    /**
     * 数据域
     */
    int val;
    /**
     * 指针域
     */
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

