package leetcode;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Major Tom
 * @date 2020/10/22 11:09
 * @description 客户端
 */
public class ClientServer {
    public static void main(String[] args) throws UnknownHostException,IOException {
        final int port=7000;
        String host="127.0.0.1";
        //创建一个套接字并将其连接到指定的端口上
        Socket socket=new Socket(host, port);
        DataInputStream dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        Scanner sc=new Scanner(System.in);
        boolean flag=false;
        while (!flag){
            System.out.println("请输入正方形的边长：");
            double length=sc.nextDouble();
            dos.writeDouble(length);
            dos.flush();
            double area=dis.readDouble();
            System.out.println("服务器计算后返回的面积为："+area);
            while (true){
                System.out.println("继续计算？（Y/N）");
                String str=sc.next();
                if (str.equalsIgnoreCase("N")){
                    dos.writeInt(0);
                    dos.flush();
                    flag=true;
                    break;
                }else if(str.equalsIgnoreCase("Y")){
                    dos.writeInt(1);
                    dos.flush();
                    break;
                }
            }
        }
        socket.close();
    }
}
