import java.util.Arrays;

public class BubbleSort_Recursion {
    public static void main(String[] args) {
         int[]array={8,1,20,9};
         bubblesort(array, array.length-1, 0);
         System.out.println(Arrays.toString(array));
    }
    static  void bubblesort(int[]array,int last,int first){
        if(last==0){
            return ;
        }
        if(first<last){
            if(array[first]>array[first+1]){
                int temp=array[first];
                array[first]=array[first+1];
                array[first+1]=temp;
            }
            bubblesort(array,last,first+1);
        }
        else{
            bubblesort(array,last-1,0);
        }
    }
}
