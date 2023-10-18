import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    // Method to perform the quicksort
    static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int mid = s + (e - s) / 2;
        int pivot = nums[mid];

        while (s <= e) {
            // Move the 's' pointer to the right until finding a value >= pivot
            while (nums[s] < pivot) {
                s++;
            }
            // Move the 'e' pointer to the left until finding a value <= pivot
            while (nums[e] > pivot) {
                e--;
            }
            if (s <= e) {
                // Swap the values at 's' and 'e' because they are in the wrong order
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        // Recursively sort the left and right subarrays
        sort(nums, low, e); // Sort the left subarray
        sort(nums, s, high); // Sort the right subarray
    }
}
