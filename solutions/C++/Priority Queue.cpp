#include <iostream>
#include <vector>
#include <queue>

int findKthLargest(std::vector<int>& nums, int k) {
    // Create a max-heap priority queue
    std::priority_queue<int> maxHeap;

    // Populate the priority queue with the elements from the array
    for (int num : nums) {
        maxHeap.push(num);
    }

    // Extract the kth largest element
    for (int i = 1; i < k; i++) {
        maxHeap.pop(); // Discard the largest (k-1) elements
    }

    return maxHeap.top(); // The top element is the kth largest
}

int main() {
    std::vector<int> nums = {3, 2, 1, 5, 6, 4};
    int k = 2; // Find the 2nd largest element

    int kthLargest = findKthLargest(nums, k);
    std::cout << "The " << k << "th largest element is: " << kthLargest << std::endl;

    return 0;
}
