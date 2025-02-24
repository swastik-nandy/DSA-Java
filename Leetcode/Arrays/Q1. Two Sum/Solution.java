import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the complement exists in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store the current number and its index in the map
            map.put(nums[i], i);
        }
        
        return new int[]{};  // Should never be reached as per problem constraints
    }
}
