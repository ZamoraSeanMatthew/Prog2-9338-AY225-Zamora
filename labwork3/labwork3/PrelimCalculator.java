import java.util.Scanner;

public class PrelimCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter Attendance Grade: ");
        double attendance = sc.nextDouble();

        System.out.print("Enter Lab Work 1 Grade: ");
        double lw1 = sc.nextDouble();

        System.out.print("Enter Lab Work 2 Grade: ");
        double lw2 = sc.nextDouble();

        System.out.print("Enter Lab Work 3 Grade: ");
        double lw3 = sc.nextDouble();

        // Computation
        double labAverage = (lw1 + lw2 + lw3) / 3;
        double classStanding = (attendance * 0.40) + (labAverage * 0.60);

        double requiredPass = (75 - (classStanding * 0.70)) / 0.30;
        double requiredExcellent = (100 - (classStanding * 0.70)) / 0.30;

        // Output
        System.out.println("\n--- PRELIM GRADE REPORT ---");
        System.out.println("Attendance: " + attendance);
        System.out.println("Lab Work 1: " + lw1);
        System.out.println("Lab Work 2: " + lw2);
        System.out.println("Lab Work 3: " + lw3);
        System.out.printf("Lab Work Average: %.2f\n", labAverage);
        System.out.printf("Class Standing: %.2f\n", classStanding);

        System.out.printf("\nRequired Prelim Exam to PASS (75): %.2f\n", requiredPass);
        System.out.printf("Required Prelim Exam for EXCELLENT (100): %.2f\n", requiredExcellent);

        // Remarks
        if (requiredPass <= 100) {
            System.out.println("Remark: You can still pass the Prelim.");
        } else {
            System.out.println("Remark: Passing is no longer possible.");
        }

        if (requiredExcellent <= 100) {
            System.out.println("Remark: You can still achieve an Excellent grade.");
        } else {
            System.out.println("Remark: Excellent grade is no longer possible.");
        }

        sc.close();
    }
}
