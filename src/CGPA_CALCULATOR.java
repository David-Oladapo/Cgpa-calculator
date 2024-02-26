import java.util.Scanner;
import java.util.Arrays;
public class CGPA_CALCULATOR{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.println("Enter the department: ");
        String department = input.nextLine();

        System.out.println("Enter the level: ");
        String level = input.nextLine();

        System.out.println("Enter the number of students in your class: ");
        int classize;

        // Input validation for class size
        while (true) {
            if (input.hasNextInt()) {
                classize = input.nextInt();
                input.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number for class size.");
                input.nextLine(); // Consume invalid input
            }
        }

        double totalcgpa=0;
        double totalunits=0;
        double totalprodunits=0;
        // end of variable and aray declaration


        for(int reps=0; reps<classize; reps++){
            System.out.println("\n------------------------");
            System.out.println("Enter your fullname: ");
            String name = input.nextLine();

            System.out.println("Enter your matric number: ");
            String matric = input.nextLine();

            System.out.println("Enter the number of courses offered in  your entire stay in this institution: ");
            int numberOfCourses;
            // Input validation for number of courses
            while (true) {
                if (input.hasNextInt()) {
                    numberOfCourses = input.nextInt();
                    input.nextLine(); // Consume newline
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid number for courses.");
                    input.nextLine(); // Consume invalid input
                }
            }


            String[] coursecode=new String[numberOfCourses];
            double[] courseunit=new double[numberOfCourses];
            char[] coursegrade=new char[numberOfCourses];
            double[] gradeunit=new double[numberOfCourses];
            double[] productunit=new double[numberOfCourses];

            for(int count=0; count<numberOfCourses; count++){

                System.out.println("enter the course code:");
                coursecode[count] = input.nextLine();

                System.out.println("enter the course unit:");
                courseunit[count] = input.nextDouble();

                System.out.println("enter the course grade:");
                coursegrade[count] = input.next().charAt(0);
                input.nextLine();

                if(coursegrade[count]=='A'){
                    gradeunit[count]=5.00;
                }
                else if(coursegrade[count]=='B'){
                    gradeunit[count]=4.00;
                }
                else if(coursegrade[count]=='C'){
                    gradeunit[count]=3.00;
                }
                else if(coursegrade[count]=='D'){
                    gradeunit[count]=2.00;
                }
                else if(coursegrade[count]=='E'){
                    gradeunit[count]=1.00;
                }
                else if(coursegrade[count]=='F'){
                    gradeunit[count]=0.00;
                }
                else{

                    System.out.println("Invalid grade entered, setting grade unit to 0.00");
                    gradeunit[count] = 0.00; // Handle invalid grades

                }
                System.out.println("------------------------\n");

            }

            for(int count3=0; count3<numberOfCourses; count3++){
                totalunits += courseunit[count3];
            }
            for(int count4=0; count4<numberOfCourses; count4++){
                productunit[count4]=courseunit[count4]*gradeunit[count4];
                totalprodunits += productunit[count4];
            }


            for(int count5=0; count5<numberOfCourses; count5++){
                System.out.println(coursecode[count5] + " " + "|" + " " + coursegrade[count5] + " " + "|" + " " + courseunit[count5] + " " + "|" + " " + productunit[count5]);

            }
            double cgpa=totalprodunits/totalunits;
            System.out.println("Your CGPA is: " + cgpa);
            totalcgpa += cgpa;
        }

        double avgcgpa=totalcgpa/classize;
        System.out.println("Department: " + department);
        System.out.println("Level: " + level);
        System.out.println("The average class CGPA is " + avgcgpa);
    }
}
