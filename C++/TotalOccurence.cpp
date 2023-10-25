// Here is the Link of Problem Statement : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

#include<bits/stdc++.h>
using namespace std;

int firstBinarySearch(int arr[],int n,int target){

    int start = 0;
    int end = n-1;

    int mid = (start + end)/2;
    int ans =-1;
    while(start<= end){
        if(arr[mid] == target){
            ans = mid;
            end = mid - 1;
        }
        else if(arr[mid] > target){
            end = mid - 1;
        }
        else{
            start = mid + 1;
        }
        mid = (start + end)/2;
    }

    return ans;
}

int lastBinarySearch(int arr[],int n,int target){

    int start = 0;
    int end = n-1;

    int mid = (start + end)/2;
    int ans =0 ;
    while(start<= end){
        if(arr[mid] == target){
            ans = mid;
            start = mid + 1;
        }
        else if(arr[mid] > target){
            end = mid - 1;
        }
        else{
            start = mid + 1;
        }
        mid = (start + end)/2;
    }

    return ans;
}

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

int main(){

    int arr[] = {10 , 20 ,30 ,30 ,30,30 ,40,50};
    int n = 8;
    int target ;
    cin>>target;

    cout<< lastBinarySearch(arr, n, target) - firstBinarySearch(arr, n ,target) + 1;
    return 0;
}