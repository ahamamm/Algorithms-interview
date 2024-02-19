package book.ds.interview.ch2.dynamic.programig;

public class LargestSquareFinder {
    public static void main(String[] args) {
        // Input matrix
        int[][] mat = {{1, 1, 0, 1, 0}, {0, 1, 1, 1, 0}, {1, 1, 1, 1, 0}, {0, 1, 1, 1, 1}};
        // Call the function to find the largest square
        int[] result = findLargestSquare(mat);
        int size = result[0];
        int bottom = result[1];
        int right = result[2];

        // Output the result
        if (size > 0) {
            System.out.println("Size of the square: " + size);
            System.out.println("Top-left Co-ordinates: " + (bottom - size + 1) + ", " + (right - size + 1));
            System.out.println("Bottom-right Co-ordinates: " + bottom + ", " + right);
        } else {
            System.out.println("No square of 1s found");
        }
    }

    // Function to find the largest square of 1s
    public static int[] findLargestSquare(int[][] matrix) {
        // Get the size of the matrix
        int n = matrix.length;
        // Matrix to store the solutions
        int[][] cache = new int[n][n];
        // Initialize variables for the size of the square and its bottom-right indexes
        int size = 0;
        int rightIndex = -1;
        int bottomIndex = -1;

        // Loop through the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // If the value is 0, move to the next iteration as it cannot form a square of 1s
                if (matrix[i][j] == 0) {
                    continue;
                } else if (i == 0 || j == 0) {
                    // If it's the first row or column, copy the matrix values as they are
                    cache[i][j] = matrix[i][j];
                } else {
                    // Otherwise, check the up, left, and diagonally top-left direction for the minimum size of square
                    // If all are 1s at these positions in the matrix, only then the minimum value will be greater than 1
                    // Hence, add the previous square size to the cache + 1
                    cache[i][j] = 1 + Math.min(Math.min(cache[i - 1][j], cache[i][j - 1]), cache[i - 1][j - 1]);
                }

                // Check if the current square size found is larger than the previously found size, if so, update it
                if (cache[i][j] > size) {
                    size = cache[i][j];
                    bottomIndex = i;
                    rightIndex = j;
                }
            }
        }
        // Return the size of the largest square and its bottom-right indexes
        return new int[]{size, bottomIndex, rightIndex};
    }
}