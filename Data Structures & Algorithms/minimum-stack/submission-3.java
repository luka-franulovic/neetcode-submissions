class MinStack {

    private ArrayList<Integer> min;
    private int currentMin;
    private Stack<Integer> st;

    public MinStack() {
        st = new Stack<Integer>();
        min = new ArrayList<Integer>();
        currentMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        st.push(val);
        if (val <= currentMin){
            currentMin = val;
            min.add(val);
        }
    }
    
    public void pop() {
        if (st.empty()) throw new NullPointerException();
        int x = st.pop();
        if (x == currentMin){
            min.remove(min.size() - 1);
            if (min.isEmpty()){
                currentMin = Integer.MAX_VALUE;
            }
            else{
                currentMin = min.get(min.size() - 1);
            }
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return currentMin;
    }
}
