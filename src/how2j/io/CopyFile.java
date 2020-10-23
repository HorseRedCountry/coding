package how2j.io;

import java.io.*;

/**
 * @author Major Tom
 * @date 2020/10/23 21:46
 * @description 复制文件
 */
public class CopyFile {
    /**
     * 复制文件
     * @param srcPath 源文件所在路径
     * @param destPath 目的路径
     */
    private static void copyFile(String srcPath,String destPath){
        File srcFile=new File(srcPath);
        File destFile=new File(destPath);
        /**创建缓冲区*/
        byte[] buffer=new byte[1024];
        try {
            //输入流读取文件
            FileInputStream fis=new FileInputStream(srcFile);
            //输出流输出文件
            FileOutputStream fos=new FileOutputStream(destFile);
            while (true){
                //实际读取的长度，等于负一说明已经读完了
                int actuallyReaded=fis.read(buffer);
                if (-1==actuallyReaded){
                    break;
                }
                fos.write(buffer);
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String srcPath="d:/test.txt";
        String destPath="C:/Users/mylov/Desktop/copy.txt";
        copyFile(srcPath,destPath);
    }
}
