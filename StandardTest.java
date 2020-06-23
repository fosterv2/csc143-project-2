
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StandardTest tests the Standard class.
 *
 * @author  Valerie Foster
 * @version 1/16/2018
 */
public class StandardTest {

    Standard newStan;
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
        newStan = new Standard(2.0, 4.0, 6.0, newLoc, newCust, newDate, 100.0);
    }

    @Test
    public void testConstructor() {
        assertEquals(2.0, newStan.getWidth(), 0.001);
        assertEquals(4.0, newStan.getLength(), 0.001);
        assertEquals(6.0, newStan.getHeight(), 0.001);
        assertEquals(newLoc, newStan.getLocation());
        assertEquals(newCust, newStan.getCust());
        assertEquals(newDate, newStan.getRentDate());
        assertEquals(100.0, newStan.getRentPrice(), 0.001);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testWidthPrecon() {
        Standard badStan = new Standard(-2.0, 4.0, 6.0, newLoc);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testLengthPrecon() {
        Standard badStan = new Standard(2.0, -4.0, 6.0, newLoc);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testHeightPrecon() {
        Standard badStan = new Standard(2.0, 4.0, -6.0, newLoc);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testLocationPrecon() {
        Standard badStan = new Standard(2.0, 4.0, 6.0, null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testPricePrecon() {
        Standard badStan = new Standard(2.0, 4.0, 6.0, newLoc, newCust, newDate, -40.0);
    }
    
    @Test
    public void testRentUnit() {
         Standard testStan = new Standard(2.0, 4.0, 6.0, newLoc);
         testStan.rentUnit(newCust, newDate, 85.0);
         assertEquals(newCust, testStan.getCust());
    }
    
    @Test
    public void testReleaseUnit() {
        newStan.releaseUnit();
        assertNull(newStan.getCust());
        assertNull(newStan.getRentDate());
    }
    
    @Test
    public void testCalcPrice() {
        assertEquals(115.0, newStan.calcPrice(), 0.001);
    }
    
}
