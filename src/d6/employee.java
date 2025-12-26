package d6;
/*
创建类Employee（员工类），包括如下成员：
私有的属性：员工姓名(name)、员工年龄(age)、员工职位(position)、工资(salary)
公有的默认构造方法：空方法
修改根据私有属性生成的get和set方法，具体要求如下：
年龄必须在18岁以上，当年龄无效时，将年龄强制赋值为18；
职位只能是“售后服务”和“销售员”，如果不符合要求，则强制将职位赋值为“售后服务”；
        工资根据员工的年龄段不同，具体要求：在原有工资基础上累加，18~20岁之间，加1000元，
        21~25岁之间，加1500元，26~30岁之间，加2000元，31~40岁之间，加3000元，41~50岁之间，加3500元，50岁以上, 加4000元
 */
public class employee {
    private String name;
    private String position;
    private int age;
    private int salary;
    employee(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = cal_sala(salary);
    }

    private int cal_sala(int salary) {
        if (this.age<=20)
            return salary+1000;
        else if (this.age<=25) {
            return salary+1500;
        } else if (this.age<=30) {
            return salary+2000;
        } else if (this.age<=40) {
            return salary+3000;
        } else if (this.age<=50) {
            return salary+3500;
        } else
            return salary+4000;
    }

    public void setAge(int age) {
        if (age<=18)
            this.age=18;
        else this.age=age;
    }

    public void setPosition(String position) {
        if(position.equals("售后服务")||position.equals("销售员")){
            this.position = position;
        }
        else this.position="售后服务";
    }
    public void show(){
        System.out.println(this.name+"    "+this.age+"     "+this.position+"   "+this.salary);
    }
}

