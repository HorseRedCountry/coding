package dailyex;

import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String regex="^(?=^.{3,255}$)[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+$";
        String domain="adc.sss.c_!";
        if(!Pattern.matches(regex,domain)){
            System.out.println("域名不合法！"+domain);
        }else{
            System.out.println("域名合法！"+domain);
        }
    }
}
