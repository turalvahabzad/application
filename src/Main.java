import com.sun.javafx.collections.MappingChange;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        Map<String,String>hashmap=new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                hashmap.put(parts[0], parts[1]);
            }
        }
        System.out.println("Sual ingilisce sorushulsun yoxsa Azerbaycan dilinde? ");
        String chooselanguage=new Scanner(System.in).nextLine();






    }
}