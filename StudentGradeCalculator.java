import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("=================================");

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        double totalMarks = 0;

        // Take marks for each subject
        for (int i = 1; i <= subjects; i++) {

            double marks;

            // Validate marks
            do {
                System.out.print("Enter marks for Subject " + i + " (0-100): ");
                marks = sc.nextDouble();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks! Please enter between 0 and 100.");
                }

            } while (marks < 0 || marks > 100);

            totalMarks += marks;
        }

        // Calculate average
        double average = totalMarks / subjects;

        // Calculate grade
        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else if (average >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Display result
        System.out.println("\n=================================");
        System.out.println("          RESULT");
        System.out.println("=================================");
        System.out.printf("Total Marks : %.2f%n", totalMarks);
        System.out.printf("Average     : %.2f%n", average);
        System.out.println("Grade       : " + grade);
        System.out.println("=================================");

        sc.close();
    }
}