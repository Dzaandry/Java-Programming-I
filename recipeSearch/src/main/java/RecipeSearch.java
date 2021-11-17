
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Recipe> recipes = new ArrayList<>();

        System.out.println("File to read:");
        String file = scanner.nextLine();

        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        while (true) {
            try ( Scanner scan = new Scanner(Paths.get(file))) {
                System.out.println("Enter command:");
                String command = scanner.nextLine();

                if (command.equals("stop")) {
                    break;
                }

                switch (command) {
                    case "list":
                        addRecipes(scan, recipes);

                        System.out.println("Recipes:");
                        for (Recipe recipe : recipes) {
                            System.out.println(recipe);
                        }
                        recipes.clear();
                        break;
                    case "find name":
                        System.out.println("Searched word:");
                        String searched = scanner.nextLine();

                        addRecipes(scan, recipes);

                        for (Recipe recipe : recipes) {
                            if (recipe.nameContains(searched)) {
                                System.out.println(recipe);
                            }
                        }
                        recipes.clear();
                        break;
                    case "find cooking time":
                        System.out.println("Max cooking time:");
                        int max = Integer.valueOf(scanner.nextLine());

                        addRecipes(scan, recipes);

                        for (Recipe recipe : recipes) {
                            if (recipe.cookingTimeNotMoreThan(max)) {
                                System.out.println(recipe);
                            }
                        }
                        recipes.clear();
                        break;
                    case "find ingredient":
                        System.out.println("Ingredient:");
                        String ingredient = scanner.nextLine();

                        addRecipes(scan, recipes);

                        for (Recipe recipe : recipes) {
                            if (recipe.containsIngredient(ingredient)) {
                                System.out.println(recipe);
                            }
                        }
                        recipes.clear();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void addRecipes(Scanner scan, ArrayList<Recipe> recipes) {
        while (scan.hasNextLine()) {
            String name = scan.nextLine();
            int cookingTime = Integer.valueOf(scan.nextLine());
            Recipe recipe = new Recipe(name, cookingTime);
            recipes.add(recipe);

            while (scan.hasNextLine()) {
                String ingredient = scan.nextLine();
                if (ingredient.isEmpty()) {
                    break;
                }
                recipe.addIngredient(ingredient);
            }
        }
    }
}
