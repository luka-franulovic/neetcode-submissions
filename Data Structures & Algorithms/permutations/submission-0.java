class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();
        helper(nums, result, current);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> perms, List<Integer> current)
    {
        if (current.size() == nums.length)
        {
            perms.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if (current.contains(nums[i])) continue;
            current.add(nums[i]);
            helper(nums, perms, current);
            current.remove(current.size() - 1);
        }
    }
}
