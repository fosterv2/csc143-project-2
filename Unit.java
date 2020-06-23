
/**
 * The class Unit is an abstract class that keeps track of the data related to a specific storage unit, such as it's dimentions, 
 * the location it it associated with, and whether it is rented to a customer on a specific date at a specific price.
 *
 * @author Valerie Foster
 * @version 1/16/2018
 */
public abstract class Unit {
    
    // instance variables
    private double width;
    private double length;
    private double height;
    private Location loc;
    private Customer cust;
    private Date rentDate;
    private double rentPrice;

    /**
     * The full constructor for objects of class Unit
     * 
     * @param   type        the unit's type
     * @param   width       the unit's width
     * @param   length      the unit's length
     * @param   height      the unit's height
     * @param   loc         the location the unit is associated with
     * @param   cust        the customer the unit is rented to
     * @param   date        the date the unit was rented to a customer
     * @param   price       the price that the unit is rented at
     * @throws  IllegalArgumentException if the width is negative
     * @throws  IllegalArgumentException if the length is negative
     * @throws  IllegalArgumentException if the height is negative
     * @throws  IllegalArgumentException if the loc is null
     * @throws  IllegalArgumentException if the price is negative
     */
    public Unit(double width, double length, double height, Location loc, Customer cust, Date date, double price) {
        if (width < 0.0) {
            throw new IllegalArgumentException("The width cannot be less than zero.");
        }
        if (length < 0.0) {
            throw new IllegalArgumentException("The length cannot be less than zero.");
        }
        if (height < 0.0) {
            throw new IllegalArgumentException("The height cannot be less than zero.");
        }
        if (loc == null) {
            throw new IllegalArgumentException("The location cannot be empty.");
        }
        if (price < 0.0) {
            throw new IllegalArgumentException("The price cannot be less than zero.");
        }
        this.width = width;
        this.length = length;
        this.height = height;
        this.loc = loc;
        this.cust = cust;
        this.rentDate = date;
        this.rentPrice = price;
    }

    /**
     * The second constructor for objects of class Unit
     */
    public Unit(double width, double length, double height, Location loc) {
        this(width, length, height, loc, null, null, 0.0);
    }
    
    /**
     * An accessor - returns the unit's width
     */
    public double getWidth() {
        return width;
    }
    
    /**
     * An accessor - returns the unit's length
     */
    public double getLength() {
        return length;
    }
    
    /**
     * An accessor - returns the unit's height
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * An accessor - returns the unit's height
     */
    public Location getLocation() {
        return loc;
    }
    
    /**
     * An abstract method to be overriden in child classes
     */
    public abstract double calcPrice();
    
    /**
     * An accessor - returns the Customer associated to the unit if there is one
     */
    public Customer getCust() {
        return cust;
    }
    
    /**
     * An accessor - returns the date the unit was rented if it is rented to a customer
     */
    public Date getRentDate() {
        return rentDate;
    }
    
    /**
     * Returns the unit's rented price if it is rented to a customer or calculates the standard price if it is unrented
     */
    public double getRentPrice() {
        double price = 0.0;
        if (getCust() == null) {
            price = calcPrice();
        } else {
            price = this.rentPrice;
        }
        return price;
    }
    
    /**
     * This method rents a unit to a customer on a date with a renting price
     *
     * @param   cust    a customer the unit is rented to
     * @param   date    the date the unit is rented on
     * @param   price   the price the unit is rented at
     * @throws  IllegalArgumentException if the cust is null
     * @throws  IllegalArgumentException if the date is null
     * @throws  IllegalArgumentException if the price is negative
     */
    public void rentUnit(Customer cust, Date date, Double price) {
        if (cust == null) {
            throw new IllegalArgumentException("The price cannot be less than zero.");
        }
        if (date == null) {
            throw new IllegalArgumentException("The price cannot be less than zero.");
        }
        if (price < 0.0) {
            throw new IllegalArgumentException("The price cannot be less than zero.");
        }
        this.cust = cust;
        this.rentDate = date;
        this.rentPrice = price;
    }
    
    /**
     * This method releases a unit so that it is unrented by making no customer, date, or price attached
     */
    public void releaseUnit() {
        this.cust = null;
        this.rentDate = null;
        this.rentPrice = 0.0;
    }
    
    /** 
     * Creates and returns a string representation of this Unit
     * 
     * @return  a String showing basic information about the unit
     */
    @Override
    public String toString() {
        String str = "unit: " + width + "ft X " + length + "ft X " + height + "ft, ";
        if (getCust() == null) {
            str += "unrented, Standard price: $" + calcPrice() + "\n";
        } else {
            str += "rented, " + cust.toString() + ", " + rentDate.toString() + ", Rental price: $" + rentPrice + "\n";
        }
        return str;
    }
    
}
