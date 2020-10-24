package how2j.io;

import java.io.File;

/**
 * @author Major Tom
 * @date 2020/10/24 10:24
 * @description 删除文件
 */
public class DeleteFiles {
    public static void deleteFiles(File file){
        //判断文件存在
        if (file.exists()){
            //判断是否为独立文件
            if (file.isFile()){
                file.delete();
                //判断是否为目录
            }else if (file.isDirectory()){
                File[] files=file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    //递归，逐层删除
                    deleteFiles(files[i]);
                }
                file.delete();
            }
        }else {
            System.out.println("所删除的文件不存在");
        }
    }
}
