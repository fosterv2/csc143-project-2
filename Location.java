
/**
 * The class Location is for the location of a storage facility. It has a name and base price for the location and
 * has methods to manipulate arrays storing information abount the units and the customers at the location.
 *
 * @author Valerie Foster
 * @version 1/16/2018
 */
public class Location {
    
    // class constants
    private static final int STAN_ROWS = 7;
    private static final int HUMID_ROWS = 10;
    private static final int TEMP_ROWS = 12;
    private static final int STAN_COUNT = 10;
    private static final int HUMID_COUNT = 8;
    private static final int TEMP_COUNT = 6;
    
    // instance variables
    private String name;
    private double basePrice;
    private int custCount;
    private Unit[][] unitArr;
    private Customer[] custArr;

    /**
     * Constructor for objects of class Location
     * 
     * @param   name    the name to identify the location
     * @param   price   the base price for units at the location
     * @throws  IllegalArgumentException if the name does not follow the format of two uppercase letters followed by two digits, then more letters
     * @throws  IllegalArgumentException if the price is negative
     */
    public Location(String name, double price) {
        if (!name.matches("[A-Z]{2}\\d{2}\\w+")) {
            throw new IllegalArgumentException("Wrong location name format.");
        }
        if (price < 0.0) {
            throw new IllegalArgumentException("The base price cannot be less than zero.");
        }
        this.name = name;
        this.basePrice = price;
        custCount = 0;
        unitArr = new Unit[12][];
        for (int row = 0; row < STAN_ROWS; row++) {
            unitArr[row] = new Standard[STAN_COUNT];
            for (int col = 0; col < STAN_COUNT; col++) {
                unitArr[row][col] = new Standard(10, 11, 12, this);
            }
        }
        for (int row = STAN_ROWS; row < HUMID_ROWS; row++) {
            unitArr[row] = new HumidControl[HUMID_COUNT];
            for (int col = 0; col < HUMID_COUNT; col++) {
                unitArr[row][col] = new HumidControl(10, 11, 12, this);
            }
        }
        for (int row = HUMID_ROWS; row < TEMP_ROWS; row++) {
            unitArr[row] = new TempControl[TEMP_COUNT];
            for (int col = 0; col < TEMP_COUNT; col++) {
                unitArr[row][col] = new TempControl(10, 11, 12, this);
            }
        }
        custArr = new Customer[100];
    }

    /**
     * An accessor - returns the location's identifier
     * 
     * @return  the location's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * An accessor - returns the location's base price
     * 
     * @return  the location's base price
     */
    public double getBasePrice() {
        return basePrice;
    }
    
    /**
     * This method returns a unit at the point of the given indexes
     *
     * @param   row     an integer for the row index
     * @param   col     an integer for the column index
     * @return          a unit
     */
    public Unit getUnit(int row, int col) {
        return unitArr[row][col];
    }

    /**
     * This method returns a customer at the given index
     *
     * @param   ind     an index
     * @return          a customer
     */
    public Customer getCust(int ind) {
        return custArr[ind];
    }

    /**
     * An accessor - returns how many cutomers there are at this location
     * 
     * @return  the number of total customer's in the location, an integer
     */
    public int getCustCount() {
        return this.custCount;
    }

    /**
     * Adds a customer to the customer array at the current custCount, then adds one to the custCount
     *
     * @param   newCust     a customer to add
     */
    public void addCust(Customer newCust) {
        custArr[custCount] = newCust;
        custCount++;
    }

    /**
     * Creates an array of units rented to the given customer by looping through the units and finding the total number of units 
     * rented to the given customer, generating an array of that size, then filling it with all the units for that customer
     *
     * @param   cust    a customer of the location
     * @return          an array of rented units
     */
    public Unit[] getUnitForCust(Customer cust) {
        int count = 0;
        for (int row = 0; row < unitArr.length; row++) {
            for (int col = 0; col < unitArr[row].length; col++) {
                if (unitArr[row][col].getCust() != null && unitArr[row][col].getCust().equals(cust)) {
                    count++;
                }
            }
        }
        Unit[] unitCust = new Unit[count];
        int idx = 0;
        for (int row = 0; row < unitArr.length; row++) {
            for (int col = 0; col < unitArr[row].length; col++) {
                if (unitArr[row][col].getCust() != null && unitArr[row][col].getCust().equals(cust)) {
                    Unit temp = unitArr[row][col];
                    unitCust[idx] = temp;
                    idx++;
                }
            }
        }
        return unitCust;
    }

    /**
     * Uses the getEmpty method to find all the empty units of all types
     * 
     * @return  an array of unrented units
     */
    public Unit[] getEmptyUnits() {
        return getEmpty(0, unitArr.length);
    }

    /**
     * Uses the getEmpty method to find all the empty standard units
     * 
     * @return  an array of unrented Standard units
     */
    public Unit[] getEmptyStan() {
        return getEmpty(0, STAN_ROWS);
    }
    
    /**
     * Uses the getEmpty method to find all the empty humidity controlled units
     * 
     * @return  an array of unrented HumidControl units
     */
    public Unit[] getEmptyHumid() {
        return getEmpty(STAN_ROWS, HUMID_ROWS);
    }
    
    /**
     * Uses the getEmpty method to find all the empty temperature controlled units
     * 
     * @return  an array of unrented TempControl units
     */
    public Unit[] getEmptyTemp() {
        return getEmpty(HUMID_ROWS, TEMP_ROWS);
    }
    
    /**
     * Creates an array of units that aren't rented to anyone by looping through the units from the given start row to the given end row
     * and finds the total number of units that aren't rented to anyone, then generates an array of that size, filling it with all 
     * the unrented units in the section of the the unitArr it loops through
     *
     * @param   rowStart    integer for where to start searching in the unitArr
     * @param   rowEnd      integer for where to end searching in the unitArr
     * @return              an array of unrented units in the given section of the unitArr
     */
    private Unit[] getEmpty(int rowStart, int rowEnd) {
        int count = 0;
        for (int row = rowStart; row < rowEnd; row++) {
            for (int col = 0; col < unitArr[row].length; col++) {
                if (unitArr[row][col].getCust() == null) {
                    count++;
                }
            }
        }
        Unit[] emptyTemp = new Unit[count];
        int idx = 0;
        for (int row = rowStart; row < rowEnd; row++) {
            for (int col = 0; col < unitArr[row].length; col++) {
                if (unitArr[row][col].getCust() == null) {
                    Unit temp = unitArr[row][col];
                    emptyTemp[idx] = temp;
                    idx++;
                }
            }
        }
        return emptyTemp;
    }
    
    /**
     * This method loops through the cutomer array and uses the getUnitForCust method to charge every customer for all of the units 
     * they rent, and if they rent more than one unit they get a 5% discount
     */
    public void chargeRent() {
        for (int ind = 0; ind < custCount; ind++) {
            Unit[] custUnit = getUnitForCust(custArr[ind]);
            for (int idx = 0; idx < custUnit.length; idx ++) {
                double charge = custUnit[idx].getRentPrice();
                if (custUnit.length < 2) {
                    custArr[ind].chargeAcct(charge);
                } else {
                    custArr[ind].chargeAcct(charge * .95);
                }
            }
        }
    }
    
    /** 
     * Creates and returns a string representation of this Location
     * 
     * @return  a String showing basic information about the location
     */
    @Override
    public String toString() {
        String str = "Location:\n";
        str += "Name: " + name + "\n";
        str += "Customers: " + getCustCount() + "\n";
        for (int row = 0; row < unitArr.length; row++) {
            for (int col = 0; col < unitArr[row].length; col++) {
                str += unitArr[row][col].toString();
            }
        }
        return str;
    }
    
}
