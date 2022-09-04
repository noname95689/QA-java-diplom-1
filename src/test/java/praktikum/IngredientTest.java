package praktikum;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IngredientTest {
    
    @Test
    public void getPriceReturnsPrice() {
        float price = 50;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Песто", price);
        Float actualPrice = ingredient.getPrice();
        assertEquals("getPrice в Ingredient возвращает не price", price, actualPrice);
    }

    @Test
    public void getNameReturnsName() {
        String name = "Горчица";
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name,15);
        String actualName = ingredient.getName();
        assertEquals("getName в Ingredient возвращает не name", name, actualName);
    }

    @Test
    public void getTypeReturnsType() {
        IngredientType type = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(type, "Томатный",30);
        IngredientType actualType = ingredient.getType();
        assertEquals("getType в Ingredient возвращает не type", type, actualType);
    }
}
