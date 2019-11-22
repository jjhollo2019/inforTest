/* Jeremy Holloway
 * Infor coding test
 * 11/22/2019
 */
package infor;

/**
 * This class extends the BaseEmployee class
 * @constraints The super constructor must be used for initializing the abstract class
 */
public class Employee extends BaseEmployee {

    /**
     * This is a basic constructor for the object
     * @param n = The object name
     * @param s = The object salary
     * @pre The super constructor must be called
     * @post The object is initialized using super class
     */
    public Employee(String n, int s){
        //call super constructor
        super(n, s);
    }

    /**
     * This is a common method for both Employee and Manager
     * @return The object name
     */
    public String toString(){
        //return name
        return getName();
    }
}