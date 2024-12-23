import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static List<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;

        // Step 1: Sort the intervals by their start times
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Create a list to store the merged intervals
        List<int[]> res = new ArrayList<>();

        // Step 3: Traverse through the intervals
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            // If the list is empty or no overlap with the last interval, add the current interval
            if (res.isEmpty() || res.get(res.size() - 1)[1] < start) {
                res.add(new int[]{start, end});
            } else {
                // If there is overlap, merge intervals by updating the end time
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], end);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        List<int[]> result = mergeOverlap(arr);

        // Print the merged intervals
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

