class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int curJump = nums[0];

        for (int n : nums){
            if (curJump == 0) return false;
            curJump--;
            curJump = Math.max(curJump, n);
        }

        return true;
    }
}
