import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class next_greater_element_array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nearestGraterRight(new int[]{1,3,4,2})));
    }
    public static int[] nearestGraterRight(int nums[]){
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hm =new HashMap<>();

        for(int elt: nums){
            while(!stack.isEmpty() && elt> stack.peek()){
                hm.put(stack.pop(),elt);
            }
            stack.push(elt);
        }

        int []ans = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            ans[i] = hm.getOrDefault(nums[i],-1);
        }
        return ans;
    }
}
