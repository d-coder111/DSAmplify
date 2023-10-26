//Description:- Leetcode 1095 Hard question.
// (This problem is an interactive problem.)

// You may recall that an array arr is a mountain array if and only if:

// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

// Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
// You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

// MountainArray.get(k) returns the element of the array at index k (0-indexed).
// MountainArray.length() returns the length of the array.
// Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.


//Link :- 
// https://leetcode.com/problems/find-in-mountain-array/description/

//Solution:- 
//Approach:-
// we have to find the element in the Mountain array.
// We are also given that duplicate elements can also be present.
// So for doing this, first we will find out the Peak element or the Mountain element in the array.
// Then, we will apply binary search in the left side and right side of the peak element.
// And then if we find the element in both the halves, return the indice of left half.
// If not found in left half, return the indice of right half,
// Else return -1 as we didn't find the target element.

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */


public class Find_In_MountainArray {
    public int findPeak(MountainArray arr)
    {
        int start=0;
        int end=arr.length()-1;
        int mid=0;
        while(start<end)
        {
            mid=start+(end-start)/2;
            if(arr.get(mid)<arr.get(mid+1))
            {
                start=mid+1;
            }
            else
            {
                end=mid;
            }
        }
        return end;
    }
    public int binarySearchLeft(MountainArray arr,int target,int start,int end)
    {
        int low=start;
        int high=end;
        int mid=0;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(arr.get(mid)==target)
            {
                return mid;
            }
            else if(arr.get(mid)<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }

    public int binarySearchRight(MountainArray arr,int target,int start,int end)
    {
        int low=start;
        int high=end;
        int mid=0;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(arr.get(mid)==target)
            {
                return mid;
            }
            else if(arr.get(mid)<target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex=findPeak(mountainArr);
        int minIndex=binarySearchLeft(mountainArr,target,0,peakIndex);
        int maxIndex=binarySearchRight(mountainArr,target,peakIndex+1,mountainArr.length()-1);
        if(minIndex!=-1)
        {
            return minIndex;
        }
        else if(maxIndex!=-1)
        {
            return maxIndex;
        }
        else
        {
            return -1;
        }
    
    }
}
