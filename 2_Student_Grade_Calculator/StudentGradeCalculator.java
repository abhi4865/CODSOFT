import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        System.out.println("Student Grade Calculator");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of subjects: ");
            int numberOfSubjects;
            try {
                numberOfSubjects = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Number of subjects must be an integer.");
                return;
            }

            if (numberOfSubjects <= 0) {
                System.out.println("Invalid number of subjects. Must be at least 1.");
                return;
            }

            int total = 0;
            for (int i = 1; i <= numberOfSubjects; i++) {
                System.out.print("Enter marks obtained in subject " + i + ": ");
                int marks;
                try {
                    marks = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid marks input. Please enter integers only.");
                    return;
                }
                total += marks;
            }

            double averagePercentage = (double) total / numberOfSubjects;

            char grade;
            if (averagePercentage >= 90) {
                grade = 'O';
            } else if (averagePercentage >= 80) {
                grade = 'A';
            } else if (averagePercentage >= 70) {
                grade = 'B';
            } else if (averagePercentage >= 60) {
                grade = 'C';
            } else if (averagePercentage >= 50) {
                grade = 'D';
            } else if (averagePercentage >= 40) {
                grade = 'E';
            } else {
                grade = 'F';
            }

            System.out.println("Total marks scored is " + total);
            System.out.printf("Average Percentage Gain is %.2f%%\n", averagePercentage);
            System.out.println("Grade : " + grade);
        }
    }
}
