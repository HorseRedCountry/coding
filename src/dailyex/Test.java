package dailyex;

/**
 * @author Major Tom
 */
public class Test {
    public static String appendStr(String s){
        s+="bbb";
        return s;
    }
    public static StringBuilder appendSb(StringBuilder sb){
        return sb.append("bbb");
    }
    public static void main(String[] args) {
        String s=new String("aaa");
        String ns=Test.appendStr(s);
        System.out.println("String aaa >>>"+s.toString());

        StringBuilder sb=new StringBuilder("aaa");
        StringBuilder nsb=Test.appendSb(sb);
        System.out.println("String aaa >>>"+sb.toString());

        String str="abc";//运行时常量池内新建字面量“abc”，然后符号引用str指向它
        String s2="abc";//发现运行时常量池内已经有“abc”，将s2直接指向
        String s3="a";
        s3=s3+"bc";
        StringBuilder s_3=new StringBuilder(s3);
        s_3.append("bc");
        s3=str.toString();
        String s4="a"+"bc";
        StringBuffer sbb=new StringBuffer();
        String s5=new String("abc");
        System.out.println(str==s2);//true
        System.out.println(str==s3);//false
        System.out.println(str==s4);//true
        System.out.println(str==s5);//false
        System.out.println(s4==s5);//false


    }
}
