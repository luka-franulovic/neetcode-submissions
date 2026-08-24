class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            table.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int difference = target - nums[i];
            if (table.containsKey(difference) && table.get(difference) != i){
                indexes[0] = i;
                indexes[1] = table.get(difference);
                return indexes;
            }
        }
        return indexes;
    }
}
