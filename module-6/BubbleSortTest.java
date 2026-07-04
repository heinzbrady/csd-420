/*
 * Brady Heinz 7/4/26 6.2 Assignment
 */

package heinz_mod_6;

import java.util.Comparator;

public class BubbleSortTest {

    public static void main(String[] args) {

        Integer[] numbers = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        System.out.println("Original Integer Array");
        printArray(numbers);

        bubbleSort(numbers);

        System.out.println("\nSorted Using Comparable");
        printArray(numbers);


        String[] names = {
            "Oakley",
            "Brady",
            "Molly",
            "Collyn",
            "Lilo"
        };

        System.out.println("\nOriginal String Array");
        printArray(names);

        bubbleSort(names, Comparator.naturalOrder());

        System.out.println("\nSorted Using Comparator");
        printArray(names);


        System.out.println("\nTesting");

        if (isSorted(numbers)) {
            System.out.println("Comparable Test Passed");
        } else {
            System.out.println("Comparable Test Failed");
        }

        if (isSorted(names, Comparator.naturalOrder())) {
            System.out.println("Comparator Test Passed");
        } else {
            System.out.println("Comparator Test Failed");
        }

    }


    public static <E extends Comparable<E>> void bubbleSort(E[] list) {

        E temp;

        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 0; j < list.length - 1; j++) {

                if (list[j].compareTo(list[j + 1]) > 0) {

                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                }

            }

        }

    }

    public static <E> void bubbleSort(E[] list,
            Comparator<? super E> comparator) {

        E temp;

        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 0; j < list.length - 1; j++) {

                if (comparator.compare(list[j], list[j + 1]) > 0) {

                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                }

            }

        }

    }


    public static <E> void printArray(E[] list) {

        System.out.print("{ ");

        for (E value : list) {

            System.out.print(value + " ");

        }

        System.out.println("}");

    }

    public static <E extends Comparable<E>> boolean isSorted(E[] list) {

        for (int i = 0; i < list.length - 1; i++) {

            if (list[i].compareTo(list[i + 1]) > 0) {

                return false;

            }

        }

        return true;

    }

    public static <E> boolean isSorted(E[] list,
            Comparator<? super E> comparator) {

        for (int i = 0; i < list.length - 1; i++) {

            if (comparator.compare(list[i], list[i + 1]) > 0) {

                return false;

            }

        }

        return true;

    }

}