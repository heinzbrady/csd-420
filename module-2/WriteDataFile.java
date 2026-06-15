/*
 * Brady Heinz June 11, 2026 2.2 Programming Assignment
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteDataFile {
    public static void main(String[] args) {
        final String FILE_NAME = "heinz_datafile.dat";

        int[] randomIntegers = new int[5];
        double[] randomDoubles = new double[5];

        Random random = new Random();

        // Fill the integer array with random integers from 1 to 100
        for (int i = 0; i < randomIntegers.length; i++) {
            randomIntegers[i] = random.nextInt(100) + 1;
        }

        // Fill the double array with random double values from 1.0 to 100.0
        for (int i = 0; i < randomDoubles.length; i++) {
            randomDoubles[i] = 1.0 + (99.0 * random.nextDouble());
        }

        // Write data to the file in append mode
        try (PrintWriter output = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            output.println("Random Integer Values:");
            for (int value : randomIntegers) {
                output.print(value + " ");
            }

            output.println();

            output.println("Random Double Values:");
            for (double value : randomDoubles) {
                output.printf("%.2f ", value);
            }

            output.println();
            output.println("--------------------------------");

            System.out.println("Data was successfully written to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}