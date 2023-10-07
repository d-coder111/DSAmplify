import java.util.ArrayList;
import java.util.List;

public class SumListRecursively {

    /**
     * This method uses recursion to find the sum of a list of Integers
     */
    public static int sumIntRecursively(List<Integer> list) {
        if (list.isEmpty()) 
            return 0;
            
        return list.get(0) + sumIntRecursively(list.subList(1, list.size()));
    }

    /**
     * This method uses recursion to find the sum of a list of Longs
     */
    public static Long sumLongRecursively(List<Long> list) {
        if (list.isEmpty()) 
            return 0L;
            
        return list.get(0) + sumLongRecursively(list.subList(1, list.size()));
    }

    /**
     * This method uses recursion to find the sum of a list of Doubles
     */
    public static Double sumDoubleRecursively(List<Double> list) {
        if (list.isEmpty()) 
            return 0.0;
            
        return list.get(0) + sumDoubleRecursively(list.subList(1, list.size()));
    }




    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        listOfIntegers.add(4);
        listOfIntegers.add(5);
        System.out.println("The sum of the Integer list is: " + sumIntRecursively(listOfIntegers));

        List<Long> listOfLongs = new ArrayList<>();
        listOfLongs.add(1L);
        listOfLongs.add(2L);
        listOfLongs.add(3L);
        listOfLongs.add(4L);
        listOfLongs.add(5L);
        System.out.println("The sum of the Long list is: " + sumLongRecursively(listOfLongs));

        List<Double> listOfDoubles = new ArrayList<>();
        listOfDoubles.add(1.1);
        listOfDoubles.add(2.2);
        listOfDoubles.add(3.3);
        listOfDoubles.add(4.4);
        listOfDoubles.add(5.5);
        System.out.println("The sum of the Double list is: " + sumDoubleRecursively(listOfDoubles));
    }
}
