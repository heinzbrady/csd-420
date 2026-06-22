/*
 *Brady Heinz 3.2 Assignment 6/18/26
 */

package heinz_mod_3;

import java.util.ArrayList;
import java.util.Random;

public class Heinz_mod_3 {

    public static void main(String[] args) {

        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("Original ArrayList:");
        System.out.println(originalList);

        System.out.println("\nArrayList with Duplicates Removed:");
        System.out.println(uniqueList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> uniqueList = new ArrayList<>();

        for (E element : list) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }

        return uniqueList;
    }
}