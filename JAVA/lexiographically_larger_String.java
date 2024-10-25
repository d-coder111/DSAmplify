import java.util.Scanner;

public class lexiographically_larger_String{
    public static void main(String[] args) {
       
        String s="Ram";
        String s2="Shyam";
        if(s.compareTo(s2)>0){
            System.out.println(s2+" is lesser than "+s);
        }
        else if(s.compareTo(s2)<0){
            System.out.println(s+" is Greater than "+s2);
        }
        else{
            System.out.println("Both are equal");
        }

    }
}