#include <iostream>
#include <vector>

void merge(std::vector<int>& arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    std::vector<int> leftSubarray(n1);
    std::vector<int> rightSubarray(n2);

    for (int i = 0; i < n1; i++) {
        leftSubarray[i] = arr[left + i];
    }

    for (int i = 0; i < n2; i++) {
        rightSubarray[i] = arr[mid + 1 + i];
    }

    int i = 0, j = 0, k = left;

    while (i < n1 && j < n2) {
        if (leftSubarray[i] <= rightSubarray[j]) {
            arr[k] = leftSubarray[i];
            i++;
        } else {
            arr[k] = rightSubarray[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = leftSubarray[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = rightSubarray[j];
        j++;
        k++;
    }
}

void mergeSort(std::vector<int>& arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

int main() {
    std::vector<int> arr = {12, 11, 13, 5, 6, 7};

    std::cout << "Original array: ";
    for (int num : arr) {
        std::cout << num << " ";
    }

    mergeSort(arr, 0, arr.size() - 1);

    std::cout << "\nSorted array: ";
    for (int num : arr) {
        std::cout << num << " ";
    }

    return 0;
}
