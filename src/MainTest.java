import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private Recipe<Ingredient> recipe;

    @BeforeEach //not considered a test, just makes sure variable is instantiated before every test
    void setUp() {
        recipe = new Recipe<>("Pancakes", "Mix ingredients and cook on a skillet.");
    }

    @Test
    void testAddSolidIngredient() {
        SolidIngredient flour = new SolidIngredient("Flour", 200);
        recipe.addIngredient(flour);

        ArrayList<Ingredient> ingredients = recipe.getIngredients();
        assertEquals(1, ingredients.size()); // ingredients.size() should = 1 bc only 1 ingredient was added
        assertEquals("Flour", ingredients.get(0).getName()); // ingredient at 0 should be "flour"
        assertEquals(200, ingredients.get(0).getQuantity()); // the quantity of Flour should be 200
//        assertEquals() is an error check that will check if the two parameters are equal
//        if it fails, it will throw a runtime error.
    }


    @Test
    void testAddLiquidIngredient() {
        LiquidIngredient milk = new LiquidIngredient("Milk", 150);
        recipe.addIngredient(milk);

        ArrayList<Ingredient> ingredients = recipe.getIngredients();
        assertEquals(1, ingredients.size());
        assertEquals("Milk", ingredients.get(0).getName());
        assertEquals(150, ingredients.get(0).getQuantity());
    }
}