import java.util.HashSet;
import java.util.Set;


public class LeetCode128 {
    public int longestConsecutive(int[] nums){
        Set<Integer> num_set = new HashSet<Integer>();
        for(int num : nums){
            num_set.add(num);
        }

        int longestStreak = 0;

        for(int num : num_set){
            if(!num_set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while(num_set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args){
        LeetCode128 solution = new LeetCode128();

        int[] nums = {100,4,101,2,3,1};

        int result = solution.longestConsecutive(nums);
        System.out.println("最长连续序列的长度是：\n" + result);
    }
}
