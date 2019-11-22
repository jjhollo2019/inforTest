/* Jeremy Holloway
 * Infor coding test
 * 11/22/2019
 */
package infor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

/**
 * This is the manager implementation as per the test specifications
 * @pre Class must extend the abstract base class BaseEmployee
 * @post Manager must call the super constructor during instantiation
 */
public class Manager extends BaseEmployee {

    //Set vector to base type so it can hold managers and employees
    Vector<BaseEmployee> employees;

    /**
     * This is a similarly simple constructor
     * @param n = the manager object name
     * @param s = the manager object salary
     * @pre abstract class must be implemented
     * @post the super constructor is called and employee vector is created
     */
    public Manager(String n, int s){
        super(n, s);
        employees = new Vector<BaseEmployee>();
    }

    /**
     * This function will add and employee to the vector
     * @param employee = the BaseEmployee object to be added
     * @pre employee vector must be intialized
     * @post employee vector contains new object
     */
    public void addEmployee(BaseEmployee employee){
        employees.add(employee);
    }

    /**
     * This function will return the salaries of all employees
     * @return the total employee salary
     * @pre employee vector must be initialized
     * @post no items in employee vector are changed
     */
    public int getSalaries(){
        //init return variable
        int salaryTotal = 0;
        //for each employee in employees
        for(BaseEmployee employee : employees){
            //add employee salary 
            salaryTotal += employee.getSalary();
        }
        //return total salary
        return salaryTotal;
    }

    /**
     * This function will sort the employee vector
     * @return the string vector of names for testing purposes
     * @pre There must be more than one employee before calling this function
     * @post employees will be the sorted vector created in the function
     */
    public Vector<String> sortEmployees(){
        //init vector for sorted items
        Vector<BaseEmployee> newVec = new Vector<BaseEmployee>();
        //hash map the object for easy retrieval
        HashMap<String, BaseEmployee> map = new HashMap<String, BaseEmployee>(); 
        //init vector to easily sort the names
        Vector<String> names = new Vector<String>();
        //for each employee in employees
        for(BaseEmployee employee : employees){
            //add the name to the string vector
            names.add(employee.getName());
            //map the name to the object
            map.put(employee.getName(), employee);
        }

        //call sort
        Collections.sort(names);

        //add the items into the new vector in sorted order
        for(int i = 0; i < names.size(); i++){
            newVec.add(map.get(names.get(i)));
        }

        //replace employees with new vector
        employees = newVec;
        return names;
    }

    /**
     * This is a basic toString function for the class 
     * @pre class must be instantiated before use
     * @post no class variables are modified in the use of toString
     */
    public String toString(){
        //start with name
        String outString = getName();
        //if there are employees to account for
        if(employees.size() > 0){
            //set header string
            outString += "\nEmployees of: " + getName();
            //for each employee in employees
            for(BaseEmployee employee : employees){
                //add new line and a tab
                outString += "\n\t";
                //if employee is a manager
                if(employee.getClass().getSimpleName().equals("Manager")){
                    //add new line and tab before tostring
                    outString += "\n\t" + employee.toString();
                } else {
                    //else just add a tab before to string
                    outString += "\t" + employee.toString();

                }
            }
        }
        return outString;
    }
}