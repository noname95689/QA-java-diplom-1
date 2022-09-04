package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.ArrayList;
import java.util.List;

public class BurgerTest {


    Burger burger;

    public List<Ingredient> ingredients = new ArrayList<>();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void prepare() throws Exception {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void addIngredientAddsIngredient() {
        burger = new Burger();
        Ingredient exceptedIngredient  = new Ingredient(IngredientType.SAUCE, "Кетчуп", 15);
        burger.addIngredient(exceptedIngredient);
        Ingredient actualIngredient = burger.ingredients.get(0);
        Assert.assertEquals("addIngredient не добавляет в ingredients",
                exceptedIngredient, actualIngredient);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIngredientRemovesIngredient() {
        burger = new Burger();
        Ingredient unexpectedIngredient  = new Ingredient(IngredientType.SAUCE, "Кетчуп", 15);
        burger.addIngredient(unexpectedIngredient);
        burger.removeIngredient(0);
        Assert.assertEquals("removeIngredient не удаляет позицию из ingredients",
                burger.ingredients.get(0), IndexOutOfBoundsException.class);
    }

    @Test
    public void moveIngredientMovesIngredient() {
        burger = new Burger();
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "Кетчуп", 15);
        Ingredient secondIngredient = new Ingredient(IngredientType.SAUCE, "Горчица", 10);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Ingredient actualIngredient = burger.ingredients.get(1);
        Assert.assertEquals("removeIngredient не удаляет позицию из ingredients",
                actualIngredient, firstIngredient);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.getReceipt();
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(bun.getPrice()).thenReturn(150F);
        Assert.assertEquals("getReceipt возвращает неправильную строку", "(==== Булочка ====)\n" +
                "(==== Булочка ====)\n" + "\n" +"Price: 300,000000" + "\n",
                burger.getReceipt());
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(15F);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кетчуп", 15);
        ingredients.add(ingredient);
        float price = burger.getPrice();
        System.out.println(burger.getPrice());
        Assert.assertEquals("", 30f, price, 1 );
    }
}
