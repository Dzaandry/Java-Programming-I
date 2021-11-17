
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        GradeStatistics stats = new GradeStatistics();
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(stats, scanner);
        
        ui.start();
    }
}
