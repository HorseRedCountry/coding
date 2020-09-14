package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/9/6 20:07
 * @description
 */
public class FindSameVal {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //生成list1
        int m= scanner.nextInt();
        List list1=new List();
        for (int i = 0; i < m; i++) {
            list1.addTail(list1,scanner.nextInt());
        }
        //生成list2
        int n= scanner.nextInt();
        List list2=new List();
        for (int j = 0; j < n; j++) {
            list2.addTail(list2,scanner.nextInt());
        }
        int[] arr=findSameVal(list1,list2);
        for (int k =0; k<arr[list1.getCount()]; k++) {
            if( k!=arr[list1.getCount()]-1){
                System.out.print(arr[k]+" ");
            }else{
                System.out.print(arr[k]);
            }
        }
    }
    //用HashMap来解决问题
    private static int[] findSameVal(List list1, List list2) {
        int[] arr=new int[list1.getCount()+1];
        HashMap<Integer, Integer> map=new HashMap<>();
        Node node1=list1.getHead();
        while (node1!=null){
            map.put(node1.val,node1.val);
            node1=node1.next;
        }
        int i= 0;
        node1=list2.getHead();
        while (node1!=null){
            if (map.containsKey(node1.val)) {
                arr[i]= node1.val;
                i++;
            }
            node1=node1.next;
        }
        arr[list1.getCount()]=i;
        return arr;
    }
}
/**
 * HTTP/1.1 200 状态行，200表示请求成功
 * Server: nginx/1.19.1 服务器的名称
 * Date: Mon, 07 Sep 2020 10:36:41 GMT 当前时间
 * Content-Type: application/json;charset=UTF-8 返回的数据类型及编码
 * Transfer-Encoding: chunked 消息主体的编码格式
 * Connection: keep-alive 发送请求后TCP继续保持连接
 * Cache-Control: no-cache, no-store, max-age=0, must-revalidate 缓存控制
 * Pragma: no-cache 表示数据是否允许缓存进行通信
 * Expires: 0 消息体的有效期
 */
