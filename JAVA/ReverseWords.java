import java.util.*;

class ReverseWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(reverse(s));
        sc.close();
    }

    public static String reverse(String s) {
        String[] s2 = s.trim().split("\\s+");
        String s3 = "";
        for (int i = s2.length - 1; i > 0; i--) {
            s3 += s2[i] + " ";
        }
        return s3 + s2[0];
    }
}