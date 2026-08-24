class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int current = nums[i];
            int target = 0 - current;
            int left = i+1;
            int right = nums.length - 1;
            while (left < right){
                if (nums[left] + nums[right] == target){
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(current);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
}