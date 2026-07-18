class MinStack {
    private Stack<Long> st;
    private long minEle;

    public MinStack() {
        st = new Stack<>();
        minEle = -1;
    }

    public void push(int x) {
        // Explicitly cast to long to prevent expression overflow
        long val = (long) x; 
        
        if (st.isEmpty()) {
            minEle = val;
            st.push(val);
        }
        // If the new number is less than the current minimum
        else if (val < minEle) {
            // Formula requires 64-bit math to prevent integer wrap-around
            st.push(2 * val - minEle);
            minEle = val;
        } else {
            st.push(val);
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        long top = st.pop();

        // If the popped value is less than minEle, it is a flag representing the old minimum
        if (top < minEle) {
            minEle = 2 * minEle - top;
        }
    }

    public int top() {
        if (st.isEmpty()) return -1;

        long top = st.peek();

        // If top is less than minEle, the actual value at the top is minEle itself
        if (top < minEle) {
            return (int) minEle;
        } else {
            return (int) top;
        }
    }

    public int getMin() {
        if (st.isEmpty()) return -1;
        return (int) minEle;
    }
}
