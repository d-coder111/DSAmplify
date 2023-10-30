import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class next_smaller_left_array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nearestSmalllerLeft(new int[]{4,5,2,10,8})));
    }

    public static int[] nearestSmalllerLeft(int []nums){
        HashMap<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int num: nums){
            while(!stack.isEmpty() && num<stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                hm.put(num,-1);
            }
            else{
                hm.put(num,stack.peek());
            }
            stack.push(num);
        }

        int []ans = new int[nums.length];
        for(int j=0; j<nums.length;j++){
            ans[j]=hm.get(nums[j]);
        }
        return ans;
    }
}
