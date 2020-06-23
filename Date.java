
/**
 * The class Date is a simple class that stores infromation about a date with month, day, and year.
 *
 * @author Valerie Foster
 * @version 1/16/2018
 */
public class Date {

    // instance variables
    private int month;
    private int day;
    private int year;

    /**
     * Constructor for objects of class Date
     * 
     * @param   month   the date's month
     * @param   day     the date's day
     * @param   year    the dates's year
     * @throws  IllegalArgumentException if the month is less than 1 or greater than 12
     * @throws  IllegalArgumentException if the day is less than 1 or greater than 31
     * @throws  IllegalArgumentException if the year is negative
     */
    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("The month should be between 1 and 12");
        if (day <= 0 || day > 31)
            throw new IllegalArgumentException("The day should be between 1 and 31");
        if (year <= 0)
            throw new IllegalArgumentException("The year should be greater than 0");
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * An accessor - returns the date's month
     * 
     * @return  the date's month, an integer
     */
    public int getMonth() {
        return this.month;
    }
    
    /**
     * An accessor - returns the date's day
     * 
     * @return  the date's day, an integer
     */
    public int getDay() {
        return this.day;
    }
    
    /**
     * An accessor - returns the date's year
     * 
     * @return  the date's year, an integer
     */
    public int getYear() {
        return this.year;
    }
    
    /** 
     * Creates and returns a string representation of this Date
     * 
     * @return  a String showing basic information about the date
     */
    @Override
    public String toString() {
        return "Date: " + this.month + "/" + this.day + "/" + this.year;
    }
}
