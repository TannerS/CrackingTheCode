package Strings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Check if a string has unique chars using a data structure and without one
 * 1.1
 *
 *
 *
 */

public class UniqueStrings {

    private static final int ALPHA_COUNT = 26;

    public static void main(String[] args) {
        String testCase1 = "This is a example string";
        String testCase2 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("WTIH DB STR 1: " + withDataStructure(testCase1));
        System.out.println("WTIH DB STR 2: " + withDataStructure(testCase2));
        System.out.println("WTIHOUT DB STR 1: " + withoutDataStructure(testCase1));
        System.out.println("WTIHOUT DB STR 2: " + withoutDataStructure(testCase2));
    }


    public static boolean withDataStructure(String input)
    {
        char chars[] = input.toLowerCase().toCharArray();
        HashSet<Character> structure = new HashSet<Character>();

        for(Character x : chars)
        {
            if(structure.contains(x))
                return false;
            else
                structure.add(x);
        }

        return true;
    }

    public static boolean withoutDataStructure(String input)
    {
        char chars[] = input.toLowerCase().toCharArray();
        boolean charBool[] = new boolean[ALPHA_COUNT];

        for(Character x : chars)
        {
            if(!Character.isWhitespace(x))
            {
                int offset = x - 97;

                if(charBool[offset])
                    return false;
                else
                    charBool[offset] = true;
            }
        }

        return true;
    }
}


