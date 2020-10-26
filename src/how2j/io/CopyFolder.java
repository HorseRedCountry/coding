package how2j.io;

import java.io.*;

/**
 * @author Major Tom
 * @date 2020/10/23 22:01
 * @description 复制文件夹
 */
public class CopyFolder {
    /**
     * 复制文件夹
     * @param srcFolder 源文件夹
     * @param destFolder 目的文件夹
     */
    private static void copyFolder(String srcFolder,String destFolder){
        /**定义源文件夹和目的文件夹*/
        File src=new File(srcFolder);
        File dest=new File(destFolder);
        if (!src.exists()){
            System.out.println("源文件夹不存在！");
            return;
        }
        if (!src.isDirectory()){
            System.out.println("源文件夹不是一个文件夹！");
            return;
        }
        if (dest.isFile()){
            System.out.println("目标文件夹是一个文件!");
            return;
        }
        //mkdir()：创建此抽象路径名指定的路径
        //mkdirs()：创建此抽象路径名指定的路径，包含创建必须但不存在的父目录
        //例如File file=new File("d:/demo/hahah"),若demo目录不存在，则mkdir会报错，而mkdirs则会创建demo
        if(!dest.exists()){
            dest.mkdirs();
        }
        //列出源路径下所有文件
        File[] files=src.listFiles();
        for (File srcFile:files){
            if (srcFile.isFile()){
                //如果是文件，就直接复制
                File newDestFile=new File(dest,srcFile.getName());
                copyFile(srcFile.getAbsolutePath(),newDestFile.getAbsolutePath());
            }
            if (srcFile.isDirectory()){
                //如果是文件夹，就递归
                File newDestFolder=new File(dest,srcFile.getName());
                copyFolder(srcFile.getAbsolutePath(),newDestFolder.getAbsolutePath());
            }
        }
    }

    /**
     * 复制文件
     * @param srcPath 源路径
     * @param destPath 目的路径
     */
    private static void copyFile(String srcPath, String destPath) {
        File srcFile=new File(srcPath);
        File destFile=new File(destPath);

        byte[] buffer=new byte[1024];

        try {
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);
            while (true){
                int actuallyRead=fis.read(buffer);
                if (actuallyRead==-1){
                    break;
                }
                fos.write(buffer);
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        String srcFolder="D:/demo/folder";
        String destFolder="D:/demo/folder2";
        copyFolder(srcFolder,destFolder);
    }
}
