package d8;
import java.util.Scanner;
/*
//    6、创建类Test，包含主方法
//    1）创建User类的对象newUser，代表新注册的一个用户，通过控制台输入用户名、密码和确认密码，
//    调用User类的reg()，将用户名、密码、确认密码传递过去，并完成注册功能，
//    若注册成功，则进行下一步的登录，若注册失败，则提出相应的提示，程序结束。
//    2）若注册成功，则完成此步骤：通过控制台输入用户名和密码，调用User类中的login()，
//    传递用户名和密码进行登录验证，如果登录成功，则进行下一步的曹邹，否则提出相应的提示，程序结束。
    3）若登录成功，则完成此步骤：先接受用户选择会员的类型（1-儿童 2-学生 3-成人），
    根据选择的情况，创建对应的对象，接受控制台输入该会员的信息，输出每个月会员的信息。
 */
public class Test {
    public static void main(String[] args) {
        User new_user=new User();
        Scanner input=new Scanner(System.in);

        int age;
        String gender;
        String name;
        while (true){
            System.out.print("register, input name:");
            name=input.next();
            System.out.print("set password: ");
            String psw= input.next();
            System.out.print("confirm password: ");
            String psw_1= input.next();
            if (new_user.reg(name,psw,psw_1)){
                System.out.println("register success");
                break;
            }
            else System.out.println("register error");
        }
        System.out.print("select user type: 1-儿童 2-学生 3-成人 ");
        int type=input.nextInt();
        if (type==1){
            System.out.print("set name: ");
            name= input.next();
            System.out.print("set age: ");
            age=input.nextInt();
            System.out.print("set gender: ");
            gender= input.next();
            new_user= new Child(name,gender,age);
            System.out.print("\nUser type: Child");
            System.out.println(", user ID: "+new_user.getUsername()+" user age: "+((Child)new_user).getAge()+
                    "user name: "+((Child) new_user).getName()+" user gender: "+((Child)new_user).getSex());
        } else if (type==2) {
            System.out.print("set name: ");
            name= input.next();
            System.out.print("set age: ");
            age=input.nextInt();
            System.out.print("set gender: ");
            gender= input.next();
            new_user= new Student(name,gender,age);
            System.out.print("\nUser type: Student");
            System.out.println(", user ID: "+new_user.getUsername()+" user age: "+((Student)new_user).getAge()+
                    "user name: "+((Student) new_user).getName()+" user gender: "+((Student)new_user).getSex());
        }
        else{
            System.out.print("set name: ");
            name= input.next();
            System.out.print("set age: ");
            age=input.nextInt();
            System.out.print("set gender: ");
            gender= input.next();
            new_user= new Adult(name,gender,age);
            System.out.print("\nUser type: Adult");
            System.out.println(", user ID: "+new_user.getUsername()+" user age: "+((Adult)new_user).getAge()+
                    "user name: "+((Adult) new_user).getName()+" user gender: "+((Adult)new_user).getSex());
        }
    }
}
