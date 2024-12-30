public class PeakElementFinder {

    // Function to find a peak element index using Binary Search
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            // If left neighbor is greater, move to the left half
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else { // Otherwise, move to the right half
                left = mid + 1;
            }
        }

        return -1; // Should never reach here for valid input
    }

    // Function to validate if the returned index is a peak
    public static boolean testPeak(int[] arr, int index) {
        int n = arr.length;

        // Check boundary conditions for valid index
        if (index < 0 || index >= n) {
            return false;
        }

        // Check peak condition
        boolean leftCondition = (index == 0 || arr[index] > arr[index - 1]);
        boolean rightCondition = (index == n - 1 || arr[index] > arr[index + 1]);

        return leftCondition && rightCondition;
    }

    public static void main(String[] args) {
        // Example test case
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElement(arr);

        System.out.println("Index of peak: " + peakIndex);
        System.out.println("Output is: " + testPeak(arr, peakIndex));
    }
}
