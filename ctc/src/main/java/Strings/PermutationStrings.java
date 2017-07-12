package Strings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * See if a string is a permutation of the other
 * 1.2
 *
 *
 */
public class PermutationStrings
{
    public static void main(String[] args) {
        String testCase1 = "tac";
        String testCase2 = "cat";

        String testCase3 = "dog";
        String testCase4 = "god";

        String testCase5 = "tic";
        String testCase6 = "tac";

        String testCase7 = "dogg";
        String testCase8 = "god";




        System.out.println("TAC?CAT: " + func1("tac", "cat"));
        System.out.println("DOG?GOD: " + func1("dog", "god"));
        System.out.println("TIC?TAC: " + func1("tic", "tac"));
        System.out.println("DOGG?GOD: " + func1("dogg", "god"));
        System.out.println();
        System.out.println("TAC?CAT: " + func2("tac", "cat"));
        System.out.println("DOG?GOD: " + func2("dog", "god"));
        System.out.println("TIC?TAC: " + func2("tic", "tac"));
        System.out.println("DOGG?GOD: " + func2("dogg", "god"));

    }

    public static boolean func1(String input1, String input2)
    {
        if(input1.length() != input2.length())
            return false;
        else
        {
            if(getStrCharCount(input1).equals(getStrCharCount(input2)))
                return true;
            else
                return false;
        }
    }

    public static HashMap<Character, Integer> getStrCharCount(String input)
    {
        char[] chars = input.toCharArray();
        HashMap<Character, Integer> counts = new HashMap<>();


        for(Character x : chars)
        {
            if(counts.containsKey(x))
                counts.put(x, counts.get(x) + 1);
            else
                counts.put(x, 0);
        }

        return counts;
    }

    public static boolean func2(String input1, String input2)
    {
        if(input1.length() != input2.length())
            return false;
        else
        {
            char[] input1Chars = input1.toCharArray();
            char[] input2Chars = input2.toCharArray();

            Arrays.sort(input1Chars);
            Arrays.sort(input2Chars);

            if(Arrays.equals(input1Chars, input2Chars))
                return true;
            else
                return false;

        }
    }
}
