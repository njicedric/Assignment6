
import static org.junit.Assert.*;
import org.junit.Test;

public class BevShopTestStudent {
    @Test
    public void testIsValidAge() {
        BevShop shop = new BevShop();
        assertTrue(shop.isValidAge(21));
        assertFalse(shop.isValidAge(20));
    }
    
    @Test
    public void testProcessAlcoholOrder() {
        BevShop shop = new BevShop();
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        shop.processAlcoholOrder("Beer", Size.MEDIUM);
        assertEquals(1, shop.getNumOfAlcoholDrink());
    }
}