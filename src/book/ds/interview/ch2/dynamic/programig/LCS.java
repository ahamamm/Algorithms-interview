package book.ds.interview.ch2.dynamic.programig;
import java.util.Arrays;
/*
Given two sequences, print the longest subsequence present in both of them.
Find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
*/
public class LCS {
    public static String lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] matrix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        int index = matrix[m][n];
        String[] res = new String[index];
        Arrays.fill(res, "");

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res[index - 1] = Character.toString(str1.charAt(i - 1));
                i--;
                j--;
                index--;
            } else if (matrix[i - 1][j] > matrix[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return String.join("", res);
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        String str = lcs(X, Y);
        System.out.println("Length of longest common subsequence is: " + str.length() + "\nAnd the subsequence is: " + str);
    }
}