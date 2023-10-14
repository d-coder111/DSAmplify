/**
 * Java program to find the zeros (roots) of a polynomial using the Newton-Raphson method.
 */

public class PolynomialRoots {
    /**
     * Evaluate a polynomial function at a given value.
     *
     * @param coefficients An array of polynomial coefficients.
     * @param x            The value at which to evaluate the polynomial.
     * @return The result of evaluating the polynomial at x.
     */
    public static double evaluatePolynomial(double[] coefficients, double x) {
        double result = 0.0;
        int n = coefficients.length;

        for (int i = 0; i < n; i++) {
            result += coefficients[i] * Math.pow(x, n - i - 1);
        }

        return result;
    }

    /**
     * Calculate the derivative of a polynomial.
     *
     * @param coefficients An array of polynomial coefficients.
     * @return The coefficients of the derivative of the polynomial.
     */
    public static double[] calculateDerivative(double[] coefficients) {
        int n = coefficients.length;
        double[] derivative = new double[n - 1];

        for (int i = 0; i < n - 1; i++) {
            derivative[i] = coefficients[i] * (n - i - 1);
        }

        return derivative;
    }

    /**
     * Find an approximate zero (root) of a polynomial using the Newton-Raphson method.
     *
     * @param coefficients An array of polynomial coefficients.
     * @param x0           Initial guess for the root.
     * @param tolerance    Tolerance for the approximation.
     * @return An approximate zero (root) of the polynomial.
     */
    public static double newtonRaphson(double[] coefficients, double x0, double tolerance) {
        double x = x0;
        int maxIterations = 1000;
        int iterations = 0;

        while (Math.abs(evaluatePolynomial(coefficients, x)) > tolerance && iterations < maxIterations) {
            double[] derivative = calculateDerivative(coefficients);
            x = x - evaluatePolynomial(coefficients, x) / evaluatePolynomial(derivative, x);
            iterations++;
        }

        return x;
    }

    public static void main(String[] args) {
        // Define the coefficients of the polynomial (e.g., 3x^3 - 6x^2 + 2x - 1)
        double[] coefficients = {3, -6, 2, -1};

        // Initial guess for the root
        double x0 = 2.0;

        // Tolerance for the approximation
        double tolerance = 1e-6;

        // Find and print the approximate root
        double root = newtonRaphson(coefficients, x0, tolerance);
        System.out.println("Approximate root: " + root);
    }
}
