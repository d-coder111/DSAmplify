import java.util.Arrays;
import java.util.List;

/**
 * This class provides methods to sum elements of a list.
 */
public class SumListIterative {

    /**
     * Sums the elements of a list of integers.
     *
     * @param list the list of integers
     * @return the sum of the elements in the list
     */
    public static int sumInt(List<Integer> list) {
        int sum = 0;

        for (int number : list) 
            sum += number;
        
        return sum;
    }

    /**
     * Sums the elements of a list of longs.
     *
     * @param list the list of longs
     * @return the sum of the elements in the list
     */
    public static Long sumLong(List<Long> list) {
        Long sum = 0L;

        for (Long number : list) 
            sum += number;
        
        return sum;
    }

    /**
     * Sums the elements of a list of doubles.
     *
     * @param list the list of doubles
     * @return the sum of the elements in the list
     */
    public static Double sumDouble(List<Double> list) {
        Double sum = 0.0;

        for (Double number : list) 
            sum += number;
        
        return sum;
    }

    public static void main(String[] args) {
        
        // Test for sumInt method
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Sum of integers: " + sumInt(intList)); // Expected output: 15

        // Test for sumLong method
        List<Long> longList = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        System.out.println("Sum of longs: " + sumLong(longList)); // Expected output: 15

        // Test for sumDouble method
        List<Double> doubleList = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        System.out.println("Sum of doubles: " + sumDouble(doubleList)); // Expected output: 15.0
    }
}
