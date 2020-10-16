package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Major Tom
 * @date 2020/10/15 21:35
 * @description 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。填充它的每个 next 指针，
 *              让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *              初始状态下，所有 next 指针都被设置为 NULL。
 *
 *              思路：层次遍历即可
 */
public class ConnectRightNode {

    public Node connectAnswer(Node root){
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {

                // 从队首取出元素
                Node node = queue.poll();

                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 返回根节点
        return root;
    }

    public static void main(String[] args) {

    }

    public Node connect(Node root){
        /**创建一个辅助队列，对二叉树进行层次遍历*/
        Queue<Node> queue=new LinkedList<>();
        //树根入队列
        queue.add(root);
        int length=0;
        while (!queue.isEmpty()){
            length=queue.size();
            for (int i = 0; i < length; i++) {

            }
        }
        return null;
    }

    /**
     * 定义二叉树
     */
    class Node{
        int val;
        Node left;
        Node right;
        Node next;

        public Node() {}

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
