package d13;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Employee_test {
    //2、读取employee.txt文件中的200条信息，并显示在控制台上
    //3、将年龄在40之内的员工信息挑选出来，写入文件newemployee.txt中，每条信息独立一行
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\user\\Desktop\\java_learning\\src\\d11\\employee.txt");
        List<Employee> emp_lst=new ArrayList<>();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RandomAccessFile rdf = null;
        RandomAccessFile rdf_2 = null;
        rdf = new RandomAccessFile(file, "rw");
        rdf.setLength(0);  // 清空文件

        for (Integer i = 0; i < 50; i++) {
            Employee emp = new Employee();
            String num = (i + 1) + " : ";

            rdf.write(num.getBytes());
            rdf.write(' ');
            rdf.write(emp.toString().getBytes());
            rdf.writeBytes("\n");
            emp_lst.add(emp);
        }
//        rdf.close();
//        rdf.setLength(0);  // 清空文件

        File file2=new File("new_employee.txt");
        rdf_2 = new RandomAccessFile(file2, "rw");
        file2.createNewFile();
        int j=1;
        rdf_2.setLength(0);
        for (int i = 0; i < emp_lst.size(); i++) {
            Employee emp_ =emp_lst.get(i);


            if (emp_.age<40){
                String num = (j) + " : ";

                rdf_2.write("新员工".getBytes());
                rdf_2.write(num.getBytes());
                rdf_2.write(' ');
                rdf_2.write(emp_.toString().getBytes());
                rdf_2.writeBytes("\n");
                j++;
            }
        }
        rdf_2.close();
    }
}
