package dailyex;

/**测试try/catch/finally语句块中的一些问题
 * @author Major Tom
 * @date 2020/7/3 14:11
 */
public class TryCatchFinallyDemo {
    /**
     * 测试1：try中有return,不捕获异常
     * @return
     * 结果：try:2
     *      finally:3
     *      return:2
     */
    private static int test1(){
        int count=1;
        try {
            count++;
            System.out.println("try:"+count);
            return count;
        }catch (Exception e){
            count++;
            System.out.println("catch:"+count);
        }finally {
            count++;
            System.out.println("finally:"+count);
        }
        return count;
    }
    /**
     * 测试2：try、catch中有return,捕获异常
     * @return
     * 结果：try:2
     *      catch:3
     *      finally:4
     *      return:3
     */
    private static int test2(){
        int count=1;
        try {
            count++;
            System.out.println("try:"+count);
            int x=count/0;
            return count;
        }catch (Exception e){
            count++;
            System.out.println("catch:"+count);
            return count;
        }finally {
            count++;
            System.out.println("finally:"+count);
        }
    }
    /**
     * 测试3：try、catch、finally中都有return,捕获异常
     * @return
     * 结果：try:2
     *      catch:3
     *      finally:4
     *      return:4
     */
    private static int test3(){
        int count=1;
        try {
            count++;
            System.out.println("try:"+count);
            int x=count/0;
            return count;
        }catch (Exception e){
            count++;
            System.out.println("catch:"+count);
            return count;
        }finally {
            count++;
            System.out.println("finally:"+count);
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println("return:"+test3());
    }
}
