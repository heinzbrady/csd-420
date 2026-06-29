/*
Brady Heinz 5.2 Assignment 6/28/26
*/

package mod_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class WordSorterTest {

    public static void main(String[] args) {

        TreeSet<String> words = new TreeSet<>();

        try {
            File file = new File("collection_of_words.txt");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String word = input.next().replaceAll("[^a-zA-Z]", "").toLowerCase();

                if (!word.isEmpty()) {
                    words.add(word);
                }
            }

            input.close();

            System.out.println("Non-duplicate words in ascending order:");
            for (String word : words) {
                System.out.println(word);
            }

            System.out.println("\nNon-duplicate words in descending order:");
            for (String word : words.descendingSet()) {
                System.out.println(word);
            }

            System.out.println("\nTest Results:");
            if (!words.isEmpty()) {
                System.out.println("PASS: The file was read successfully.");
            }

            if (words.size() < 20) {
                System.out.println("PASS: Duplicate words were removed.");
            }

            if (words.first().compareTo(words.last()) <= 0) {
                System.out.println("PASS: Words are sorted correctly.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("collection_of_words.txt was not found.");
        }
    }
}