
/**
 * The class Customer creates a customer with a name, phone number and an account,
 * and it manages that account balance.
 *
 * @author Valerie Foster
 * @version 1/16/2018
 */
public class Customer {
    
    // instance variables
    private String name;
    private String phone;
    private double acctBal;

    /**
     * Constructor for objects of class Customer
     * 
     * @param   name    the customer's first and last name
     * @param   phone   the customer's phone number
     * @param   acctBal the customer's account balance
     * @throws  IllegalArgumentException if the acctBal is negative
     */
    public Customer(String name, String phone, double acctBal) {
        if (acctBal < 0.0) {
            throw new IllegalArgumentException("The account balance cannot be less than zero.");
        }
        setName(name);
        setPhone(phone);
        this.name = name;
        this.phone = phone;
        this.acctBal = acctBal;
    }

    /**
     * An accessor - returns the customer's name
     * 
     * @return  name    a String of the customer's first and last name
     */
    public String getName() {
        return name;
    }
    
    /**
     * An accessor - returns the customer's phone number
     * 
     * @return  phone   a String of 10 digits for the customer's phone number
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * An accessor - returns the customer's account balance
     * 
     * @return  acctBal a double number the customer's account balance
     */
    public double getAcctBal() {
        return acctBal;
    }
    
    /**
     * A mutator method - changes the cutomer's name to the given name
     * 
     * @param   name    a String of the customer's first and last name
     * @throws  IllegalArgumentException if the name is empty or null
     */
    public void setName(String name) {
        if (name == "" || name == null) {
            throw new IllegalArgumentException("The name connot be empty.");
        }
        this.name = name;
    }
    
    /**
     * A mutator method - changes the cutomer's phone number to the given number
     * 
     * @param   phone   a String of 10 digits for the customer's phone number
     * @throws  IllegalArgumentException if the phone number is not a String of 10 digits
     */
    public void setPhone(String phone) {
        if(!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("The phone number must be 10 digits with no characters.");
        }
        this.phone = phone;
    }
    
    /**
     * Subtracts the given amount to the customer's balance
     *
     * @param   charge  the amount to be charged to the account
     * @throws  IllegalArgumentException if the charge is negative
     * @return  the updated account balance
     */
    public double chargeAcct(double charge) {
        if (charge < 0.0) {
            throw new IllegalArgumentException("Charge amounts must be non-negative");
        }
        acctBal -= charge;
        return acctBal;
    }
    
    /**
     * Adds the given amount from the customer's balance (PRECONDITION - the credit amount must be positive)
     *
     * @param   credit  the amount to be credited to the account
     * @throws  IllegalArgumentException if the credit is negative
     * @return  the updated account balance
     */
    public double creditAcct(double credit) {
        if (credit < 0.0) {
            throw new IllegalArgumentException("Credit amounts must be non-negative");
        }
        acctBal += credit;
        return acctBal;
    }
    
    /** 
     * Creates and returns a string representation of this Customer
     * 
     * @return  a String showing basic information about the customer
     */
    @Override
    public String toString() {
        String str = "Customer: " + name + ", " + phone + ", $" + acctBal;
        return str;
    }
    
}
