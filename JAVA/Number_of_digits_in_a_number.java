public class Number_of_digits_in_a_number {
    public static void main(String[] args) {
        int num=100;
        System.out.println(nums(num));
        System.out.println(numberss(num));
        System.out.println(nuoms(num));
    }
    static int nums(int num){
        return (int)Math.log10(num)+1;
    }

    static int numberss(int num){
        String s = Integer.toString(num);
        return s.length();

    }
    static int nuoms(int n){
        int count=0;
        while(n>0){
            int remainder=n%10;
            count++;
            n=n/10;
        }
        return count;
    }
}
