package book.ds.interview.ch1.bit.manipulation;

//# Find the next greater and next smaller number with same number of set bits

public class NextGreaterAndSmaller {
	
    public static int nextGreater(int num) {
        int res = num;
        if (num != 0) {
            // Find the rightmost set bit
            int rightOne = num & -num;

            // Get the left pattern to merge
            int leftPattern = num + rightOne;

            // Get the right pattern to merge
            int rightPattern = (num ^ leftPattern) >> (rightOne + 1);

            // OR both the patterns
            res = leftPattern | rightPattern;
        }
        return res;
    }

    public static int nextSmaller(int num) {
        return ~nextGreater(~num);
    }

    public static void main(String[] args) {
        System.out.println(nextGreater(6));
        System.out.println(nextSmaller(6));
    }
}