package offer;
/**
 * 合并两个排序链表,合并后的链表依然有序
 * @author Major Tom
 * @date 2020/7/3 13:23
 */
/*
    题目描述：输入两个单调递增的链表，输出两个链表合成后的链表
             当然我们需要合成后的链表满足单调不减规则。
       思路：可以以一个链表为基准，把第二个链表中的结点一个个往里面插入
 */
public class MergeList {
    /**
     * 非递归版
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge(ListNode list1,ListNode list2){
        //存储合并后的链表
        ListNode mergeList=list1;
        //做中转用
        ListNode next=null;
        //list2往list1里面插入，list2应置于外层循环
        while (list2!=null){
            //如果此处为null，则说明list1已经到头
            //只需把list2往list1屁股上面接上去就行
            if (list1.next!=null){
                //不能写成对list1.head的判断，必须判断当前结点的next结点是否为null，否则就断了
                while (list1.next!=null){
                    //若条件成立，则需把list2结点接到list1首结点上面
                    if(list2.val<=list1.val){
                        next=list2.next;
                        list2.next=list1;
                        list1=list2;
                        //mergeList指向，否则链表将缺失结点
                        mergeList=list1;
                        //list2next结点重新确定为list2头结点
                        list2=next;
                        //跳出内层循环，跳出后仍然为对list2的遍历
                        break;
                        //list2结点的数值域list1和list1.next结点范围内的值进行比较
                        //这里必须采取区间比较，若满足，将list2结点插入
                    }else if (list2.val>list1.val&&list2.val<=list1.next.val){
                        next=list2.next;
                        list2.next=list1.next;
                        list1.next=list2;
                        list2=next;
                        //此处不对list1头指针进行后移操作，因为做了的话将会满足上面判断条件
                        //同时，进入上个判断条件后会对mergeList进行赋值，导致第一次插入的结点缺失
                        break;
                    }else{
                        //都不满足，遍历list1
                        list1=list1.next;
                    }
                }
            }else{
                //进入此处说明list1已经遍历完，只需将list2与list1的屁股串起来就行
                list1.next=list2;
                //跳出外层循环，直接return
                break;
            }
        }
        return mergeList;
    }

    /**
     * 递归版
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeRecursion(ListNode list1,ListNode list2){
        //跳出递归的条件
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode pMergeHead = null;
        if(list1.val<list2.val){
            pMergeHead = list1;
            pMergeHead.next = mergeRecursion(list1.next,list2);
        }else{
            pMergeHead = list2;
            pMergeHead.next = mergeRecursion(list1,list2.next);
        }
        return pMergeHead;
    }
}
