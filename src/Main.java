import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();


        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                hashMap.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sual ingilisce sorushulsun mu? (yes/no)");
        String languageChoice = scanner.nextLine();

        if (languageChoice.equalsIgnoreCase("yes")) {
            askQuestions(hashMap, scanner);
        } else if (languageChoice.equalsIgnoreCase("no")) {
            askQuestionsReverse(hashMap, scanner);
        } else {
            System.out.println("Geçersiz dil seçimi!");
        }

        scanner.close();
    }

    public static void askQuestions(Map<String, String> wordsMap, Scanner scanner) {
        Random random = new Random();
        Object[] keys = wordsMap.keySet().toArray();

        for (int i = 0; i < keys.length; i++) {
            String word = (String) keys[i];
            String definition = wordsMap.get(word);
            int attempts = 0;

            while (attempts < 3) {
                System.out.print(word + " nedir? ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase(definition)) {
                    System.out.println("Doğrudu!");
                    break;
                } else {
                    attempts++;
                    if (attempts < 3) {
                        System.out.println("Yanlış cevap. Tekrar yoxlayin.");
                    }
                }
            }

            if (attempts == 3) {
                System.out.println("Doğru cavab: " + definition);
            }
        }
    }

    public static void askQuestionsReverse(Map<String, String> wordsMap, Scanner scanner) {
        Random random = new Random();
        Object[] values = wordsMap.values().toArray();

        for (int i = 0; i < values.length; i++) {
            String definition = (String) values[i];
            String word = getKeyByValue(wordsMap, definition);
            int attempts = 0;

            while (attempts < 3) {
                System.out.print(definition + " nedir? ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase(word)) {
                    System.out.println("Doğru!");
                    break;
                } else {
                    attempts++;
                    if (attempts < 3) {
                        System.out.println("Yanlış cevab. Tekrar deneyin.");
                    }
                }
            }

            if (attempts == 3) {
                System.out.println("Doğru cevab: " + word);
            }
        }
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}