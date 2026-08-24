class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (matrix[mid][0] <= target && matrix[mid][matrix[0].length - 1] >= target){
                int low = 0;
                int high = matrix[0].length - 1;
                while (low <= high){
                    int midi = low + (high - low) / 2;
                    if (matrix[mid][midi] == target) return true;
                    if (matrix[mid][low] == target || matrix[mid][high] == target) return true; 
                    else{
                        if (matrix[mid][midi] > target) high = midi - 1;
                        else low = midi + 1;
                    }
                }
                break;
            }
            else{
                if (matrix[mid][0] > target){
                    hi = mid - 1;
                }
                else{
                    lo = mid + 1;
                }
            }
        }
        return false;
    }
}
