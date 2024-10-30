import java.util.ArrayList;

interface Ingredient{
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public SolidIngredient(String name, double quantity){
        _name = name;
        _quantity = quantity;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _quantity;
    }
}
class LiquidIngredient implements Ingredient{

    private String _name;
    private double _quantity;
    public LiquidIngredient(String name, double quantity){
        _name = name;
        _quantity = quantity;
    }
    public String getName() {
        return _name;
    }

    public double getQuantity() {
        return _quantity;
    }
}
class Recipe<T extends Ingredient>{
    private String _name;
    private String instructions;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    public Recipe(){ //MAKE NARG
        ingredients = new ArrayList<>();
    }
    public void addIngredient(Ingredient ing){
        ingredients.add(ing);
    }
    public void print(){
        for (int i=0; i<; i++){
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
