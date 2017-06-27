package io.tanners;

/**
 *
 * 1.4
 *
 *
 */
public class PalindromePermutationStrings {

    private static final int ALPHA_COUNT = 26;

    public static void main(String[] args) {




        System.out.println(permutationPalindromeCheckerMethodOne("Tact Coa"));
        System.out.println(permutationPalindromeCheckerMethodOne("yeeuyuss"));
        System.out.println(permutationPalindromeCheckerMethodOne("yeeuyussa"));
        System.out.println(permutationPalindromeCheckerMethodOne("acebdf"));
        System.out.println(permutationPalindromeCheckerMethodOne("aabbccddeeff"));
        System.out.println(permutationPalindromeCheckerMethodOne("aabbccddeeffzy"));
        System.out.println(permutationPalindromeCheckerMethodOne("aabbccddeeffz"));
        System.out.println();



        System.out.println(permutationPalindromeCheckerMethodTwo("Tact Coa"));
        System.out.println(permutationPalindromeCheckerMethodTwo("yeeuyuss"));
        System.out.println(permutationPalindromeCheckerMethodTwo("yeeuyussa"));
        System.out.println(permutationPalindromeCheckerMethodTwo("acebdf"));
        System.out.println(permutationPalindromeCheckerMethodTwo("aabbccddeeff"));
        System.out.println(permutationPalindromeCheckerMethodTwo("aabbccddeeffzy"));
        System.out.println(permutationPalindromeCheckerMethodTwo("aabbccddeeffz"));
//




        /*
        lets assume we present 26 into bits (we got 32 bits but humor me)

[00000000000000000000000000] [00000000]

so lets say the 14th letter of the alphabet is incremented. then we flip the bit

[00000000000001000000000000] [00000000]

so to do this, we see we may have to first figure out if its big endian or little endian, in this case is it big
        z                         a
[0000000000000000000000000000000000]

lets do an example first we get 1 and OR it with a value and shift it by the alpha index

int offset = 1;
int result = offset << 14;

00000000000000000000100000000000000

at this point, we or with out current flag set

flags = 0;

flags = flags | result
^
flags: [00000000000000000000100000000000000]

now lets say we have the second leter in the alphabet

flags: [00000000000000000000100000000000010]

but how do we handle when the same letter comes up again? we want to flip that single bit? we do same process, but use XOR

so here is full example

        int offset = 1;
        int flags = 0;
        int result = offset << 14;

        flags = flags ^ result;

        // 0100000000000000
        System.out.println(flags);

        result = offset << 2;
        flags = flags ^ result;

        // 16388
        System.out.println(flags);


        result = offset << 2;
        flags = flags ^ result;

        // 16384
        System.out.println(flags);


in the end, if the word is even amount of number, the end reuslt sohuld be 0, what aobut odd numbers?

this would mean we go to Google, since I was not sure about this one

https://stackoverflow.com/questions/3160659/innovative-way-for-checking-if-number-has-only-one-on-bit-in-signed-int

one solution does not take account of x ==0 which for the for the len % 2 ==0 should not ever happen ( need to research more)

         */

    }
//
    public static boolean permutationPalindromeCheckerMethodOne(String input)
    {
        int wordCount = input.replace(" ", "").length();
        boolean[] chars = new boolean[ALPHA_COUNT];

        /*
            words can be even which means there must be two letters per char
         */
        if(wordCount % 2 == 0)
        {
            for(Character x : input.toLowerCase().toCharArray())
            {
                if(!Character.isWhitespace(x))
                {
                    int offset = x - 97;
                    chars[offset] = !chars[offset];
                }
            }

            for(int i = 0; i < chars.length; i++)
            {
                if(chars[i]) {
                    return false;
                }
            }

            return true;
        }
        /*
            there is atleast one char that is the only one here
         */
        else
        {
            for(Character x : input.toLowerCase().toCharArray())
            {
                if(!Character.isWhitespace(x)) {
                    int offset = x - 97;
                    chars[offset] = !chars[offset];
                }
            }

            boolean breaker = false;

            for(int i = 0; i < chars.length; i++)
            {
                // first time it hits a 1 bit, change breaker, second time it find ones, its not permutation, return false, else only one flipped bit, so return true
                if(chars[i])
                {
                    if(breaker)
                        return false;
                    else
                        breaker = true;
                }
            }

            return true;

        }
    }

    public static boolean permutationPalindromeCheckerMethodTwo(String input)
    {
        int wordCount = input.replace(" ", "").length();
        boolean[] chars = new boolean[ALPHA_COUNT];

        /*
            words can be even which means there must be two letters per char
         */
        if(wordCount % 2 == 0)
        {
            int bitOffset = 1;
            int flags = 0;

            for(Character x : input.toLowerCase().toCharArray())
            {
                if(!Character.isWhitespace(x)) {
                    int offset = x - 97;
                    int result = bitOffset << offset;
                    flags = flags ^ result;
                }
            }

            if(flags == 0)
                return true;
            else
                return false;

        }
        /*
            there is atleast one char that is the only one here
         */
        else
        {
            int bitOffset = 1;
            int flags = 0;

            for(Character x : input.toLowerCase().toCharArray())
            {
                if(!Character.isWhitespace(x)) {
                    int offset = x - 97;
                    int result = bitOffset << offset;
                    flags = flags ^ result;
                }
            }

            // https://stackoverflow.com/questions/3160659/innovative-way-for-checking-if-number-has-only-one-on-bit-in-signed-int
            return (flags & flags - 1) == 0;

        }
    }
}
