

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Locale;

/**
 * PalindromeTest : a test class for isPalindrome, a method intended to utilize stacks to evaluate if a given
 * string is a palindrome.
 *
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards as it does
 * forwards. Such sequences include "madam," "top spot," or "no lemon, no melon".
 */
public class PalindromeTest<E> extends ArrayListStack<E>{

    /** True test cases which include spaces and symbols */
    private static final String[] SIMPLE_TRUE = { "", " ", "A", "7", "%", "  ", "BB", "33", "**" };
    /** False test cases which include spaces and symbols */
    private static final String[] SIMPLE_FALSE = { "AC", "71", "@+" };

    /** True test cases which include spaces */
    private static final String[] WHITE_SPACE_TRUE = { " x ", " t   t  ", " 5 5", " #      # " };
    /** False test cases which include spaces */
    private static final String[] WHITE_SPACE_FALSE = { "m   n  ", "   8  7 ", "  ^      &  "};

    /** Case-sensitive palindromes */
    private static final String[] CASE_SENSITIVE_TRUE = { "ABba", "roTOR", "rAceCaR" };

    /** Complex palindromes which include spaces, symbols, and varied capitalization */
    private static final String[] COMPLEX_TRUE = { "fOO race CAR oof", "AbBa ZaBba", "1 3 3 7  331",
            "N0 LEm0n, n0 Mel0n",
            "sT RJKLEeE R#@ $A$ @# REeEL K  JRT s" };

    /**
     * Utilizes stacks to determine if the given string is a palindrome. This method ignores whitespace and case
     * sensitivity, but does not ignore digits or symbols.
     *
     * @param palindrome a string
     * @return returns true if a palindrome, false otherwise
     */
    private boolean isPalindrome(String palindrome) {
        // TODO:
        // Implement this method body using your ArrayListStack. Be mindful of your algorithm!
        int index = 0;
        ArrayListStack<Character> charStack = new ArrayListStack<>();
        if (palindrome == null) { //if string null, throw exception
            throw new IllegalArgumentException();
        }

        char[] characters = palindrome.replaceAll(" ", "").toUpperCase().toCharArray(); //replaces all blank spaces & sets all letters to uppercase for consistency

        for (index = 0; index < characters.length/2 ; index++) { //split characters down the middle & push one half to charStack
            charStack.push(characters[index]);
        }
        if(characters.length % 2 == 1) { //if length has a remainder of one, increment index
            index++;
        }

        while(!charStack.empty()) { //while stack not empty,
            if(charStack.pop() == characters[index++]) { //pop each character in stack, if equivalent to character in characters list at index, return true
                return true;
            }
            return false; //will return false in the case that the character at that index does not match with what is popped from charStack
        }
        return true;
    }



    @Test
    public void testErrors() {
        try {
            isPalindrome(null);
            fail("Checking null to see if it's a palindrome should throw IllegalArgumentException!");
        } catch (IllegalArgumentException iae) { /* Test Passed! */ }
    }

    @Test
    public void testSimpleTrueCases() {
        for (int i = 0; i < SIMPLE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(SIMPLE_TRUE[i]));
        }
    }

    @Test
    public void testSimpleFalseCases() {
        for (int i = 0; i < SIMPLE_FALSE.length; i ++) {
            assertFalse((i + " This test is NOT a palindrome"), isPalindrome(SIMPLE_FALSE[i]));
        }
    }

    @Test
    public void testWhitespaceTrueCases() {
        for (int i = 0; i < WHITE_SPACE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(WHITE_SPACE_TRUE[i]));
        }
    }

    @Test
    public void testWhitespaceFalseCases() {
        for (int i = 0; i < WHITE_SPACE_FALSE.length; i ++) {
            assertFalse((i + " This test is NOT a palindrome"), isPalindrome(WHITE_SPACE_FALSE[i]));
        }
    }

    @Test
    public void testCaseSensitivityCases() {
        for (int i = 0; i < CASE_SENSITIVE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(CASE_SENSITIVE_TRUE[i]));
        }
    }

    @Test
    public void testComplexCases() {
        for (int i = 0; i < COMPLEX_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(COMPLEX_TRUE[i]));
        }
    }

} // End of class PalindromeTest