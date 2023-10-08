//Link:-https://leetcode.com/problems/find-peak-element/

class FindPeakElement {
    public static int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        int ans = findPeakElement(arr);
        System.out.println("Index of the peak element of array [ 1000, 11, 445, 1, 330, 3000 ] is " + ans);
    }
}