#include<bits/stdc++.h>
using namespace std;

bool ContainsDuplicate(int nums[],int n)
{
    bool flag =  false;
    unordered_map<int, int> mp;
    for (int i = 0; i < n; i++)
    {
        mp[nums[i]]++;
    }
    for (int i = 0; i < n; i++) {
      if (mp[nums[i]] > 1)
      {
          flag = true;
          return true;
      }
    }
    if(!flag){
        return false;
    }
}
int main()
{
    int nums1[]={1, 2, 3, 1};
    int n = sizeof(nums1) / sizeof(nums1[0]);
    cout<<"Input: nums = [1, 2, 3, 1]"<<endl;
    cout<<"Output: "<< (ContainsDuplicate(nums1,n)==1?"true":"false") <<endl;
    cout<<endl;

    int nums2[]={1, 2, 3, 4};
    n = sizeof(nums2) / sizeof(nums2[0]);
    cout<<"Input: nums = [1, 2, 3, 4]"<<endl;
    cout<<"Output: "<< (ContainsDuplicate(nums2,n)==1?"true":"false") <<endl;
    cout<<endl;

    int nums3[]={1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
    n = sizeof(nums3) / sizeof(nums3[0]);
    cout<<"Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]"<<endl;
    cout<<"Output: "<< (ContainsDuplicate(nums3,n)==1?"true":"false")<<endl;
    cout<<endl;

}