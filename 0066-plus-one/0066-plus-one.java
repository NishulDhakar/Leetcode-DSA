class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;

        // Traverse the array from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  // Increment the current digit
                return digits; // Return the result if no carry is generated
            }
            digits[i] = 0; // If digit is 9, set it to 0 and continue
        }

        // If all digits were 9, create a new array with an extra leading 1
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result1 = sol.plusOne(new int[]{1, 2, 3}); // Output: [1, 2, 4]
        int[] result2 = sol.plusOne(new int[]{9, 9, 9}); // Output: [1, 0, 0, 0]

        // Print results
        printArray(result1);
        printArray(result2);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

        
