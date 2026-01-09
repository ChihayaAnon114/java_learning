package d7;
/*
5、创建类BusCard，继承类Card
1)私有属性：mortgage(押金)
2)默认构造方法：调用父类的带参数构造方法，传递20，代表给公交卡充值20元，
给company属性赋值为“大连公交公司”，给mortgage属性赋值为30，代表押金30元
3)重写desposit(int cash)：实现给公交卡充值的功能，公交卡充值只支持20元、50元、100元，
判断参数的有效性决定是否充值成功，若充值成功则返回true，否则返回false
4)重写consume(double pay)：实现乘车刷卡功能，乘车刷卡可以享受9.5折优惠，参数代表需要刷卡的金额，
如果金额大于0，则计算实际需要刷卡的金额，并修改余额，若余额不小于0，返回true，代表刷卡成功，
刷卡后余额小于0，返回false，代表刷卡失败，卡内原有余额不变，如果需要刷卡的金额小于0，返回false，代表刷卡失败。
 */
public class BusCard extends Card {
    private float mortgage;
    BusCard(){
        super(20);
        this.setCompany("大连公交公司");
        mortgage=30;
    }

    public float getMortgage() {
        return mortgage;
    }

    @Override
    public boolean deposit(int cash) {
        if(cash!=20&&cash!=100&&cash!=50)
            return false;
        else {
            float m=this.getMoney();
            this.setMoney(m+cash);
            return true;
        }
    }
    public boolean consume(float pay){
        float p=0.95F*pay;
        float m=this.getMoney();
        if(p>=m||p<=0){
            return false;
        }
        else {
            setMoney(m-p);
            return true;
        }
    }
}
