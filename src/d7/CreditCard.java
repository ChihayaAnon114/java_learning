package d7;
/*
3、创建类CreditCard(信用卡)，继承BankCard
1)私有属性：limit(透支额度)
2)带3个参数构造方法：先调用父类的带参数构造方法，传递前2个参数给父类的构造方法，再将第3个参数给limit属性赋值
3)重写方法consume(double pay)：在原有功能的基础上，增加新功能，
判断消费后卡内的余额符合信用卡的透支额度，如果符合，则返回true，代表消费成功，否则返回false，代表消费失败
4)重写方法desposit(int cash)：实现给信用卡还款功能，根据参数代表的还款金额，和目前该卡的余额进行比对，
如果还款金额大于欠款，则返回true，代表还款成功，修改余额，否则返回false，代表还款失败，余额不变
 */
public class CreditCard extends BankCard{
    private int limit;
    CreditCard(String company, Date date,int limit){
        super(company,date);
        this.limit=limit;
    }
    @Override
    public boolean consume(float pay) {
        float m=this.getMoney();
        if (pay<=m+limit) {
            setMoney(m-pay);
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(int cash) {
        float m=this.getMoney();
        if (m+cash>=0){
            setMoney(cash+m);
            return true;
        }
        return false;
    }
}
