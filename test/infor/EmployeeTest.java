package test.infor;

import infor.Employee;
import infor.Manager;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void test_employee_constructor(){
        Employee test = new Employee("test", 1000);
        assertTrue(test.getName() == "test");
        assertTrue(test.getSalary() == 1000);
    }

    @Test
    public void test_manager_constructor(){
        Manager test = new Manager("test", 1000);
        assertTrue(test.getName() == "test");
        assertTrue(test.getSalary() == 1000);
    }

    @Test
    public void test_salary(){
        Manager test = new Manager("test", 1000);
        Employee test1 = new Employee("test", 1500);
        Employee test2 = new Employee("test", 1500);
        Employee test3 = new Employee("test", 1500);
        Employee test4 = new Employee("test", 1500);
        test.addEmployee(test1);
        assertTrue(test.getSalaries() == 1500);
        test.addEmployee(test2);
        assertTrue(test.getSalaries() == 3000);
        test.addEmployee(test3);
        assertTrue(test.getSalaries() == 4500);
        test.addEmployee(test4);
        assertTrue(test.getSalaries() == 6000);
    }

    @Test
    public void test_sort(){
        Manager test = new Manager("jeremy", 1000);
        Employee test1 = new Employee("kevin", 1500);
        Employee test2 = new Employee("corey", 1500);
        Employee test3 = new Employee("adrian", 1500);
        Employee test4 = new Employee("kristi", 1500);
        test.addEmployee(test1);
        test.addEmployee(test2);
        test.addEmployee(test3);
        test.addEmployee(test4);
        Vector<String> testVec = new Vector<String>();
        testVec.add(test3.getName());
        testVec.add(test2.getName());
        testVec.add(test1.getName());
        testVec.add(test4.getName());
        assertTrue(test.sortEmployees().toString().equals(testVec.toString()));
    }

    @Test
    public void test_manager_toString(){
        Manager test = new Manager("jeremy", 1000);
        assertTrue(test.toString() == "jeremy");
        Employee test1 = new Employee("kevin", 1500);
        test.addEmployee(test1);
        assertTrue(test.toString().equals("jeremy\nEmployees of: jeremy\n\t\tkevin"));
    }

    @Test
    public void test_employee_toString(){
        Employee test1 = new Employee("kevin", 1500);
        assertTrue(test1.toString().equals("kevin"));
    }
    
}