package Strings;

/**
 * Created by tanners on 6/26/17.
 * 1.5
 */
public class OneAwayStrings {

    public static void main(String[] args) {
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pales","pale"));
        System.out.println(oneAway("pale","bale"));
        System.out.println(oneAway("pale", "bake"));
    }

    public static boolean oneAway(String input1, String input2)
    {

        if(input1.length() > input2.length())
        {
            if(strDifference(input1, input2))
                return true;
            else
                return false;
        }
        else if(input2.length() > input1.length())
        {
            if(strDifference(input2, input1))
                return true;
            else
                return false;
        }
        else if(input1.length() == input2.length())
        {
            if(strDifference2(input1, input2))
                return true;
            else
                return false;
        }
        else
        {
            // nothing should go here
            return false;
        }

    }

    private static boolean strDifference(String input1, String input2)
    {
        boolean checker = true;

        for(int i = 0, j = 0; i < input2.length(); i++, j++)
        {

            if(input1.charAt(j) != input2.charAt(i))
            {
                if(!checker)
                    return false;
                else {
                    i--;
                    checker = false;
                }
            }
        }
        return true;
    }

    private static boolean strDifference2(String input1, String input2)
    {
        boolean checker = true;

        for(int i = 0; i < input1.length(); i++)
        {
            if(input1.charAt(i) != input2.charAt(i))
            {
                if(!checker)
                    return false;
                else {
                    checker = false;
                }
            }
        }
        return true;
    }
}
