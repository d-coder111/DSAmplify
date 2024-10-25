import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class next_smaller_right_array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nearestSmalllerRight(new int[]{4,5,2,10,8})));
    }
    public static int[] nearestSmalllerRight(int []nums){
        HashMap<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int num :nums){
            while(!stack.isEmpty() && stack.peek()>num){
                hm.put(stack.pop(),num);
            }
            stack.push(num);
        }

        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            ans[i] = hm.getOrDefault(nums[i],-1);
        }
        return ans;
    }
}
