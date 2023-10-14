 /**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n = (int)nums1.size(), m = (int)nums2.size(), mid = (m+n+1)/2 - 1;
        int l1 = 0 , r1 = n, l2 = 0, r2 = m;
        while(mid>0){
            int temp = (mid+1)/2;
            if((l2==m) || (l1<n && nums1[min(n-1,l1+temp-1)]<=nums2[min(m-1,l2+temp-1)])){
                mid -= min(n-1,l1+temp-1) - l1 + 1;
                l1+=temp;
                l1 = min(n,l1);
            }
            else{
                mid-= min(m-1,l2+temp-1) - l2 + 1;
                l2+=temp;
                l2 = min(m,l2);
            }
        }
        vector<int> a;
        a.push_back((l1<n?nums1[l1]:1e8));
        a.push_back((l2<m?nums2[l2]:1e8));
        a.push_back((l1+1<n?nums1[l1+1]:1e8));
        a.push_back((l2+1<m?nums2[l2+1]:1e8));
        sort(a.begin(),a.end());
        if((m+n)%2==0)
            return ((double)a[0]+a[1])/2;
        else return a[0];
    }
};
