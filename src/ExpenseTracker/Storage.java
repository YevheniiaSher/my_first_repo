package ExpenseTracker;

import java.io.*;

public class Storage {
    public static void main (String[] args){
//        File dataStorage = new File("data.txt");
//        System.out.println("File Created!");
        //write data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true))){
            writer.write("date|category|description|amount");
            writer.newLine();
        }catch (IOException e){
            System.out.println("Error writing to file: " + e.getMessage());
        }
        //read data
        try(BufferedReader reader = new BufferedReader(new FileReader("data.txt"))){
            String data;
            while ((data = reader.readLine()) != null){
                System.out.println(data);
            }
        }catch (IOException e) {
            System.out.println("Error reading file:"+ e.getMessage());
        }
    }
}
