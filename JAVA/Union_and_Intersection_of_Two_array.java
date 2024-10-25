import java.util.HashSet;

public class Union_and_Intersection_of_Two_array{
    public static int union(int[]array1,int []array2){
        HashSet<Integer>hm=new HashSet<>();
        for(int i=0;i<array1.length;i++){
            hm.add(array1[i]);
        }
        for(int i=0;i< array2.length;i++){
            hm.add(array2[i]);
        }
        return hm.size();
    }
    public static int intersection(int[]array1,int []array2){
        HashSet<Integer>hm=new HashSet<>();
        for(int i=0;i<array1.length;i++){
            hm.add(array1[i]);
        }
        int count=0;
        for(int i=0;i< array2.length;i++){
            if(hm.contains(array2[i])){
                count++;
                hm.remove(array2[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[]array1={7,3,9};
        int[]array2={6,3,9,2,9,4};
        System.out.println(union(array1,array2));
        System.out.println(intersection(array1,array2));
    }
}

