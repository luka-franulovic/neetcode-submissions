class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();
        helper(0, nums, solution, current);
        return solution;
    }

    private void helper(int i, int[] nums,List<List<Integer>> subsets, List<Integer> current){
        if (i == nums.length){
            subsets.add(new ArrayList<>(current));
            return;
        }
        helper(i+1, nums, subsets, current);
        current.add(nums[i]);
        helper(i+1, nums, subsets, current);
        current.remove(current.size() - 1);
    }
}
