import java.util.Scanner;

public class primeno {
     public static void primenofinder(int n)
        {
            boolean isPrime = true;
            for(int i=2; i<=n/2; i++) {
                if(n % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                if(n == 1) {
                    System.out.println("This is neither prime not composite");
                } else {
                    System.out.println("This is a prime number");
                }
            } else {
                System.out.println("This is not a prime number");
            }

        }

        public static void main(String[] args)
        {   int a=5;
            primenofinder(a);

        }
    
}
