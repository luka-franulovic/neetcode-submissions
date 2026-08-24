class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) return false;
        HashSet<Integer> map = new HashSet<Integer>();
        for (int i = 0; i <= Math.min(nums.length - 1, k); i++){
            if (map.contains(nums[i])) return true;
            else map.add(nums[i]);
        }
        for (int i = k + 1; i < nums.length; i++){
            map.remove(nums[i - k - 1]);
            if (map.contains(nums[i])) return true;
            else map.add(nums[i]);
        }
        return false;
    }
}