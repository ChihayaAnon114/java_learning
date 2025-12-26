package d7;
/*
4、创建类DebitCard(借记卡)，继承BankCard
1)带2个参数构造方法：参数代表发卡行和有效期，调用父类的带参数构造方法实现给属性赋值为参数的值
2)重写consume(double pay)，在原有功能的基础上，增加新功能，判断消费后的余额，
如果余额小于0，返回false，代表消费失败，并且原余额不变，否则返回true，代表消费成功，余额发生变化
 */
public class DebitCard extends BankCard  {
    DebitCard(Date d,String comp){
        super(comp,d);
    }

    @Override
    public boolean consume(float pay) {
        float m=this.getMoney();
        if (m-pay<=0){
            return false;
        }
        else {
            setMoney(m-pay);
            return true;
        }
    }
}
