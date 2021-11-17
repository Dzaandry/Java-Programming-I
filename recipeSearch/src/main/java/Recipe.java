
import java.util.ArrayList;


public class Recipe {
    private String name;
    private int cookingTime;
    private ArrayList<String> ingredients;
    
    public Recipe(String name, int cookingTime) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = new ArrayList<>();
    }
    
    public Boolean cookingTimeNotMoreThan(int max) {
        return this.cookingTime <= max;
    }
    
    public Boolean nameContains(String searched) {
        return this.name.contains(searched);
    }
    
    public Boolean containsIngredient(String ingredient) {
            for (String s: this.ingredients) {
                if (s.equals(ingredient)) {
                    return true;
                }
            }
        
        return false;
    }
    
    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }
    
    public String toString() {
        return this.name + ", cooking time: " + this.cookingTime;
    }
}
