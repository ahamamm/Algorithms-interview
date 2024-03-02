package book.ds.interview.ch2.dynamic.programig;
/*
Minimum number of edits (operations) required to convert ‘str1’ into ‘str2’
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
Insert
Remove
Replace
All of the above operations are of equal cost.
*/
public class EditDistance {
    // Function to calculate the minimum edit distance between two strings
    public static int editDistance(String str1, String str2, int m, int n) {
        // Create a matrix to store the edit distances between substrings of str1 and str2
        int[][] matrix = new int[m + 1][n + 1];

        // Fill the matrix using dynamic programming
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If one of the strings is empty, the edit distance is the length of the other string
                if (i == 0) {
                    matrix[i][j] = j;
                } else if (j == 0) {
                    matrix[i][j] = i;
                }
                // If the characters at the current positions are the same, no operation needed
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                }
                // Otherwise, find the minimum of insert, remove, or replace operations
                else {
                    matrix[i][j] = 1 + Math.min(Math.min(matrix[i][j - 1], // Insert
                                    matrix[i - 1][j]), // Remove
                            matrix[i - 1][j - 1]); // Replace
                }
            }
        }
        // Return the edit distance between the two strings
        return matrix[m][n];
    }

    public static void main(String[] args) {
        // Input strings
        String str1 = "sunday";
        String str2 = "saturdays";

        // Calculate and print the minimum edit distance between the strings
        System.out.println("Minimum Edit Distance: " + editDistance(str1, str2, str1.length(), str2.length()));
    }
}