class Solution {
    public void rotate(int[] nums, int k) {
        int steps = k % nums.length;
        System.out.println(steps);
        int[] arr = new int[nums.length];
        for (int i = nums.length - steps; i < nums.length; i++)
        {
            arr[i - (nums.length - steps)] = nums[i];
        }
        for (int i = 0; i < nums.length - steps ; i++)
        {
            arr[i + steps] = nums[i];
        }
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = arr[i];
        }
    }
}