
/**
 * The class Main shows examples of the other classes in this project.
 *
 * @author Valerie Foster
 * @version 1/16/2018
 */
public class Main {
    
    public static void main(String[] args) {
        
        Location newLoc = new Location("WA19Seattle", 50.0);
        Customer cust1 = new Customer("Valerie Foster", "9876543210", 6590.63);
        Customer cust2 = new Customer("Sally Fields", "9517532580", 5520.95);
        Customer cust3 = new Customer("Forest Walker", "1905405641", 8160.19);
        Customer cust4 = new Customer("Harry Johnson", "8405493060", 11360.51);
        newLoc.addCust(cust1);
        newLoc.addCust(cust2);
        newLoc.addCust(cust3);
        newLoc.addCust(cust4);
        Date newDate = new Date(1, 16, 2018);
        newLoc.getUnit(3, 2).rentUnit(cust1, newDate, 120.0);
        newLoc.getUnit(6, 8).rentUnit(cust2, newDate, 125.0);
        newLoc.getUnit(7, 1).rentUnit(cust3, newDate, 600.0);
        newLoc.getUnit(0, 9).rentUnit(cust4, newDate, 110.0);
        newLoc.getUnit(11, 4).rentUnit(cust4, newDate, 1100.0);
        
        System.out.println(newLoc);
    }
}
