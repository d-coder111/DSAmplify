public class Binary_Search_Recursion {
    
    public static void main(String[] args) {
        int[]array={2,3,4,5,6};
        System.out.println(indx(array,3,0,array.length-1));
    }
    static int indx(int[]array,int target,int start,int end){
        int mid=start+(end-start)/2;
        if(start>end) {
            return -1;
        }
        if(array[mid]==target){
            return mid;
        }
        if(array[mid]>target){
            return indx(array,target,start,mid-1);
        }
        return indx(array,target,mid+1,end);

    }
}
