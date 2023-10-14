/**
 * Java program to calculate Euler's Totient Function (Phi function).
 */

public class EulerTotientFunction {
    /**
     * Calculate Euler's Totient Function (Phi function) for a given integer n.
     *
     * @param n The integer for which Phi function is calculated.
     * @return The Phi function value for n.
     */
    public static int eulerTotientFunction(int n) {
        int result = n; // Initialize result as n

        // Consider all prime factors of n and subtract their multiples from result
        for (int p = 2; p * p <= n; ++p) {
            // Check if p is a prime factor of n
            if (n % p == 0) {
                // If yes, then update n and result
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }

        // If n has a prime factor greater than sqrt(n), it contributes to Phi
        if (n > 1) {
            result -= result / n;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        int phi = eulerTotientFunction(n);

        System.out.println("Phi(" + n + ") = " + phi);
    }
}
