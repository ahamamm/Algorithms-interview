package book.ds.interview.ch2.dynamic.programig;
/*
    Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
    Determine the maximum value obtainable by cutting up the rod and selling the pieces.
*/
public class CuttingRod {
    // Function to find the maximum obtainable value
    // from a rod of length n with given prices
    public static int cuttingRod(int[] prices, int n) {
        // Create an array to store the maximum obtainable value for rods of different lengths
        int[] dp = new int[n + 1];

        // Base case: if the length of the rod is 0, the maximum obtainable value is 0
        dp[0] = 0;

        // Iterate through all possible lengths of the rod
        for (int i = 1; i <= n; i++) {
            // Initialize max_val to a very small value
            int max_val = Integer.MIN_VALUE;

            // Iterate through all possible cuts of the rod
            for (int j = 0; j < i; j++) {
                // Update max_val with the maximum obtainable value
                // considering all possible cuts
                max_val = Math.max(max_val, prices[j] + dp[i - j - 1]);
            }

            // Store the maximum obtainable value for the current length of the rod
            dp[i] = max_val;
        }

        // Return the maximum obtainable value for the rod of length n
        return dp[n];
    }

    public static void main(String[] args) {
        // Prices of different lengths of the rod
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};

        // Length of the rod
        int size = arr.length;

        // Find and print the maximum obtainable value
        System.out.println("Maximum Obtainable Value is " + cuttingRod(arr, size));
    }
}