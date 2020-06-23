
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HumidControlTest tests the HumidControl class.
 *
 * @author  Valerie Foster
 * @version 1/16/2018
 */
public class HumidControlTest {
    
    HumidControl newHumid;
    Location newLoc;
    Customer newCust;
    Date newDate;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        newLoc = new Location("WA19Seattle", 40.0);
        newCust = new Customer("Valerie Foster", "9876543210", 59.63);
        newDate = new Date(5, 5, 2011);
        newHumid = new HumidControl(2.0, 4.0, 6.0, newLoc, newCust, newDate, 100.0);
    }
    
    @Test
    public void testCalcPrice() {
        assertEquals(80.0, newHumid.calcPrice(), 0.001);
    }
}
