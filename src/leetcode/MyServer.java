package leetcode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Major Tom
 * @date 2020/10/21 21:49
 * @description 客户端
 */
public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(9090);
            System.out.println("启动服务器>>>>>>>>>>>>");
            Socket s=ss.accept();
            System.out.println("客户端"+s.getInetAddress().getLocalHost()+"已连接到服务器");

            InputStream in;
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));

            String message=br.readLine();
            System.out.println("客户端："+message);
            OutputStream out;
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(message+"\n");
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
