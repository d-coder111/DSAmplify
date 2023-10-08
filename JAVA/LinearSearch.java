import java.util.Scanner;

class linearsearch {
    public static void main(String args[]) {
        int a, n, search, array[];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements");
        n = in.nextInt();
        array = new int[n];

        System.out.println("Enter those " + n + " elements");

        for (a = 0; a < n; a++)
            array[a] = in.nextInt();

        System.out.println("Enter value to find");
        search = in.nextInt();

        for (a = 0; a < n; a++) {
            if (array[a] == search) {
                System.out.println(search + " is present at location " + (a + 1) + ".");
                break;
            }
        }
        if (a == n)
            System.out.println(search + " isn't present in array.");
    }
}