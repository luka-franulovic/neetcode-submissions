class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        for (String s : tokens){
            if (s.equals("+") || s.equals("-") || s.equals("*")|| s.equals("/")){
                int x = st.pop();
                int y = st.pop();
                if (s.equals("+")){
                    st.push(x + y);
                }
                else if (s.equals("-")){
                    st.push(y - x);
                }
                else if (s.equals("*")){
                    st.push(x * y);
                }
                else{
                    st.push(y / x);
                }
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
