
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LocationTest tests the location class.
 *
 * @author  Valerie Foster
 * @version 1/16/2018
 */
public class LocationTest {
    
    Location newLoc;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        newLoc = new Location("WA19Seattle", 50.0);
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
    }
    
    @Test
    public void testConstructor() {
        assertEquals("WA19Seattle", newLoc.getName());
        assertEquals(50.0, newLoc.getBasePrice(), 0.001);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNamePrecon1() {
        Location badLoc = new Location("WAS19Seattle", 50.0);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNamePrecon2() {
        Location badLoc = new Location("WA9Seattle", 50.0);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testPricePrecon() {
        Location badLoc = new Location("WA19Seattle", -10.0);
    }
    
    @Test
    public void testGetCustCount() {
        assertEquals(4, newLoc.getCustCount());
    }
    
    @Test
    public void testGetEmptyUnits() {
        assertEquals(101, newLoc.getEmptyUnits().length);
        assertNull(newLoc.getEmptyUnits()[0].getCust());
    }
    
    @Test
    public void testGetEmptyStan() {
        assertEquals(67, newLoc.getEmptyStan().length);
        assertNull(newLoc.getEmptyUnits()[0].getCust());
    }
    
    @Test
    public void testGetEmptyHumid() {
        assertEquals(23, newLoc.getEmptyHumid().length);
        assertNull(newLoc.getEmptyUnits()[0].getCust());
    }
    
    @Test
    public void testGetEmptyTemp() {
        assertEquals(11, newLoc.getEmptyTemp().length);
        assertNull(newLoc.getEmptyUnits()[0].getCust());
    }
    
    @Test
    public void testChargeRent() {
        newLoc.chargeRent();
        assertEquals(6470.63, newLoc.getCust(0).getAcctBal(), 0.001);
        assertEquals(10211.01, newLoc.getCust(3).getAcctBal(), 0.001);
    }
    
}
