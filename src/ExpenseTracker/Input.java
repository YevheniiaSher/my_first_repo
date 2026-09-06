package ExpenseTracker;
import java.util.Scanner;

public class Input {
    public static void main(String[] args){
        Category category;
        String date;
        System.out.println("Please enter the date:");
        Scanner input = new Scanner(System.in);
        try{
            date = input.next();
        } catch (Exception e) {
            System.out.println("Wrong input!");
            System.exit(0);
        }

        System.out.println("Please enter the category:");
        try{
            category = Category.valueOf(input.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong category!");
            System.exit(0);
            return;
        }
    }
}
