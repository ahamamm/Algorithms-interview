package book.ds.interview.ch1.bit.manipulation;


///# Find the two non-repeating elements in an array of repeating elements
/*
 * This Java code defines a class NonRepeatingNumbers with a static method findNonRepeatingNumbers that takes an input array of .
 * integers and returns an array of two non-repeating numbers.
 * The method uses the XOR bitwise operator to find the two non-repeating numbers. 
 * The code also includes a main method that demonstrates how to use the findNonRepeatingNumbers method with an array
 *  of integers arr = {2, 3, 7, 9, 11, 2, 3, 11}. When the method is called with this array as an argument, it returns the two 
 *  non-repeating numbers (7, 9).
 *  */
public class NonRepeatingNumbers {

    public static int[] findNonRepeatingNumbers(int[] arr) {
        // Initialize xor with the first element of the array
        int xor = arr[0];
        // Compute the xor of all elements in the array
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }
        // Find the rightmost set bit in xor
        int rightSetBit = xor & ~(xor - 1);
        // Initialize first and second with 0
        int first = 0;
        int second = 0;
        // Divide the elements in two sets and compute their xor
        for (int i : arr) {
            if ((i & rightSetBit) != 0) {
                first ^= i;
            } else {
                second ^= i;
            }
        }
        // Return the two non-repeating numbers
        return new int[]{first, second};
    }

    public static void main(String[] args) {
        // Example array of integers
        int[] arr = {2, 3, 7, 9, 11, 2, 3, 11};
        // Call the findNonRepeatingNumbers method with the example array
        int[] result = findNonRepeatingNumbers(arr);
        // Print the result
        System.out.println(result[0] + ", " + result[1]);
    }
}