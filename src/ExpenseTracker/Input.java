package ExpenseTracker;
import java.util.EmptyStackException;
import java.util.Scanner;

public class Input {
    public static void main(String[] args){
        String category = null;
        String date= null;
        String description = null;
        double amount = 0;
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
            category = String.valueOf(Category.valueOf(input.next().toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong category!");
            System.exit(0);
            return;
        }
        System.out.println("Please enter the description:");
        try{
            description = input.next();
        }catch (Exception e){
            System.out.println("Can not be empty!");
        }
        System.out.println("Please enter the amount spent:");
        try{
            amount = input.nextDouble();
        } catch (Exception e) {
            System.out.println("Wrong input!");
        }
        Storage.saveExpenses(date, category, description, amount);
    }
}
