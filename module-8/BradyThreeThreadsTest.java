/*
 * Brady Heinz 7/12/26 Module 8.2 Assignment Test
 */

package mod_8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BradyThreeThreadsTest {

    @Test
    public void testRandomLetterMethod() {

        for (int i = 0; i < 10000; i++) {
            char character =
                    BradyThreeThreads.generateRandomLetter();

            assertTrue(
                    character >= 'a' && character <= 'z',
                    "Character should be a lowercase letter.");
        }
    }

    @Test
    public void testRandomDigitMethod() {

        for (int i = 0; i < 10000; i++) {
            char character =
                    BradyThreeThreads.generateRandomDigit();

            assertTrue(
                    character >= '0' && character <= '9',
                    "Character should be a number digit.");
        }
    }

    @Test
    public void testRandomSpecialCharacterMethod() {

        for (int i = 0; i < 10000; i++) {
            char character =
                    BradyThreeThreads
                            .generateRandomSpecialCharacter();

            assertTrue(
                    BradyThreeThreads.SPECIAL_CHARACTERS
                            .indexOf(character) >= 0,
                    "Character should be a valid special character.");
        }
    }

    @Test
    public void testRequiredCharacterCount() {

        assertTrue(
                BradyThreeThreads.CHARACTER_COUNT >= 10000,
                "Each thread must generate at least 10,000 characters.");
    }
}