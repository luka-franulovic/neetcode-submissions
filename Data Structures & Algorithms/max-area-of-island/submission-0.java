class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                int area = 0;
                if (grid[i][j] == 1)
                    area = dfs(i, j, grid);
                
                if (area > maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid)
    {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        
        if (grid[i][j] == 0)
            return 0;
        
        grid[i][j] = 0;
        int area = 1;

        area += dfs(i - 1, j, grid);
        area += dfs(i, j - 1, grid);
        area += dfs(i + 1, j, grid);
        area += dfs(i, j + 1, grid);

        return area;
    }
}
