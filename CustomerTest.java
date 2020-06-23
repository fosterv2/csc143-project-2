
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest tests the Customer class.
 *
 * @author  Valerie Foster
 * @version 1/16/2018
 */
public class CustomerTest {
    
    Customer newCust;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        newCust = new Customer("Valerie Foster", "1234567890", 10.43);
    }

    @Test
    public void testConstructor() {
        assertEquals("Valerie Foster", newCust.getName());
        assertEquals("1234567890", newCust.getPhone());
        assertEquals(10.43, newCust.getAcctBal(), 0.001);
    }
    
    @Test
    public void testChargeAcct() {
        assertEquals(5.15, newCust.chargeAcct(5.28), 0.001);
    }
    
    @Test
    public void testCreditAcct() {
        assertEquals(20.0, newCust.creditAcct(9.57), 0.001);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testPrecondition() {
        Customer cust2 = new Customer("Valerie Foster", "123456789", 10.43);
    }
    
}

