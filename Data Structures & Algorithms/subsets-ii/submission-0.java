class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();
        helper(0, nums, result, current);
        return result;
    }

    private void helper(int index, int[] nums, List<List<Integer>> result, List<Integer> current)
    {
        if (index == nums.length)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        helper(index + 1, nums, result, current);
        current.remove(current.size() - 1);

        int j = index;
        while (j < nums.length && nums[j] == nums[index])
            j++;
        helper(j, nums, result, current);

        
    }
}
