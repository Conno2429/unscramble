import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class unscramble {
    static ArrayList<String> loadDictionary(String fileName) {
        ArrayList<String> dictionary = new ArrayList<>();
        try {
            File trivia = new File("trivia.txt");
            Scanner myReader = new Scanner(trivia);

            while (myReader.hasNextLine()) {
                String word = myReader.nextLine().trim();
                dictionary.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        return dictionary;
    }

    static String sortWord(String input) {
        char[] characters = input.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }

    public static ArrayList<String> unscramble(Scanner input) {
        ArrayList<String> dictionary = loadDictionary("trivia.txt");
        String[] dictionaryArray = dictionary.toArray(new String[0]);
        String sortedInput = sortWord(input.nextLine());
        ArrayList<String> data = new ArrayList<>();
        
        for (int i = 0; i < dictionaryArray.length; i++) {
            if (sortedInput.equals(sortWord(dictionaryArray[i]))) {
                data.add(dictionaryArray[i]);
            }
        }
        return data;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter scrambled letters:");

        ArrayList<String> output = unscramble(input);
        if (!output.get(0).equals("")) {
            System.out.println("Possible outcomes: ");
            for (int i = 0; i < output.size(); i++) {
                System.out.println(output.get(i));
            }
        } else {
            System.out.println("Mission Failed. We'll get 'em next time.");
        }  
    }
}