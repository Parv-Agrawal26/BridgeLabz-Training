import java.util.HashMap;
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (hm.containsKey(num) && hm.get(num) != i) {
                ans[0] = i;
                ans[1] = hm.get(num);
                return ans;
            }
        }
        return ans;
    }
}