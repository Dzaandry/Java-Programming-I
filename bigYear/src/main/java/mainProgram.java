
import java.util.ArrayList;
import java.util.Scanner;

public class mainProgram {

    public static void main(String[] args) {
        // NB! Do not create other scanner objects than the one below
        // if and when you create other classes, pass the scanner to them
        // as a parameter

        Scanner scan = new Scanner(System.in);
        ArrayList<Bird> birds = new ArrayList<>();
        
        while (true) {
            System.out.println("?");
            String input = scan.nextLine();
            if (input.equals("Quit")) {
                break;
            }
            
            if (input.equals("Add")) {
                System.out.println("Name:");
                String name = scan.nextLine();
                System.out.println("Name in Latin:");
                String latin = scan.nextLine();
                Bird bird = new Bird(name, latin);
                birds.add(bird);
            }
            
            else if (input.equals("Observation")) {
                System.out.println("Bird?");
                String bird = scan.nextLine();
                
                // count the number of observations added, if count is still 0 after looping, bird wasn't in birds
                int count = 0;   
                for (int i = 0; i < birds.size(); i++) {
                    if (birds.get(i).getName().equals(bird)) {
                        birds.get(i).addObservation();
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Not a bird!");
                }
            }
            else if (input.equals("One")) {
                System.out.println("Bird?");
                String bird = scan.nextLine();
                
                for (int i = 0; i < birds.size(); i++) {
                    if (birds.get(i).getName().equals(bird)) {
                        birds.get(i).printBird();
                    }
                }
            }
            else if (input.equals("All")) {
                for (Bird bird: birds) {
                    bird.printBird();
                }
            }
        }

    }

}
