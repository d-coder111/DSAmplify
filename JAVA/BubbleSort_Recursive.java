import java.util.Arrays;

public class BubbleSort_Recursive{
    public static void main(String[] args) {
         int[]array={1,6,2,3,0};
         bubblesort(array, array.length-1, 0);
         System.out.println(Arrays.toString(array));
    }
   private static  void bubblesort(int[]array,int last,int first){
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