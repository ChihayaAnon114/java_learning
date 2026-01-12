package d7;
import java.util.Random;
/*
1、创建类Card，包括成员如下：
1)私有属性：company(发卡机构)、money(余额)、cardID(卡号，8位0-9的随机数构成，只读属性)
2)构造方法：
a)默认构造方法：给所有属性初始化为 ”大连发卡总行”，0，8位随机数
b)带有1个参数的构造方法：先调用默认构造方法，再给money属性初始化为参数的值
3)自定义方法：
a)boolean desposit(int cash)：实现给卡充值的功能，参数代表充值的金额，充值金额大于0，则修改卡内余额，并返回true，代表充值成功，否则返回false，代表充值失败
b)boolean consume(double pay)：实现消费的功能，参数代表消费金额，消费金额大于0，返回true，代表消费成功，否则返回false，代表消费失败
 */
public class Card {
    private String Company;
    private float money=0;
    private String cardID;
    Card(){
        Company="大连发卡总行";
        money=0.0F;
        setCardID(generate_ID(8));
    }
    Card(int m){
        this();
        money=m;
    }
    public String getCompany() {
        return Company;
    }
    public void setCompany(String company) {
        Company = company;
    }
    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    private String generate_ID(int n) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int digit = r.nextInt(10) ;
            sb.append(digit);
        }
        return sb.toString();
    }
    public boolean deposit(int cash){
        return cash > 0;
    }
    public boolean consume(float pay)
    {
        return pay > 0 ;
    }

}
