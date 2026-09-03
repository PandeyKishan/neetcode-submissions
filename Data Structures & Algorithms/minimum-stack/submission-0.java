class MinStack {
    private Stack<Integer> st;
    private int minEle;

    public MinStack() {
        st = new Stack<>();
        minEle = -1;
    }

    // Add an element to the top of stack
    public void push(int x) {
        if (st.isEmpty()) {
            minEle = x;
            st.push(x);
        }
        // If new number is less than minEle
        else if (x < minEle) {
            st.push(2 * x - minEle);
            minEle = x;
        } else {
            st.push(x);
        }
    }

    // Remove the top element from the stack
    public void pop() {
        if (st.isEmpty()) return;

        int top = st.pop();

        // Minimum will change if min element is removed
        if (top < minEle) {
            minEle = 2 * minEle - top;
        }
    }

    // Return top element of the stack
    public int top() {
        if (st.isEmpty()) return -1;

        int top = st.peek();

        // If minEle > top, minEle stores value of top
        return (minEle > top) ? minEle : top;
    }

    // Return minimum element of the stack
    public int getMin() {
        if (st.isEmpty()) return -1;

        // variable minEle stores the minimum element
        return minEle;
    }
}
