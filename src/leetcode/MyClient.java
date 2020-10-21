package leetcode;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Major Tom
 * @date 2020/10/21 21:59
 * @description 客户端
 */
public class MyClient {
    public static void main(String[] args) {
        try {
            Socket s=new Socket("127.0.0.1",9090);
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();

            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));
            bw.write("测试客户端和服务端通信，服务端接受消息并返回给客户端\n");
            bw.flush();

            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String message=br.readLine();
            System.out.println("服务器"+message);
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
