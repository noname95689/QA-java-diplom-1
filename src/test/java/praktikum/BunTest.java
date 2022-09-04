package praktikum;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class BunTest {

    @Test
    public void getNameReturnsName() {
        String name = "Булочка";
        Bun bun = new Bun(name, 11);
        String actualName = bun.getName();
        assertEquals("getName() в bun возвращает не name", name, actualName);
    }

    @Test
    public void getPriceReturnsPrice() {
        float price = 17;
        Bun bun = new Bun("Булочка", price);
        float actualPrice = bun.getPrice();
        assertEquals("getName() в bun возвращает не name", price, actualPrice);
    }
}
