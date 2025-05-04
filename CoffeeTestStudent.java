
import static org.junit.Assert.*;
import org.junit.Test;

public class CoffeeTestStudent {
    @Test
    public void testCalcPrice() {
        Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, false);
        assertEquals(3.0, coffee.calcPrice(), 0.01);
    }
    
    @Test
    public void testEquals() {
        Coffee coffee1 = new Coffee("Latte", Size.MEDIUM, true, false);
        Coffee coffee2 = new Coffee("Latte", Size.MEDIUM, true, false);
        assertTrue(coffee1.equals(coffee2));
    }
}