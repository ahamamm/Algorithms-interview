package book.ds.interview.ch2.dynamic.programig;

public class EditDistance {
	public static int editDistance(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		// Create a matrix to store the edit distances
		int[][] matrix = new int[m + 1][n + 1];

		// Fill in the matrix
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// If first string is empty, insert all characters of second string
				if (i == 0) {
					matrix[i][j] = j;
				}
				// If second string is empty, remove all characters of first string
				else if (j == 0) {
					matrix[i][j] = i;
				}
				// If last characters are same, ignore last character and recur for remaining
				// string
				else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1];
				}
				// If last character are different, consider all possibilities and find minimum
				else {
					matrix[i][j] = 1 + Math.min(matrix[i][j - 1], // Insert
							Math.min(matrix[i - 1][j], // Remove
									matrix[i - 1][j - 1])); // Replace
				}
			}
		}

		return matrix[m][n];
	}

	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";
		System.out.println(editDistance(str1, str2));
	}
}