package dailyex;

/**
 * @author Major Tom
 * @date 2020/11/11 19:28
 * @description 统计不同字符个数
 */
public class CharCount {
    public static void main(String[] args) {
        charCount("aaa123  sdsd*");
    }

    private static void charCount(String str) {
        //数字个数
        int nums=0;
        //中英文字母个数
        int chs=0;
        //空格个数
        int blanks=0;
        //其它字符个数
        int others=0;
        //字符串转字符数组
        char[] chars=str.toCharArray();
        //遍历，分别计算
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='0'&&chars[i]<='9'){
                nums++;
            }else if ((chars[i]>='a'&&chars[i]<='z')||(chars[i]>='A'&&chars[i]<='Z')){
                chs++;
            }else if (chars[i]==' '){
                blanks++;
            }else {
                others++;
            }
        }
        //打印
        System.out.println("数字个数为："+nums);
        System.out.println("中英文字符个数为："+chs);
        System.out.println("空格个数为："+blanks);
        System.out.println("其它字符个数为："+others);
    }
}
