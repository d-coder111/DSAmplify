// Description :-
// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

//Link :- https://leetcode.com/problems/search-in-rotated-sorted-array/description/

//Solution:-
//whenever we are given a sorted array use of applying binary search in the array to find the target.
//Now in this question, first we will find out the pivot index at which the array is rotated.
//Then we will apply binary search in left half and right half of the pivot index.

//Now to find the pivot index :- 

class Solution {
    public static int pivotElement(int []arr)
    {
        int start=0;
        int end=arr.length-1;
        int mid=0;
        while(start<end)
        {
            mid=start+(end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1])    
            {
                //if mid<end i.e., in array's range and the mid element is greater than mid+1 element, then it violates the ascending order of the array, so this is our pivot index (mid).
                return mid;
            }
            if(mid>start && arr[mid]<arr[mid-1]) 
            {
                //if mid<end i.e., in array's range and the mid element is smaller than mid-1 element, then it violates the ascending order of the array, so this is our pivot index (mid-1).
                return mid-1;
            }
            if(arr[start]>=arr[mid])
            {
                //if mid element is smaller than or equal to the start element, this means that the pivot element will be in left half because 
                //lets understaand through eg : - nums = [4,5,6,7,0,1,2] start = 2 end = 6 mid=(2+6)/2 = 4.
                //now a[start=2]>a[mid=4] i.e., 6>0 true this means that ascending order does not hold for elements in between start and mid so we should search the left half.
                end=mid-1;
            }
            else
            {
                //lets understaand through eg : - nums = [4,5,6,7,0,1,2] mid=(0+6)/2 = 3.
                //now a[start=0]>a[mid=3] i.e., 4>7 false this means that ascending order holds for every element in between start and mid so we should search the right half.
                start=mid+1;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int arr[],int target,int start,int end)
    {
        int low=start;
        int high=end;
        int mid=0;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            else if(arr[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;  //return -1 if the pivot is not found, this means that array is not rotated.
    }
    
    public static int search(int[] nums, int target) {
        int pivot=pivotElement(nums);
        int ans=0;
        if(pivot==-1)  //if array is not rotated than simply apply binary search in the whole array
        {
            ans=binarySearch(nums,target,0,nums.length-1);
        }
        else
        {
            //else apply in 0 to pivot i.e., left half.
            ans=binarySearch(nums,target,0,pivot);
            if(ans==-1)
            {
                //if ans is not found in 0 to pivot, then apply in pivot+1 to end i.e., right half.
                ans=binarySearch(nums,target,pivot+1,nums.length-1);
            }
            
        }
        
        return ans;
    }
}

public class Search_In_Rotated_Sorted_Array {

    public static void main(String[] args) {
        
        //Test cases :-

        // Input: nums = [4,5,6,7,0,1,2], target = 0
        // Output: 4
        // Example 2:

        // Input: nums = [4,5,6,7,0,1,2], target = 3
        // Output: -1
        // Example 3:

        // Input: nums = [1], target = 0
        // Output: -1

        int []nums = {4,5,6,7,0,1,2};
        Solution s=new Solution();
        System.out.println(s.search(nums, 0));
    }
}