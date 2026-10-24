class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();
        int currentSum = 0;
        helper(0, nums, result, current, currentSum, target);
        return result;
    }

    private void helper(int i, int[] nums, List<List<Integer>> result, List<Integer> current, int currentSum, int target){
        if (currentSum > target)
            return;
        if (currentSum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int j = i; j < nums.length; j++){
            current.add(nums[j]);
            helper(j, nums, result, current, currentSum + nums[j], target);
            current.remove(current.size() - 1);
        }
    }
}
