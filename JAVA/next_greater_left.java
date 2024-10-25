import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class next_greater_left {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nearestgreaterLeft(new int[]{9,4,15,6,2,10})));
    }
    public static int[] nearestgreaterLeft(int []nums){
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums){
            while (!stack.isEmpty() && num > stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty()){
                hm.put(num,stack.peek());
            }
            else{
                hm.put(num,-1);
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
