class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char x : s.toCharArray()){
            if (x == '(' || x == '[' || x == '{'){
                st.push(x);
            }
            else if ((x == ')' || x == ']' || x == '}') && !st.empty()){
                char c = st.pop();
                if ((x == ')' && c != '(') || (x == ']' && c != '[') || (x == '}' && c != '{')){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        if (st.empty()) return true;
        else return false;
    }
}
