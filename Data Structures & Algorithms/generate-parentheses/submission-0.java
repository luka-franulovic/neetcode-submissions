class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        helper(0, 0, n, result, current);
        return result;
    }

    private void helper(int open, int closed,int n, List<String> result, StringBuilder current)
    {
        if (open == closed && open == n)
        {
            result.add(current.toString());
            return;
        }

        if (open < n)
        {
            current.append("(");
            helper(open + 1, closed, n, result, current);
            current.deleteCharAt(current.length() - 1);
        }
        if (closed < n && closed < open)
        {
            current.append(")");
            helper(open, closed + 1, n, result, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
