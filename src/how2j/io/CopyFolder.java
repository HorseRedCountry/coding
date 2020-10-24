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
        if(!dest.exists()){
            dest.mkdir();
        }
        if (dest.isFile()){
            System.out.println("目标文件夹是一个文件!");
            return;
        }
        //列出源路径下所有文件
        File[] files=src.listFiles();
        for (File srcFile:files){
            if (src.isFile()){
                //如果是文件，就直接复制
                File newDestFile=new File(dest,src.getName());
                copyFile(src.getAbsolutePath(),newDestFile.getAbsolutePath());
            }
            if (src.isDirectory()){
                //如果是文件夹，就递归
                File newDestFolder=new File(dest,src.getName());
                copyFolder(src.getAbsolutePath(),newDestFolder.getAbsolutePath());
            }
        }
    }

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
        String srcFolder="d:/test";
        String destFolder="C:/Users/mylov/Desktop/copy";
        copyFolder(srcFolder,destFolder);
    }
}
