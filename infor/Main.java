package infor;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

class Main {
    public static void main(String args[]){

        //This will be the standard implementation
        //Create Manager objects
        Manager jeff = new Manager("Jeff", 100000);
        Manager dave = new Manager("Dave", 85000);
        Manager cory = new Manager("Cory", 65000);
        
        //add Managers under the CEO
        jeff.addEmployee(dave);
        jeff.addEmployee(cory);

        //Create Employees 
        Employee andy = new Employee("Andy", 65000);
        Employee dan = new Employee("Dan", 60000);
        Employee jason = new Employee("Jason", 60000);
        Employee rick = new Employee("Rick", 56000);
        Employee suzanne = new Employee("Suzanne", 61000);

        //add employees to dave
        dave.addEmployee(andy);
        dave.addEmployee(dan);
        dave.addEmployee(jason);
        dave.addEmployee(rick);
        dave.addEmployee(suzanne);

        //print results
        System.out.println(jeff.toString());
        int totalSalaries = jeff.getSalaries() + dave.getSalaries() + cory.getSalaries() + jeff.getSalary();
        DecimalFormat df = new DecimalFormat("$###,###");
        System.out.println("Total Salary: " + df.format(totalSalaries));

        //This will be reading from a JSON file
        try {
            Object obj = new JSONParser().parse(new FileReader("JSONInput.json"));

            JSONObject jObj = (JSONObject) obj;

            //I was able to parse jeff but not the others
            //I'm not sure why the parsing failed beyond this point
            Manager jeff2 = new Manager((String) jObj.get("jeff"), Integer.parseInt((String) jObj.get("jeffSalary")));
            Manager dave2 = new Manager("didn't get json", 0);
            Manager cory2 = new Manager("didn't get json", 0);

            /*JSONArray arr = (JSONArray) jObj.get("jeffEmployees");
            for(int i = 0; i < arr.size(); i++){
                //System.out.println(arr.toJSONString());
                JSONObject temp = (JSONObject) arr.get(i);
                if(temp.get("dave").equals("Dave")){
                    dave2 = new Manager((String) temp.get("dave"), Integer.parseInt((String) temp.get("daveSalary")));
                }
                if(temp.get("cory").equals("Cory")){
                    cory2 = new Manager((String) jObj.get("cory"), Integer.parseInt((String) temp.get("corySalary")));
                }
            }*/


            /*
            //add Managers under the CEO
            jeff2.addEmployee(dave2);
            jeff2.addEmployee(cory2);

            //Create Employees
            Employee andy2 =  new Employee("didn't get json", 0);
            Employee dan2 = new Employee("didn't get json", 0);
            Employee jason2 = new Employee("didn't get json", 0);
            Employee rick2 = new Employee("didn't get json", 0);
            Employee suzanne2 = new Employee("didn't get json", 0);

            JSONArray arr2 = (JSONArray) jObj.get("daveEmployees");
            for(int i = 0; i < arr2.size(); i++){
                JSONObject temp = (JSONObject) arr2.get(i);
                if(temp.get("andy").equals("Andy")){
                    andy2 = new Employee((String) temp.get("andy"), Integer.parseInt((String) temp.get("andySalary")));
                }
                if(temp.get("dan").equals("Dan")){
                    dan2 = new Employee((String) temp.get("dan"), Integer.parseInt((String) temp.get("danSalary")));
                }
                if(temp.get("jason").equals("Jason")){
                    jason2 = new Employee((String) temp.get("jason"), Integer.parseInt((String) temp.get("jasonSalary")));
                }
                if(temp.get("rick").equals("Rick")){
                    rick2 = new Employee((String) temp.get("rick"), Integer.parseInt((String) temp.get("rickSalary")));
                }
                if(temp.get("suzanne").equals("Suzanne")){
                    suzanne2 = new Employee((String) temp.get("suzanne"), Integer.parseInt((String) temp.get("suzanneSalary")));
                }
            }

            //add employees to dave
            dave2.addEmployee(andy2);
            dave2.addEmployee(dan2);
            dave2.addEmployee(jason2);
            dave2.addEmployee(rick2);
            dave2.addEmployee(suzanne2);*/

            //print results
            System.out.println("\n" + jeff2.toString());
            totalSalaries = jeff2.getSalaries() + jeff2.getSalary();
            System.out.println("Total Salary: " + df.format(totalSalaries));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}