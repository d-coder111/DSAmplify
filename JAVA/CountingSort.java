import java.util.Arrays;

public class CountingSort {
    /**
     * Counting Sort algorithm for sorting an array of integers.
     *
     * @param arr The input array to be sorted.
     * @return A new sorted array.
     */
    public static int[] countingSort(int[] arr) {
        // Find the maximum value in the input array
        int max = Arrays.stream(arr).max().getAsInt();

        // Create a counting array to store the count of each element
        int[] countArray = new int[max + 1];

        // Count the occurrences of each element in the input array
        for (int num : arr) {
            countArray[num]++;
        }

        // Calculate the cumulative count for each element
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Create the output array
        int[] sortedArray = new int[arr.length];

        // Build the sorted array using the counting array
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            int index = countArray[num] - 1;
            sortedArray[index] = num;
            countArray[num]--;
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        int[] sortedArray = countingSort(arr);

        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
}
