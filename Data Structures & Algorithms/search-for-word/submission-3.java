class Solution {
    private boolean found = false;
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (found)
                    break;
                if (board[i][j] == word.charAt(0))
                    dfs(i, j, 0, board, word);
            }
            if (found)
                break;
        }
        return found;
    }

    private void dfs(int i, int j,int indexInWord, char[][] board, String word)
    {
        if (found)
            return;
        if (board[i][j] != word.charAt(indexInWord))
            return;
        if (indexInWord == word.length() - 1)
        {
            found = true;
            return;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        // one above
        if (i > 0)
            dfs(i - 1, j, indexInWord+1, board, word);
        
        // one under
        if (i < board.length - 1)
            dfs(i + 1, j, indexInWord+1, board, word);
        
        // one to the left
        if (j > 0)
            dfs(i, j - 1, indexInWord+1, board, word);
        
        // one to the right
        if (j < board[0].length - 1)
            dfs(i, j + 1, indexInWord+1, board, word);
        
        board[i][j] = temp;
    }
}
