class searchInrotatedarray {

    static int searchInRotatedArray(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the key is at the mid index
            if (arr[mid] == key) {
                return mid;
            }

            // Check if the left half is sorted
            if (arr[left] <= arr[mid]) {
                // If the key lies in the left sorted part
                if (key >= arr[left] && key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // Else the right half must be sorted
            else {
                // If the key lies in the right sorted part
                if (key > arr[mid] && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // If the key is not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;

        int result = searchInRotatedArray(arr, key);
        System.out.println("Index of " + key + ": " + result);
    }
}
