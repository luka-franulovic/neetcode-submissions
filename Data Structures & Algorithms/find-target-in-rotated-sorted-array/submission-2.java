class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]){
                lo = mid + 1;
            }
            else{
                hi = mid;
            }
        }
        if (target < nums[nums.length - 1]){
            hi = nums.length - 1;
            while (lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] < target) lo = mid + 1;
                else if (nums[mid] > target) hi = mid - 1;
                else return mid;
            }
        }
        else if (target == nums[nums.length - 1]) return nums.length - 1;
        else{
            hi = lo;
            lo = 0;
            while (lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] < target) lo = mid + 1;
                else if (nums[mid] > target) hi = mid - 1;
                else return mid;
            }
        }
        return -1;
    }
}
