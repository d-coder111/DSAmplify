import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }
  
    //Cyclic Sort Algorithm
    static void cyclic(int[] array){
        int i=0;
        while(i<array.length){
            if(array[array[i]-1]!=array[i]){
                swap(array,i,array[i]-1);
            } else{
                i++;
            }
        }
    }
  
    //Helper Function to Swap Values
    static void swap(int[] arr , int first , int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
