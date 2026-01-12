package d7;
/*
2、创建类BankCard，继承类Card
1)私有属性：validateDate(有效期)
2)带有2个参数的构造方法：参数分别代表发卡机构和有效期，先调用父类的默认构造方法，再根据参数给对应的属性初始化
 */
public class BankCard extends Card {
    private Date validateDate;
    BankCard(String company, Date date){
        super();
        setCompany(company);
        validateDate=date;
    }

    public Date getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(Date validateDate) {
        this.validateDate = validateDate;
    }
}