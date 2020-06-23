
/**
 * The class Standard is a child class of Unit and overrides the calcPrice method.
 *
 * @author Valerie Foster
 * @version 1/16/2018
 */
public class Standard extends Unit{
    
    // class constant
    private static final double STAN_RATE = 75.0;
    
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
     * @throws  IllegalArgumentException if the price is neagtive
     */
    public Standard(double width, double length, double height, Location loc, Customer cust, Date date, double price) {
        super(width, length, height, loc, cust, date, price);
    }

    /**
     * The second constructor for objects of class Standard
     */
    public Standard(double width, double length, double height, Location loc) {
        super(width, length, height, loc);
    }
    
    /**
     * Calclates the standard price of the unrented unit using the Location's base price and a flat rate to add to it
     * 
     * @return    a double for the standard rental price of the unit
     */
    public double calcPrice() {
        return super.getLocation().getBasePrice() + STAN_RATE;
    }
    
    /** 
     * Creates and returns a string representation of this Standard
     * 
     * @return  a String showing basic information about the standard unit
     */
    @Override
    public String toString() {
        return "Standard " + super.toString();
    }
    
}
