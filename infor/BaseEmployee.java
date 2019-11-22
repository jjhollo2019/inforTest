/* Jeremy Holloway
 * Infor coding test
 * 11/22/2019
 */
package infor;

/**
 * This class serves as the basis for all employees and allow for greater flexibility 
 * @pre This class must be called from an extended class
 * @post The class is not directly instantiated 
 */
abstract class BaseEmployee {

    //class variables
    private String name;
    private int salary;

    /**
     * This is a pretty basic constructor
     * @param n = the name for the object
     * @param s = the salary for the object
     */
    BaseEmployee(String n, int s){
        name = n;
        salary = s;
    }

    /**
     * Getter for the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the salary
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

}