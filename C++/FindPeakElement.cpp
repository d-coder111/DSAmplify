#include <bits/stdc++.h>
using namespace std;

int findPeakElement(int arr[], int n)
{
    int start = 0;
    int end = n - 1;
    while (start < end)
    {
        int mid = start + (end - start) / 2;
        if (arr[mid] > arr[mid + 1])
        {
            end = mid;
        }
        else
        {
            start = mid + 1;
        }
    }
    return start;
}

int main()
{
    int arr[] = {1000, 11, 445, 1, 330, 3000};
    int n = sizeof(arr) / sizeof(arr[0]);
    int ans = findPeakElement(arr, n);
    cout << "Index of the peak element of array [ 1000, 11, 445, 1, 330, 3000 ] is " << ans;
}