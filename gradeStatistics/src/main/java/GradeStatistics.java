
import java.util.ArrayList;

public class GradeStatistics {
    private ArrayList<Integer> points;
    
    public GradeStatistics() {
        this.points = new ArrayList<>();
    }
    
    public void addPoints(int grade) {
        if (grade >= 0 && grade <= 100) {
            points.add(grade);
        }
    }
    
    public double pointAverage() {
        int sum = 0;
        for (int grade: this.points) {
            sum += grade;
        }
        return (double) sum / points.size();
    }
    
    public double pointAveragePassing() {
        int sum = 0;
        int count = 0;
        for (int grade: this.points) {
            if (grade >= 50) {
                sum += grade;
                count++;
            }
        }
        if (count == 0) {
            return -1;
        }
        return (double) sum / count;
        
    }
    
    public double passPercentage() {
        int count = 0;
        for (int grade: this.points) {
            if (grade >= 50) {
                count++;
            }
        }
        return (double) (count * 100) / this.points.size();
    }
    
    public void printGradeDistribution() {
        int[] grades = {0, 0, 0, 0, 0, 0};
        int fives = 0;
        int fours = 0;
        int threes = 0;
        int twos = 0;
        int ones = 0;
        int zeroes = 0;
        for (int grade: this.points) {
            if (grade < 50) {
                grades[0]++;
            } else if (grade < 60) {
                grades[1]++;
            } else if (grade < 70) {
                grades[2]++;
            } else if (grade < 80) {
                grades[3]++;
            } else if (grade < 90) {
                grades[4]++;
            } else {
                grades[5]++;
            }
        }
        System.out.println("Grade distribution:");
        for (int i = grades.length - 1; i >= 0; i--) {
            System.out.println(i + ": " + printStars(grades[i]));
        }
        
    }
    
    public String printStars(int num) {
        String stars = "";
        for (int i = 0; i < num; i++) {
            stars += "*";
        }
        return stars;
    }
}
