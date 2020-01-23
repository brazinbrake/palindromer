import java.util.*;

//A class to process and store palindromes. Note: when getting user input
// from the provided Main, the String constructor will always be called
public class Palindrome {
    String value;
    boolean isPalindrome;

    public Palindrome(String word)
    {
        this.value = word;
        this.isPalindrome = isPalindromeWord(word);
    }

    public Palindrome(int number)
    {
        this.value = Integer.toString(number);
        this.isPalindrome = isPalindromeNumber(number);
    }

    //Checks if word meets palindrome criteria
    private boolean isPalindromeWord(String word) {
        //ensure all same case (palindromes are non-case sensitive)
        word = word.toUpperCase();
        //get length
        int length = word.length();
        //check if even
        boolean even = isEven(word);
        //convert String to array characters
        char[] ch = convertString(word);

        if (even)
        {
            return processEven(ch);
        }
        else
        {
            return processOdd(ch);
        }
    }

    //Checks if number meets palindrome criteria
    private static boolean isPalindromeNumber(int number)
    {
        //convert to String
        String cNumber = Integer.toString(number);
        //get length
        int length = cNumber.length();
        //check if even
        boolean even = isEven(cNumber);
        //convert String to array characters
        char[] ch = convertString(cNumber);

        if (even)
        {
            return processEven(ch);
        }
        else
        {
            return processOdd(ch);
        }
    }

    //Converts string to char array for ease of processing
    private static char[] convertString(String s)
    {
        int length = s.length();
        char[] ch = new char[length];
        for (int i = 0; i < length; i++)
        {
            ch[i] = s.charAt(i);
        }
        return ch;
    }

    //Checks if the input is even (rrn true) or odd (rtn false)
    private static boolean isEven(String s)
    {
        return (s.length() % 2 == 0);
    }

    //Process an even pre-converted input
    private static boolean processEven(char[] ch)
    {
        //get first half
        char[] firstHalf = new char[ch.length / 2];
        for (int i = 0; i < ch.length / 2; i++)
        {
            firstHalf[i] = ch[i];
        }
        //get second half (picking up where first half left off)
        char[] secondHalf = new char[ch.length / 2];
        for (int i = ch.length / 2; i < ch.length; i++)
        {
            secondHalf[i-(ch.length/2)] = ch[i];
        }
        //reverse the second array;
        secondHalf = reverseArray(secondHalf);
        //compare the two
        return (Arrays.equals(firstHalf, secondHalf));
    }

    //Process an odd pre-converted input
    private static boolean processOdd(char[] ch)
    {
        //get first half
        char[] firstHalf = new char[ch.length / 2];
        for (int i = 0; i < ch.length / 2; i++)
        {
            firstHalf[i] = ch[i];
        }
        //get second half by reverse traversing the array
        char[] secondHalf = new char[ch.length / 2];
        for (int i = ch.length-1; i > ch.length / 2; i--)
        {
            secondHalf[ch.length - i - 1] = ch[i];
        }
        //compare the two
        return (Arrays.equals(firstHalf, secondHalf));
    }

    //Reverse array in case of even processing style
    private static char[] reverseArray(char[] ch) {
        //inline swap reversal
        for (int i = 0; i < ch.length / 2; i ++)
        {
            char temp = ch[i];
            ch[i] = ch[ch.length - i - 1];
            ch[ch.length - i - 1] = temp;
        }
        return ch;
    }

    public String toString()
    {
        if (this.isPalindrome)
        {
            return this.value + " is a palindrome!";
        }
        else
        {
            return this.value + " is not a palindrome :(";
        }
    }
}
