package infor;

public class Employee extends BaseEmployee {

    public Employee(String n, int s){
        super(n, s);
    }

    public String toString(){
        return getName();
    }
}