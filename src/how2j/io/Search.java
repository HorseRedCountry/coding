package how2j.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Major Tom
 * @date 2020/10/26 20:14
 * @description 查找文件内容,在指定文件夹内查找.txt文件，查看其中是否有指定字符串
 */
public class Search {
    public static void main(String[] args) {
        File folder=new File("d:/demo/folder");
        search(folder,"magic");
    }

    /**
     * 在文件中查找字符串
     * @param file 要查找的文件
     * @param str 要查找的字符串
     */
    private static void search(File file, String str) {
        if (file.isFile()){
            if (file.getName().toLowerCase().endsWith(".txt")){
                String fileContent=readFileContent(file);
                if (fileContent.contains(str)){
                    System.out.printf("找到包含目标字符串%s的文件，其路径为：%s%n",str,file);
                }
            }
        }
        if (file.isDirectory()){
            File[] files=file.listFiles();
            for (File f:files){
                search(f,str);
            }
        }
    }

    /**
     * 读取文件内容
     * @param file 指定文件
     * @return 文件内容
     */
    private static String readFileContent(File file) {
        try{
            FileReader fileReader = new FileReader(file);
            char[] chars=new char[(int) file.length()];
            fileReader.read(chars);
            return new String(chars);
        }catch (IOException exception){
            exception.printStackTrace();
            return null;
        }
    }
}
