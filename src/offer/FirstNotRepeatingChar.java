package offer;

import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Major Tom
 * @date 2020-08-04 12:07
 * 题目描述：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的
 *         位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 *    思路：可以先把字符串转为字符数组，遍历字符数组，以字符为key，出现的次数为value，存储进LinkedHashMap中。
 *         遍历完毕后，再对LinkedHashMap进行遍历，得到第一个value为1的字符，返回key值。得到key值后，用String
 *         的indexOf()方法得到key的索引。
 *         PS:得用LinkedHashMap，不能用HashMap。因为前者是有序的，而后者是无序的
 */
public class FirstNotRepeatingChar {
    public static int findFirstNotRepeatingChar(String str){
        //判断字符转是否为空
        if (str==null||str.length()==0)
            return -1;
        char[] ch=str.toCharArray();
        LinkedHashMap<Character,Integer> chLinkedHashMap=new LinkedHashMap<Character, Integer>();
        //遍历字符数组，存入哈希表
        for (int i = 0; i < ch.length; i++) {
            if (chLinkedHashMap.containsKey(ch[i])){
                chLinkedHashMap.put(ch[i],chLinkedHashMap.get(ch[i])+1);
            }else{
                chLinkedHashMap.put(ch[i],1);
            }
        }
        Iterator chIterator=chLinkedHashMap.entrySet().iterator();
        //遍历哈希表，找到第一个value为1的key
        while (chIterator.hasNext()){
            Map.Entry<Character, Integer> entry= (Map.Entry<Character, Integer>) chIterator.next();
            if (entry.getValue().equals(1)){
                return str.indexOf(entry.getKey());
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str="google";
        System.out.println(findFirstNotRepeatingChar(str));
    }
}
