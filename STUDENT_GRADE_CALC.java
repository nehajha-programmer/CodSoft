import java.util.*;
import java.util.Scanner;

public class STUDENT_GRADE_CALC {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        System.out.println("ENTER YOUR NAME :");
        String name = input.nextLine();
        System.out.println("Enter total marks :");
        int total_marks = input.nextInt();
        System.out.println("Enter your marks for Physics");
         float Physics = input.nextFloat();
         System.out.println("Enter your marks for Chemistry");
         float Chemistry = input.nextFloat();
         System.out.println("Enter your marks for Maths");
         float Maths = input.nextFloat();
         System.out.println("Enter your marks for English");
         float English = input.nextFloat();
         System.out.println("Enter your marks for Computer");
         float Computer = input.nextFloat();
         float sum = (Physics+ Chemistry + Maths+ Computer + English);
        float percentage = ((sum/total_marks)*100);
        System.out.println(name + " got " +  percentage + " % in this examination");
        
        if(percentage>=80){
            System.out.println(name + " got A Grade");
     }
        else if (percentage>=60){
            System.out.println(name + " got B Grade ");
        }
        else if(percentage>=40){
                System.out.println( name + "got c Grade");

            }
            else{
                System.out.println(name + " has not passed this examination");
            }
        }
    }
