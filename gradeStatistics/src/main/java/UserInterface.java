
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Scanner scan;
    private GradeStatistics stats;
    
    public UserInterface(GradeStatistics stats, Scanner scanner) {
        this.stats = stats;
        this.scan = scanner;
    }
    
    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int input = Integer.valueOf(scan.nextLine());
            
            if (input == -1) {
                break;
            }
            stats.addPoints(input);
        }
        System.out.println("Point average (all): " + stats.pointAverage());
        
        if (stats.pointAveragePassing() == -1) {
            System.out.println("Point average (passing): -");
        } else {
            System.out.println("Point average (passing): " + stats.pointAveragePassing());
        }
        
        System.out.println("Pass percentage: " + stats.passPercentage());
        stats.printGradeDistribution();
    }
    
}
