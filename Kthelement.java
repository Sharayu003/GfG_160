class Kthelement {
    static int kthElement(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;

        int i = 0, j = 0; // Pointers for `a` and `b`

        while (k > 0) {
            // If one array is exhausted
            if (i >= n) return b[j + k - 1]; // Remaining k-th element in `b`
            if (j >= m) return a[i + k - 1]; // Remaining k-th element in `a`

            // If k == 1, we just need the smaller of the two current elements
            if (k == 1) return Math.min(a[i], b[j]);

            // Move k/2 steps in the array that's still valid
            int half = k / 2;

            int newI = Math.min(i + half, n) - 1; // Ensure not to go out of bounds
            int newJ = Math.min(j + half, m) - 1;

            // Compare and discard elements from the array with the smaller value
            if (a[newI] <= b[newJ]) {
                k -= (newI - i + 1); // Reduce k by the number of elements discarded
                i = newI + 1;
            } else {
                k -= (newJ - j + 1);
                j = newJ + 1;
            }
        }

        return -1; // This point is never reached
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;

        System.out.println(kthElement(a, b, k)); // Output: 6
    }
}

