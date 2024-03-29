package book.ds.interview.ch2.dynamic.programig;
/*
Given weights and values of n items, put these items in a knapsack of capacity W to get
the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1]
and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or donâ€TMt pick it (0-1 property).
*/
public class Knapsack {
	public static void main(String[] args) {
		int[] price = { 60, 100, 120 };
		int[] wt = { 1, 2, 3 };
		int W = 5;
		int n = price.length;
		int[][] k = knapSack(W, wt, price, n);
		System.out.println(k[n][W]);
	}

	// Function to solve the 0-1 Knapsack problem
	public static int[][] knapSack(int W, int[] wt, int[] val, int size) {
		// Initialize a 2D array to store the maximum value that can be attained with
		// weight less than or equal to w using items up to index i
		int[][] k = new int[size + 1][W + 1];

		// Iterate over all items and weights
		for (int i = 0; i <= size; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0) {
					// Base case: no items or no weight
					k[i][w] = 0;
				} else if (wt[i - 1] <= w) {
					// If the weight of the current item is less than or equal to the current
					// weight,
					// choose the maximum value between including the current item or not including
					// it
					k[i][w] = Math.max(val[i - 1] + k[i - 1][w - wt[i - 1]], k[i - 1][w]);
				} else {
					// If the weight of the current item is greater than the current weight,
					// do not include it in the knapsack
					k[i][w] = k[i - 1][w];
				}
			}
		}

		return k;
	}
}