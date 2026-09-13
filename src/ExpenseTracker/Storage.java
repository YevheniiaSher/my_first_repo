package ExpenseTracker;

import java.io.*;
import java.util.*;

public class Storage {
    public static void saveExpenses (
            String date,
            String category,
            String description,
            double amount
    ){
        int newId = getNextId();
        //write data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true))){
            writer.write(newId + "|" + date + "|" + category + "|" + description + "|" + amount);
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
    //find expenses by ID
    public static Budged getById(int id){
        try(BufferedReader reader = new BufferedReader(new FileReader("data.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                if(line.startsWith("id|")){
                    continue;
                }
                String[]data = line.split("\\|");
                if(data.length != 5){
                    continue;
                }
                int currentId = Integer.parseInt(data[0]);
                if (currentId == id){
                    return new Budged(currentId, data[3], data[2], Double.parseDouble(data[4]), data[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file:" + e.getMessage());
        } return null;
    }
    //Get next ID
    private static int getNextId(){
        int maxId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                if(line.startsWith("id|")){
                    continue;
                }
                String[]data = line.split("\\|");
                if(data.length != 5){
                    continue;
                }
                int currentId = Integer.parseInt(data[0]);
                if(currentId > maxId){
                    maxId = currentId;
                }
            }
        }catch (FileNotFoundException e){
            // File does not exist yet.
            // First ID will be 1.
        }catch (IOException e){
            System.out.println("Error reading the file:" + e.getMessage());
        }return maxId + 1;
    }
    // Update expense by ID
    public static void updateExpense(
            int id,
            String date,
            String category,
            String description,
            double amount) {

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.startsWith("id|")) {
                    lines.add(line);
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length != 5) {
                    continue;
                }

                int currentId = Integer.parseInt(data[0]);

                if (currentId == id) {

                    line = id + "|" +
                            date + "|" +
                            category + "|" +
                            description + "|" +
                            amount;
                }

                lines.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data.txt"))) {

            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error updating file: " + e.getMessage());
        }
    }
    // Delete expense by ID
    public static void deleteExpense(int id) {

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.startsWith("id|")) {
                    lines.add(line);
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length != 5) {
                    continue;
                }

                int currentId = Integer.parseInt(data[0]);

                if (currentId != id) {
                    lines.add(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data.txt"))) {

            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error deleting record: " + e.getMessage());
        }
    }
}
