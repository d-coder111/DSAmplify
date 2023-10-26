public class GCD_and_LCM {
    // gcd = max {k>0 :a/k and b/k are integers}

    // If a and b are two non negative integers then the method to find the GCD
    // using brute force will be running a loop from 1 to min(a,b)
    // and return the maximum number which can divide both .
    // Time Complexity : O(small number)

    // It can be solved using Euclid's Division Rule: If gcd divides a and b then it also divides a-b.
    // Instead of subtraction here we can also use mod and is mathematically proved.
    // gcd (a,b) = a ; if b=0
    // gcd(b,a mod b) ; othereise

    // JAVA CODE:

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    // Time Complexity : O(min log(a,b))

    // Similary LCM can be defined as :
    // lcm (a,b) = a.b / gcd(a,b) ;

    // JAVA CODE:
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        int a = 16;
        int b = 4;
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }
}
