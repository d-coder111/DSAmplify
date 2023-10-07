import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    
    /**
     * This method takes an integer array as input and determines whether it contains any duplicate elements.
     *
     * Input:
     * - nums: An array of integers where each element represents a value.
     *
     * Output:
     * - Returns true if the input array 'nums' contains at least one duplicate element, indicating that there are
     *   two or more identical values within the array. Otherwise, it returns false, indicating that all elements
     *   in the array are distinct, with no duplicates.
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : nums) {
            if (uniqueElements.contains(num)) {
                return true;
            }
            uniqueElements.add(num);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input: nums = [1, 2, 3, 1]");
        System.out.println("Output: " + containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("\nInput: nums = [1, 2, 3, 4]");
        System.out.println("Output: " + containsDuplicate(nums2));

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("\nInput: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]");
        System.out.println("Output: " + containsDuplicate(nums3));
    }

    
}
