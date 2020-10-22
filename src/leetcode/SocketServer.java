package leetcode;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Major Tom
 * @date 2020/10/22 11:09
 * @description 服务端
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        /**设置端口号*/
        final int port=7000;
        //在端口上创建一个服务器套接字
        ServerSocket serverSocket=new ServerSocket(port);
        //监听来自客户端的连接
        Socket socket=serverSocket.accept();
        DataInputStream dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
        do {
            double length=dis.readDouble();
            System.out.println("服务器收到的边长数据为："+length);
            double result=length*length;
            dos.writeDouble(result);
            dos.flush();
        }while (dis.readInt()!=0);
        socket.close();
        serverSocket.close();
    }
}
