/*
 * Brady Heinz 4.2 Assignment 6/21/26
 *
 * Results explanation:
 * For 50,000 integers, the Iterator traversal took about 4 milliseconds,
 * while the get(index) traversal took about 719 milliseconds.
 *
 * For 500,000 integers, the Iterator traversal took about 61 milliseconds,
 * while the get(index) traversal took about 150,039 milliseconds
 * (about 150 seconds).
 *
 * The Iterator is much faster because it moves directly from node to node in
 * the LinkedList. The get(index) method must repeatedly search through the
 * list to find each position. As the number of elements increased from
 * 50,000 to 500,000, the Iterator time increased only slightly, while the
 * get(index) time increased dramatically, showing that get(index) is a very
 * inefficient way to traverse a LinkedList.
 */
package heinz_mod4;

import java.util.Iterator;
import java.util.LinkedList;

public class Heinz_mod4 {

    public static void main(String[] args) {
        final int smallTestSize = 50_000;
        final int largeTestSize = 500_000;

        System.out.println("LinkedList traversal timing test");
        System.out.println("--------------------------------");

        runTest(smallTestSize);
        System.out.println();
        runTest(largeTestSize);
    }

    private static void runTest(int size) {
        LinkedList<Integer> numbers = buildLinkedList(size);

        testListContents(numbers, size);

        long iteratorStart = System.nanoTime();
        long iteratorSum = traverseWithIterator(numbers);
        long iteratorEnd = System.nanoTime();

        long getStart = System.nanoTime();
        long getSum = traverseWithGetMethod(numbers);
        long getEnd = System.nanoTime();

        if (iteratorSum != getSum) {
            throw new IllegalStateException("Traversal test failed: sums do not match.");
        }

        double iteratorMilliseconds = (iteratorEnd - iteratorStart) / 1_000_000.0;
        double getMilliseconds = (getEnd - getStart) / 1_000_000.0;

        System.out.println("Number of integers: " + size);
        System.out.printf("Iterator traversal time: %.3f milliseconds%n", iteratorMilliseconds);
        System.out.printf("get(index) traversal time: %.3f milliseconds%n", getMilliseconds);
        System.out.println("Iterator sum: " + iteratorSum);
        System.out.println("get(index) sum: " + getSum);
        System.out.println("Test result: PASS");
    }

    private static LinkedList<Integer> buildLinkedList(int size) {
        LinkedList<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        return numbers;
    }

    private static long traverseWithIterator(LinkedList<Integer> numbers) {
        long sum = 0;
        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        return sum;
    }

    private static long traverseWithGetMethod(LinkedList<Integer> numbers) {
        long sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        return sum;
    }

    private static void testListContents(LinkedList<Integer> numbers, int expectedSize) {
        if (numbers.size() != expectedSize) {
            throw new IllegalStateException("List size test failed.");
        }

        if (!numbers.getFirst().equals(0)) {
            throw new IllegalStateException("First value test failed.");
        }

        if (!numbers.getLast().equals(expectedSize - 1)) {
            throw new IllegalStateException("Last value test failed.");
        }
    }
}