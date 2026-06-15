/*
 * Brady Heinz June 11, 2026 2.2 Programming Assignment
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadDataFile {
    public static void main(String[] args) {
        final String FILE_NAME = "heinz_datafile.dat";

        File file = new File(FILE_NAME);

        try (Scanner input = new Scanner(file)) {
            System.out.println("Contents of " + FILE_NAME + ":");
            System.out.println();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + FILE_NAME + " was not found.");
            System.out.println("Run WriteDataFile.java first to create the file.");
        }
    }
}