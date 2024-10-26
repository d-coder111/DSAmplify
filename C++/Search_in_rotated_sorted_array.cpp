#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n = nums.size();

        // Edge case: if the array has only two elements
        if (n == 2) {
            if (target == nums[0]) return 0;
            else if (target == nums[1]) return 1;
            else return -1;
        }

        // Find the pivot point where the rotation happens
        int lo = 0;
        int hi = n - 1;
        int pivot = -1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // Check if we are at the beginning or end of the array
            if (mid == 0) lo = mid + 1;
            else if (mid == n - 1) hi = mid - 1;

            // Check if mid is the pivot point
            else if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                pivot = mid;
                break;
            }
            else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                pivot = mid + 1;
                break;
            }

            // Adjust the search range
            else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        // If no pivot was found, perform normal binary search
        if (pivot == -1) {
            lo = 0;
            hi = n - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return -1;
        }

        // Binary search in the left half
        if (target >= nums[0] && target <= nums[pivot - 1]) {
            lo = 0;
            hi = pivot - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        // Binary search in the right half
        else {
            lo = pivot;
            hi = n - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }
};

int main() {
    Solution sol;
    vector<int> nums = {4, 5, 6, 7, 0, 1, 2};
    int target = 0;

    int result = sol.search(nums, target);
    if (result != -1) {
        cout << "Target " << target << " found at index: " << result << endl;
    } else {
        cout << "Target " << target << " not found in the array." << endl;
    }

    return 0;
}
