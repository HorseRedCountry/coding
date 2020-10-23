package how2j.exception;

/**
 * @author Major Tom
 * @date 2020/10/23 20:51
 * @description 自定义异常
 */
public class OverDraftException extends Exception{
    /**透支额*/
    private double deficit;

    public double getDeficit(){
        return deficit;
    }

    public OverDraftException(String msg,double deficit) {
        super(msg);
        this.deficit = deficit;
    }
}
