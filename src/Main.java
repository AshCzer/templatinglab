import java.util.*;
import java.io.*;

interface Ingredient{
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantityG;
    public SolidIngredient(String name, double quantityG){
        _name = name;
        _quantityG = quantityG;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _quantityG;
    }
}
class LiquidIngredient implements Ingredient{

    private String _name;
    private double _quantityMl;
    public LiquidIngredient(String name, double quantityMl){
        _name = name;
        _quantityMl = quantityMl;
    }
    public String getName() {
        return _name;
    }

    public double getQuantity() {
        return _quantityMl;
    }
}
class Recipe<T extends Ingredient>{
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;

    public Recipe(String name, String instructions){
        _name = name;
        _instructions = instructions;
        _ingredients = new ArrayList<>();
    }
    public void addIngredient(T ing){
        _ingredients.add(ing);
    }
    public void print() {
        System.out.println("Recipe: " + _name);
        System.out.println("Instructions: " + _instructions);
        System.out.println("Ingredients: ");
        for (T t : _ingredients){
            System.out.println("\t-" + t.getName() + ": " + t.getQuantity());
        }
    }
    public ArrayList<T> getIngredients() {
        return _ingredients;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter recipe name: ");
        String name = s.nextLine();
        System.out.println("Enter instructions: ");
        String instructions = s.nextLine();
        Recipe<Ingredient> recipe = new Recipe<>(name, instructions);
        int uInput = menu(s);
        while (uInput != 3) {
            if (uInput == 1) {
                addIngredient(recipe, s);
            } else if (uInput == 2) {
                recipe.print();
            } else {
                System.out.println("Not a valid choice. Please try again: ");
            }
            uInput = menu(s);
        }
    }
    public static int menu(Scanner s) {
        int uInput = 0;
        boolean valid = false;
        System.out.println("\nRecipe Menu:");
        System.out.println("1. Add ingredient");
        System.out.println("2. List ingredients");
        System.out.println("3. Exit");
        System.out.println("Enter the number corresponding to your choice: ");
        try {
            uInput = Integer.parseInt(s.nextLine());
        }
        catch (Exception e) {
            System.out.println("Not a valid choice. Please try again: ");
        }
        return uInput;
    }
    public static void addIngredient(Recipe<Ingredient> recipe, Scanner s){
        System.out.println("Is this a solid (s) or liquid (l)");
        char type = s.nextLine().toLowerCase().charAt(0);
        System.out.println("Enter ingredient name: ");
        String name = s.nextLine();
        System.out.println("Enter the ingredient's quantity: ");
        double quantity = Double.parseDouble(s.nextLine());
        Ingredient ingredient;
        if (type == 's'){
            ingredient = new SolidIngredient(name, quantity);
        }
        else{
            ingredient = new LiquidIngredient(name, quantity);
        }
        recipe.addIngredient(ingredient);
    }
}
