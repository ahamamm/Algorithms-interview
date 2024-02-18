package book.ds.interview.ch1.bit.manipulation;

//# Check whether a given number n is a power of 2 or 0

public class NumberPowofTwo {
    // Function to check if a given number is a power of 2
    public static int checkPow2(int num) {
        // If the number is 0, return 0
        if (num == 0) {
            return 0;
        }
        // If the number is a power of 2, return 1
        if ((num & (num - 1)) == 0) {
            return 1;
        }
        // Otherwise, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Call the checkPow2 function with an input of 16
        int caseNum = checkPow2(16);
        // Use a switch statement to print the appropriate message based on the return value of the function
        switch (caseNum) {
            case 0:
                System.out.println("Number is 0");
                break;
            case 1:
                System.out.println("Number is a power of 2");
                break;
            case -1:
                System.out.println("Number is neither a power of 2 nor 0");
                break;
        }
    }
}