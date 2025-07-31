import java.util.*;

public class LeetCode136 {
    public int singleNumber(int[] nums){
        int single = 0;
        for(int num : nums){
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args){
        LeetCode136 solution = new LeetCode136();

        int []nums = {1,4,3,5,5,3,4};

        int result = solution.singleNumber(nums);
        System.out.println("只出现一次的数字是：\n" + result);
    }
}
