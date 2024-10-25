public class OrderAgnosticBS {

	public static void main(String[] args) {

		int[] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3};
        int target = 22;
		int ans=orderAgnosticsBS(arr, target);
		System.out.println(ans);

	}
	
	static int orderAgnosticsBS(int[] arr,int target) {
		int start=0;
		int end=arr.length-1;
		
		//find whether the array is sorted in ascending or descending
		boolean isAsc=arr[start]<arr[end];
//		if(arr[start]<arr[end]) {
//			isAsc=true;
//		}
//		else {
//			isAsc=false;
//		}
		
		while(start<=end) {
			//find the middle element
//			int mid=(start+end)/2;// might be possible that (start+end) exceeds the range of int in java
			
			int mid=start+(end-start)/2;
			
			if(arr[mid]==target) {
				return mid;
			}
			if(isAsc) {
				if(target<arr[mid]) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
			else {
				if(target>arr[mid]) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
			
			
			
		}
		
		return -1;
	}

}
