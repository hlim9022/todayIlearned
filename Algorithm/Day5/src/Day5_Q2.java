import java.util.*;

public class Day5_Q2 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        if (set.size() >= nums.length / 2) return answer = nums.length / 2;
        else return set.size();
    }
}
