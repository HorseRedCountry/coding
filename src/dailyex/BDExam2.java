package dailyex;


import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/9/14 20:05
 * @description 数组+链表（也可以定义一个简易的哈希表）
 */
public class BDExam2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //参赛人数
        int n=sc.nextInt();
        //牛牛一共发出了m条指令
        int m=sc.nextInt();
        Node[] matrix=new Node[n];
        char[] chars=null;
        for (int i = 0; i < n; i++) {
            Node node=new Node(i);
            node.next=null;
            matrix[i]=node;
        }
        for (int j = 0; j < m; j++) {
            String str=sc.nextLine();
            chars=str.trim().toCharArray();
            matrix=solve(chars,matrix);
        }
    }

    private static Node[] solve(char[] chars, Node[] matrix) {
        int val=(int)chars[1];
        int pos=(int)chars[2];
        //把链表挂到对应的链上
        if(chars[0]=='C'){
            Node root=matrix[pos];
            matrix[val]=null;
            Node node=new Node(val);
            node.next=null;
            while (root.next!=null){
                root=root.next;
            }
            root.next=node;
        }else{
            //查找是一个问题......
            
        }

        return matrix;
    }
}

/**
 * 定义链表结点
 */
class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}
