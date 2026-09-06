package ExpenseTracker;


enum Category{
    BASIC,
    FUN,
    GROCERY,
    CAR,
    PET,
    SAVINGS;
}
public class Budged {

    public String description;
    public double amount;
    public String category;
    public String date;

    public Budged(String description, String category, double amount, String date){
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    //getters
    public String getDate(){
        return date;
    }
    public String getCategory(){
        return category;
    }
    public double getAmount(){
        return amount;
    }
    public String getDescription(){
        return description;
    }

}
