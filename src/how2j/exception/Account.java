package how2j.exception;

/**
 * @author Major Tom
 * @date 2020/10/23 20:43
 * @description 个人银行账户
 */
public class Account {
    /**账户余额*/
    protected double balance;

    public double getBalance() {
        return balance;
    }

    public Account(double balance){
        this.balance=balance;
    }

    /**
     * 存钱
     * @param amt 存款额
     */
    private void deposit(double amt){
        this.balance+=amt;
    }
    private void withdraw(double amt) throws OverDraftException {
        if (this.balance<amt){
            throw new OverDraftException("余额不足",amt-this.balance);
        }
        this.balance-=amt;
    }

    public static void main(String[] args) {
        Account account=new Account(100);
        account.deposit(1000);
        try {
            account.withdraw(100);
            System.out.println(account.balance);
            account.withdraw(2000);
        } catch (OverDraftException e) {
            System.out.println("透支金额"+e.getDeficit());
            e.printStackTrace();
        }
    }
}
