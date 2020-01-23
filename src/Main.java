import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //input primer
        System.out.print("Enter a letter or number to evaluate or type '-1' to leave: ");
        String palToEval  = input.nextLine();
        //evaluate exit cond.
        while (!(palToEval.equals("-1"))) {
            {
                try {
                    //if too short to eval
                    if ((palToEval.length() == 0) || (palToEval.length() == 1)) {
                        System.out.println("Too Short to Evaluate. Please try again");
                    }
                    //else process it
                    else {
                        Palindrome p = new Palindrome(palToEval);
                        System.out.println(p);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                //get input before next while evaluation
                System.out.print("Enter a letter or number to evaluate or type '-1' to leave: ");
                palToEval  = input.nextLine();
            }
        }
    }
}
           //SOME TEST DATA
//        int palNum = 112242211;
//        Palindrome pn = new Palindrome(palNum);
//        //expect true
//        System.out.println(pn);
//
//        int nonPalNum = 54321;
//        Palindrome nn = new Palindrome(nonPalNum);
//        //expect false
//        System.out.println(nn);
//
//        String palWord = "Racecar";
//        Palindrome pw = new Palindrome(palWord);
//        System.out.println(pw);
//
//        String nonPalWord = "Palindrome";
//        Palindrome nw = new Palindrome(nonPalWord);
//        System.out.println(nw);
