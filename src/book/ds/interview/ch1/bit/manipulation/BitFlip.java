package book.ds.interview.ch1.bit.manipulation;

///# Count number of bits needed to be flipped to convert A to B

public class BitFlip {
	
    public static int countBitsFlip(int a, int b) {
        // XOR a and b to get 1 on opposite value bit position
        int c = a ^ b;

        // initialize the counter for 1
        int count = 0;

        // count the number of 1s while there is 1 in a ^ b
        while (c != 0) {
            count++;
            c &= (c - 1);
        }

        // return the count of 1s
        return count;
    }

    public static void main(String[] args) {
        // 2 = 0010
        // 8 = 1000
        System.out.println(countBitsFlip(2, 8));
    }
}