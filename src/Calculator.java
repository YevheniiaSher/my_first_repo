import java.util.Scanner;

public class Calculator {
    public static void main (String[] args){
       System.out.println("Welcome to calculator!");

       double num1 = 0.0;
       double num2 = 0.0;
       String operation = "+";

       System.out.println("Please enter the first number:");
       Scanner input = new Scanner(System.in);
       try {
           num1 = input.nextDouble();
       } catch (Exception e) {
           System.out.println("Wrong input!");
           System.exit(0);
        }

       System.out.println("Please enter the second number:");
       try {
           num2 = input.nextDouble();
       } catch (Exception e) {
           System.out.println("Wrong input!");
           System.exit(0);
       }

        System.out.println("Please enter the operation:");
        operation = input.next();

        double x = 0.0;
        switch (operation){
            case "+":
                x = num1 + num2;
                System.out.println(x);
                break;
            case "-":
                x = num1 - num2;
                System.out.println(x);
                break;
            case "*":
                x = num1 * num2;
                System.out.println(x);
                break;
            case "/":
                x = num1 / num2;
                System.out.println(x);
                break;
        }
    }
}
